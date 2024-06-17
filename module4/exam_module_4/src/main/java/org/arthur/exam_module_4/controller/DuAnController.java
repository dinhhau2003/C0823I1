package org.arthur.exam_module_4.controller;

import jakarta.validation.Valid;
import org.arthur.exam_module_4.dto.DuAnDTO;
import org.arthur.exam_module_4.model.DuAn;
import org.arthur.exam_module_4.service.IDoanhNghiepService;
import org.arthur.exam_module_4.service.IDuAnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class DuAnController {
    @Autowired
    IDuAnService duAnService;
    @Autowired
    IDoanhNghiepService doanhNghiepService;
    @GetMapping({"/","list"})
    public String showList(Model model,
                           @RequestParam(defaultValue = "",required = false) String valueSearch,
                           @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page,2,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list", duAnService.getList("%" + valueSearch + "%",pageable));
        return "list";
    }
    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        DuAn duAn = duAnService.findById(id);
        String msg;
        if (duAnService.delete(duAn)) {
            msg = "Delete successful";
        } else msg = "Delete failed";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("doanhNghiepList", doanhNghiepService.getList());
        model.addAttribute("duAnDTO", new DuAnDTO());
        return "create";
    }
    @PostMapping("create")
    public String addNew(@Valid @ModelAttribute("duAnDTO") DuAnDTO duAnDTO, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes){
        new DuAnDTO().validate(duAnDTO,bindingResult);
        if(duAnService.checkExistMaDuAn(duAnDTO)){
            FieldError error = new FieldError("duAnDTO", "maDuAn", "Mã dự án đã tồn tại");
            bindingResult.addError(error);
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("doanhNghiepList", doanhNghiepService.getList());
            return "/create";
        }
        DuAn duAn = new DuAn();
        duAnService.calChiPhi(duAnDTO);
        duAnService.addNgayDangKy(duAnDTO);
        BeanUtils.copyProperties(duAnDTO, duAn);
        String msg = duAnService.add(duAn) ? "Successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/list";
    }
    @GetMapping("edit")
    public String showEditFrom(@RequestParam("id") Long id,Model model){
        model.addAttribute("duAnDTO", duAnService.findById(id));
        model.addAttribute("doanhNghiepList", doanhNghiepService.getList());
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("duAnDTO") DuAnDTO duAnDTO, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes
                       ){
        new DuAnDTO().validate(duAnDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("doanhNghiepList", doanhNghiepService.getList());
            return "/edit";
        }
        DuAn duAn = new DuAn();
        BeanUtils.copyProperties(duAnDTO, duAn);
        String msg = duAnService.edit(duAn) ? "Edit successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/list";
    }
}
