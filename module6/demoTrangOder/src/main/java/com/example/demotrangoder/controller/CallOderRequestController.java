package com.example.demotrangoder.controller;

import com.example.demotrangoder.dto.OrderRequestDTO;
import com.example.demotrangoder.dto.ProductDTO;
import com.example.demotrangoder.model.CallOderRequest;
import com.example.demotrangoder.model.OderDetail;
import com.example.demotrangoder.model.Product;
import com.example.demotrangoder.model.Table; // import lớp Table
import com.example.demotrangoder.repo.CallOderRequestRepository;
import com.example.demotrangoder.repo.OderDetailRepository;
import com.example.demotrangoder.repo.TableRepository; // import repository của Table
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class CallOderRequestController {

    @Autowired
    private CallOderRequestRepository callOderRequestRepository;

    @Autowired
    private OderDetailRepository orderDetailRepository;

    @Autowired
    private TableRepository tableRepository; // Autowired cho TableRepository
    // API để lấy danh sách món đã order của một bàn
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/table/{tableId}")
    public List<OderDetail> getOrderDetailsByTable(@PathVariable Long tableId) {
        // Lấy tất cả các CallOderRequest của bàn tương ứng
        List<CallOderRequest> orders = callOderRequestRepository.findByTableTableId(tableId);

        List<OderDetail> orderDetails = new ArrayList<>();
        // Duyệt qua các đơn hàng để lấy OderDetail của từng đơn
        for (CallOderRequest order : orders) {
            orderDetails.addAll(orderDetailRepository.findByCallOderRequest(order));
        }

        return orderDetails;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/place")
    public CallOderRequest placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        // Tạo CallOderRequest mới
        CallOderRequest callOderRequest = new CallOderRequest();
        callOderRequest.setUser(orderRequestDTO.getUser());
        callOderRequest.setTable(orderRequestDTO.getTable());

        // Lưu CallOderRequest
        callOderRequest = callOderRequestRepository.save(callOderRequest);

        // Lưu các OderDetail cho từng sản phẩm
        for (ProductDTO productDTO : orderRequestDTO.getProducts()) {
            OderDetail oderDetail = new OderDetail();
            oderDetail.setProduct(new Product(productDTO.getProductId()));
            oderDetail.setQuantity(productDTO.getQuantity());
            oderDetail.setShippingDay(productDTO.getShippingDay());
            oderDetail.setTotalMoneyOder(productDTO.getPrice() * productDTO.getQuantity());
            oderDetail.setCallOderRequest(callOderRequest);

            orderDetailRepository.save(oderDetail);
        }


        return callOderRequest;
    }

}
