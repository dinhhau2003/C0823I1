package com.example.projectc1023i1.service.product.impl;

import com.example.projectc1023i1.model.product.Promotion;
import com.example.projectc1023i1.repository.product.IPromotionRepo;
import com.example.projectc1023i1.service.product.IPromotionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private IPromotionRepo promotionRepo;

    @Override
    public Page<Promotion> getPromotions(Pageable pageable) {
        Page<Promotion> list = promotionRepo.findAll(pageable);
        return promotionRepo.findAll(pageable);
    }
}
