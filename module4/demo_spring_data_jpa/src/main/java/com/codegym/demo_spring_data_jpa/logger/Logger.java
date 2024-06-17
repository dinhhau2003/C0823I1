package com.codegym.demo_spring_data_jpa.logger;


import com.codegym.demo_spring_data_jpa.dto.StudentDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;

    @After("execution(* com.codegym.demo_spring_data_jpa.controller.StudentController.showList(..))")
    public void countAccess() {
        System.out.println("Số lần truy cập vào method showList trong StudentController");
        count++;
        System.out.println("----------------------------------------------");
        System.out.println("Số lần : " + count);
    }

    @AfterThrowing(value = "execution(* com.codegym.demo_spring_data_jpa.controller.StudentController.save(..))")
    public void exceptionController() {
        System.out.println("----------------------------------------------");
        System.out.println("Tên đang trùng với Admin");

    }

    @Before(value = "execution(* com.codegym.demo_spring_data_jpa.controller.StudentController.save(..))")
    public void getInfoStudent(JoinPoint joinPoint) {
        System.out.println("----------------------------------------------");
        Object[] object = joinPoint.getArgs();
        StudentDTO studentDTO = (StudentDTO) object[0];
        System.out.println("Tên sinh viên chuẩn bị thêm là " + studentDTO.getName());

    }

    @Around(value = "execution(* com.codegym.demo_spring_data_jpa.controller.StudentController.save(..))")
    public Object getInforStudent2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----------------------------------------------");
        System.out.println(" Công việc thực hiện trước");

        Object object = proceedingJoinPoint.proceed();

        System.out.println(" Công việc thực hiện sau");
        return object;
    }
}
