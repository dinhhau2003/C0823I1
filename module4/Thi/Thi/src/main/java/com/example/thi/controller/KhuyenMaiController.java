package com.example.thi.controller;

import com.example.thi.entity.ThongTin;
import com.example.thi.service.IKhuyenMaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/thongTin")
public class KhuyenMaiController {
    @Autowired
    private IKhuyenMaiService iKhuyenMaiService;
    @GetMapping("/list")
    public String listKhuyenMai(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<ThongTin> thongTins = iKhuyenMaiService.findAllKM(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("thongTins", thongTins.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", thongTins.getTotalPages());
        return "thongTin/list";
    }
    @GetMapping("/create")
    public String viewKhuyenMai(Model model) {
        ThongTin thongTin = new ThongTin();
        model.addAttribute("thongTin", thongTin);
        return "thongTin/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("thongTin") ThongTin thongTin,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "thongTin/create";
        }
        iKhuyenMaiService.createNewKM(thongTin);
        return "redirect:/thongTin/list";
    }
    @GetMapping("/update/{id}")
    public String viewUpdateKM(@PathVariable("id") Long id, Model model) {
        ThongTin thongTin = iKhuyenMaiService.findByIdKM(id);
        model.addAttribute("thongTin", thongTin);
        return "thongTin/update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("thongTin")  ThongTin thongTin,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "thongTin/update";
        }
        iKhuyenMaiService.createNewKM(thongTin);
        return "redirect:/thongTin/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        iKhuyenMaiService.deleleKM(id);
        return "redirect:/thongTin/list";
    }
    @GetMapping("/search")
    public String searchKM(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 @RequestParam("mucGiamGia") Double mucGiamGia, Model model) {
//        mucGiamGia = mucGiamGia.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        model.addAttribute("mucGiamGia", mucGiamGia);
        Page<ThongTin> thongTins = iKhuyenMaiService.searchKM(mucGiamGia, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("thongTins", thongTins.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", thongTins.getTotalPages());
        return "thongTin/list";
    }
}
