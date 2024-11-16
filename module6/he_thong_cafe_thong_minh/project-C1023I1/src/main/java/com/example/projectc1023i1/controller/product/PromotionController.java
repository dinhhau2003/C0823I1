package com.example.projectc1023i1.controller.product;

import com.example.projectc1023i1.model.product.Promotion;
import com.example.projectc1023i1.service.product.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/getAllProduct")
    public ResponseEntity<Page<Promotion>> getAll(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size
    ){
//        Sort sort = Sort.by("product_id").ascending();
        Pageable pageable = PageRequest.of(page, size);
        Page<Promotion> productPage = promotionService.getPromotions(pageable);
        if (productPage == null){
            return new ResponseEntity<>(productPage, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }
}
