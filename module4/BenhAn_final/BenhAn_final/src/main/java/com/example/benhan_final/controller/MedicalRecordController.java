package com.example.benhan_final.controller;

import com.example.benhan_final.entity.MedicalRecord;
import com.example.benhan_final.service.IMedicalRecordService;
import com.example.benhan_final.service.IRecordClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MedicalRecordController {
    @Autowired
    private IRecordClassService iRecordClassService;
    @Autowired
    private IMedicalRecordService iMedicalRecordService;
    @GetMapping("/hi")
    public String listMeida(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<MedicalRecord> medicalRecords = iMedicalRecordService.findAllMedia(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("medicalRecords", medicalRecords.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", medicalRecords.getTotalPages());
        return "benhAn/hi";
    }
}
