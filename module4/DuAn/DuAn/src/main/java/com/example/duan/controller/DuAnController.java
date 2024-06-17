package com.example.duan.controller;

import com.example.duan.entity.DoanhNghiep;
import com.example.duan.entity.DuAn;
import com.example.duan.service.DoanhNghiepService;
import com.example.duan.service.DuAnService;
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
@RequestMapping("/duAn")
public class DuAnController {
    @Autowired
    private DuAnService duAnService;
    @Autowired
    private DoanhNghiepService doanhNghiepService;
    @GetMapping("/list")
    public String listDuAn(Model model, @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<DuAn> duAns = duAnService.findAllDuAn(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("duAns", duAns.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", duAns.getTotalPages());
        return "duAn/list";
    }
    @ModelAttribute("doanhNghieps")
    public List<DoanhNghiep> findAllDoanhNghiep() {
        return doanhNghiepService.findAllDoanhNghiep();
    }
    @GetMapping("/create")
    public String viewCreateDuAn(Model model) {
        DuAn duAn = new DuAn();
        model.addAttribute("duAn", duAn);
        return "duAn/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("duAn") DuAn duAn,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "duAN/create";
        }
        duAnService.createNewDuan(duAn);
        return "redirect:/duAn/list";
    }
    @GetMapping("/delete/{maDuAn}")
    public String delete(@PathVariable("maDuAn") String maDuAn) {
        duAnService.deleleDuAn(maDuAn);
        return "redirect:/duAn/list";
    }
    @GetMapping("/update/{maDuAn}")
    public String viewUpdateBlog(@PathVariable("maDuAn") String maDuAn, Model model) {
        DuAn duAn = duAnService.findByIdDuAn(maDuAn);
        model.addAttribute("duAn", duAn);
        return "duAn/update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("duAn")  DuAn duAn,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "duAn/update";
        }
        duAnService.createNewDuan(duAn);
        return "redirect:/duAn/list";
    }
    @GetMapping("/search")
    public String searchDuAnName(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 @RequestParam("tenDuAN") String tenDuAN,
                                 @RequestParam(value = "doanhNghiep", required = false) DoanhNghiep doanhNghiep,
                                 Model model) {
        tenDuAN = tenDuAN.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        model.addAttribute("tenDuAN", tenDuAN);
        model.addAttribute("doanhNghiep", doanhNghiep);
        Page<DuAn> duAns = duAnService.searchDuAnName(tenDuAN, doanhNghiep, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("duAns", duAns.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", duAns.getTotalPages());
        return "duAn/list";
    }
}
