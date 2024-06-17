package com.example.benh_an.controller;

import com.example.benh_an.entity.BenhAn;
import com.example.benh_an.entity.BenhNhan;
import com.example.benh_an.service.IBenhAnService;
import com.example.benh_an.service.IBenhNhanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/benhAn")
public class BenhAnController {
    @Autowired
    private IBenhAnService iBenhAnService;
    @Autowired
    private IBenhNhanService iBenhNhanService;
    @GetMapping("/list")
    public String listBenhAn(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<BenhAn> benhAns = iBenhAnService.findAllBenhAn(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("benhAns", benhAns.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", benhAns.getTotalPages());
        return "benhAn/list";
    }
    @ModelAttribute("benhNhans")
    public List<BenhNhan> findAllBenhNhan() {
        return iBenhNhanService.findAllBenhNhan();
    }
    @GetMapping("/create")
    public String viewCreateBenhAn(Model model) {
        BenhAn benhAn = new BenhAn();
        model.addAttribute("benhAn", benhAn);
        return "benhAn/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("benhAn") BenhAn benhAn,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "benhAn/create";
        }
        iBenhAnService.createNewBenhAn(benhAn);
        return "redirect:/benhAn/list";
    }

}
