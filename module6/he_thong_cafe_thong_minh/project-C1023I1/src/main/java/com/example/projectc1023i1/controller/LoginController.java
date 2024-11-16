package com.example.projectc1023i1.controller;

import com.example.projectc1023i1.Dto.SendCodeDTO;
import com.example.projectc1023i1.Dto.UserDTO;
import com.example.projectc1023i1.Dto.UserLoginDTO;
import com.example.projectc1023i1.config.ModelMapperConfig;
import com.example.projectc1023i1.model.SendCode;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.respone.*;
import com.example.projectc1023i1.service.product.impl.TokenService;
import com.example.projectc1023i1.service.user.ISendCodeService;
import com.example.projectc1023i1.service.user.IUserService;
import com.example.projectc1023i1.service.user.impl.EmailSenderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class    LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ISendCodeService sendCodeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final TokenService tokenService;

    public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    /**
     * Xử lý yêu cầu đăng nhập của người dùng.
     *
     * @param userLoginDTO Đối tượng chứa thông tin đăng nhập của người dùng, bao gồm tên tài khoản và mật khẩu.
     * @param bindingResult Chứa kết quả của quá trình validate và ràng buộc dữ liệu từ form đăng nhập.
     * @return Trả về ResponseEntity với các trạng thái sau:
     *         - BadRequest (400) nếu như mật khẩu đã hết hạn quá 30 ngày.
     *         - BadRequest (400) nếu dữ liệu đăng nhập không hợp lệ (validate thất bại).
     *         - NotFound (404) nếu không tìm thấy tên tài khoản trong hệ thống.
     *         - Ok (200) nếu đăng nhập thành công và trả về thông tin người dùng cùng token.
     *         - InternalServerError (500) nếu có lỗi xảy ra trong quá trình xử lý.
     */
    @PostMapping( value = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO,
                                   BindingResult bindingResult) {
        try {
            Optional<Users> optionalUser = userService.findByUsername(userLoginDTO.getUsername());
            if (!optionalUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Khong tim thay nguoi dung");
            }
            Users users = optionalUser.get();
            String token =   userService.login(userLoginDTO.getUsername(),userLoginDTO.getPassword());
            if (userService.isPasswordExpired(users)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ChangePasswordRespone.builder()
                        .message("Mat khau ban da qua han 30 ngay can thay doi lai mat khau")
                        .oldPassword(users.getPassword())
                        .username(userLoginDTO.getUsername())
                        .build());
            }
            return ResponseEntity.ok().body(UserRespone.builder()
                    .token(token)
                    .message("Ban da dang nhap thanh cong")
                    .role(users.getRole())
                    .userDTO(userService.ConverDTO(users))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * dùng để thay đổi password
     * @param username tên tài khoản của người dùng
     * @param passwordChange mật khẩu thay đổi
     * @return Ok (200) nếu thay đổi mật khẩu thành công
     */
    @PostMapping("/verify/change-password")
    public ResponseEntity<?> changePassword(
            @RequestParam("username") String username,
            @RequestParam("passwordChange") String passwordChange
    ) {
        Users users = userService.findByUsername(username).get();
        if (users ==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Khong tim thay nguoi dung");
        }
        users.setPassword(passwordChange);
        String token = userService.updatePassword(users);
        return ResponseEntity.ok(UserRespone.builder()
                .message("da cap nhat mat khau thanh cong")
                .userDTO(userService.ConverDTO(users))
                .token(token)
                .build());
    }


    /**
     *  dùng để tạo ra 1 tài khoản user
     * @param userDTO chứa thông tin của người của người dùng tạo tài khoản
     * @param bindingResult chứa kết quả của quá trình validate và ràng buộc dữ liệu
     * @param request là đối tượng HttpServletRequest được gửi từ đối tượng Client
     * @return  trả về (400) nếu quá trình validate xảy ra lỗi
     *          trả về (200) nếu như quá trình validate thành công và xử lý dữ liệu thành công trong database
     */
    @PostMapping("/user/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO,
                                        BindingResult bindingResult,
                                        HttpServletRequest request) {
        try {
            if(bindingResult.hasErrors()){
                List<UserErrorsRespone> errorsMessage = bindingResult.getFieldErrors()
                        .stream()
                        .map(fieldError -> {
                            UserErrorsRespone error = new UserErrorsRespone();
                            switch (fieldError.getField()) {
                                case "fullName":
                                    error.setFullName(fieldError.getDefaultMessage());
                                    break;
                                case "address":
                                    error.setAddress(fieldError.getDefaultMessage());
                                    break;
                                case "birthday":
                                    // Nếu bạn cần xử lý dạng ngày, bạn có thể tùy chỉnh ở đây
                                    error.setBirthday(null);
                                    break;
                                case "numberphone":
                                    error.setNumberphone(fieldError.getDefaultMessage());
                                    break;
                                case "username":
                                    error.setUsername(fieldError.getDefaultMessage());
                                    break;
                                case "password":
                                    error.setPassword(fieldError.getDefaultMessage());
                                    break;
                                case "email":
                                    error.setEmail(fieldError.getDefaultMessage());
                                    break;
                                default:
                                    // Có thể xử lý trường hợp không xác định
                                    break;
                            }
                            return error;
                        })
                        .toList();

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsMessage);
            }


//            userService.createUser(userDTO);
            return ResponseEntity.ok().body(UserRespone.builder()
                    .userDTO(userDTO)
                    .message("Ban da tao thanh cong 1 user")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * luw
     * @param email email cua nguoi dung nhap vao de check
     * @return tra ve (500) neu xay ra trong qua trinh xu ly
     *         tra ve (404) neu khong tim thay thong tin nguoi dung
     *         tra ve (200) neu da luu vao trong database bang check-email
     */
    @PostMapping("/email/check-email")
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {
        if (!userService.exitsEmail(email)) {
            Integer code = emailSenderService.sendSimpleMail(email);
            if (code!=0) {
                String checkCode = String.valueOf(code);
                sendCodeService.save(new SendCodeDTO(checkCode,email));
                return ResponseEntity.ok("da hoan thanh");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Collections.singletonMap("errors",false));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nguoi dung  da ton tai trong he thong");

    }


    /**
     *  gui ma code den email nguoi tao tai khoan
     * @param userDTO chứa thông tin của người của người dùng tạo tài khoản
     * @param bindingResult chứa kết quả của quá trình validate và ràng buộc dữ liệu
     * @return tra ve (400) neu qua trinh validate du lieu xay ra sai va qua trinh kiem tra du lieu
     *         tra ve (400) neu nhu tai khoan da ton tai
     *         tra ve (400) neu nhu numberphone da ton tai
     *         tra ve (400) neu nhu email da ton tai
     *         tra ve (500) nem ra ngoai le neu xay ra loi trong qua trinh xu ly du lieu
     *         tra ve (200) neu nhu qua trinh gui code qua email thanh cong
     */
    @PostMapping("/email/send-code-email")
    public ResponseEntity<?> sendCodeEmail(@RequestParam("email")  String email) {
        try {
            Integer code = emailSenderService.sendSimpleMail(email);
            if (code!=0) {
                String checkCode = String.valueOf(code);
                sendCodeService.save(new SendCodeDTO(checkCode,email));
                return ResponseEntity.ok("ddax hoan thanh");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Collections.singletonMap("errors",false));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error",false));
        }
    }

    /**
     *  dung de kiem tra ma code nguoi dung nhap vao
     * @param code ma code nguoi dung nhap vao sau khi nhan ma code duojc gui tu he thong den mail nguoi dung
     * @param email đây là email người dùng dùng để đăng kí tài khoản
     * @return tra ve (400) neu ma code khong ton tai
     *         tra ve (500) nem ra 1 ngoai le neu nhu xay ra troong qua trinh xu ly du lieu
     *         tra ve (200) nếu như dữ liệu trong bảng SendCode này xóa đi
     */
    @PostMapping("/email/check-code")
    public ResponseEntity<?> checkCode(@RequestParam("code") String code,
                                       @RequestParam("email") String email) {
        try {
            // Tìm session dựa trên email
            SendCode sendCode = sendCodeService.findByEmail(email);


            // Kiểm tra nếu mã code không tồn tại
            if (sendCode == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã code không tồn tại");
            }

            // So sánh mã code và xóa session nếu khớp
            if (sendCode.getCheckCode().equals(code)) {
                sendCodeService.delete(sendCode);
                return ResponseEntity.ok("da hoan thanh");
            }

            // Trả về trạng thái OK nếu mọi thứ đều thành công
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã code không tồn tại");

        } catch (Exception e) {
            // Xử lý ngoại lệ và trả về lỗi nội bộ server
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi trong quá trình kiểm tra mã code");
        }
    }
    @GetMapping("/user/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam("email") String email) {
        if (userService.exitsEmail(email)) {
            Integer code = emailSenderService.sendSimpleMail(email);
            if (code!=0) {
                String checkCode = String.valueOf(code);
                sendCodeService.save(new SendCodeDTO(checkCode,email));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Khong tim thay email");
    }

    @PostMapping("/storage/hello/{id}")
    public ResponseEntity<?> hello(@Valid @RequestParam("id") Integer id) {
        int a = 10;
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }


    @PostMapping("/saveUser")
    public ResponseEntity<?> save (@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body("da hoan thanh");
    }


    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal Users user) {
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("khoong vao dc");
    }

    @GetMapping("/verify/change-password")
    public ResponseEntity<?> changPassword(@AuthenticationPrincipal Users user,
                                           @RequestParam("oldPassword") String oldPassword,
                                           @RequestParam("newPassword") String newPassword) {
        int flag;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        if (bCryptPasswordEncoder.matches(user.getPassword(), oldPassword)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mat khau cu khong chinh xac");
        }
        if (oldPassword.equals(newPassword)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Maajt khau bi trung");
        }
        if (!bCryptPasswordEncoder.matches(user.getPassword(), newPassword)) {
            user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userService.changePassword(user);
            return ResponseEntity.status(HttpStatus.OK).body("da thay doi thanh cong" );
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mat khau da bi trung");
    }

    @GetMapping("/find-user-by-email")
    public ResponseEntity<?> findUserByEmail(@RequestParam("email") String email) {
        Optional<Users> users = userService.findUserByEmail(email);

        if (users.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    FindUserByEmail.builder().fullName(users.get().getFullName()).username(users.get().getUsername()).email(users.get().getEmail()).build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Khoong tim thay nguoi dung");
    }


    @GetMapping("/change-password")
    public ResponseEntity<?> changPassword (@RequestParam("newPassword") String newPassword,
                                            @RequestParam("username") String username,
                                            @RequestParam("email") String email) {
        if (newPassword==null || username == null) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<Users> users = userService.findUserByEmail(email);
        if (users.isPresent()) {
            String password = bCryptPasswordEncoder.encode(newPassword);
            users.get().setPassword(password);
            userService.changePassword(users.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Khoong tim thay nguoi");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token) {
        // Bỏ tiền tố "Bearer " từ token nếu cần thiết
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // Gọi phương thức invalidateToken để vô hiệu hóa token
        tokenService.invalidateToken(token);
        return ResponseEntity.ok("Đã đăng xuất thành công");
    }

}
