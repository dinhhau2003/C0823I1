package com.example.benhan.controller;

import com.example.benhan.entity.MedicalRecord;
import com.example.benhan.service.IMedicalRecordService;
import com.example.benhan.service.IRecordClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/benhAn")
public class MedicalRecordController {
    @Autowired
    private IMedicalRecordService iMedicalRecordService;
    @Autowired
    private IRecordClassService iRecordClassService;
    @GetMapping("/list")
    public String listBenhAn(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<MedicalRecord> medicalRecords = iMedicalRecordService.findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("medicalRecords", medicalRecords.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", medicalRecords.getTotalPages());
        return "benhAn/list";
    }
}
