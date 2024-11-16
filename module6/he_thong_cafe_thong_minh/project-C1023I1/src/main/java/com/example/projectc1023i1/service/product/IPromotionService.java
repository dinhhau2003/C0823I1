package com.example.projectc1023i1.service.product;

import com.example.projectc1023i1.model.product.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPromotionService {
    Page<Promotion> getPromotions(Pageable pageable);
}
