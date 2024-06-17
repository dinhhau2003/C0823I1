package org.codegym.finalexam.controller;

import jakarta.validation.Valid;

import org.codegym.finalexam.dto.MedicalRecordDTO;
import org.codegym.finalexam.model.MedicalRecord;
import org.codegym.finalexam.service.IMedicalRecordService;
import org.codegym.finalexam.service.IRecordClassService;
import org.codegym.finalexam.validator.MedicalRecordValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
    @Autowired
    private IMedicalRecordService medicalRecordService;
    @Autowired
    private IRecordClassService recordClassService;
    @Autowired
    private MedicalRecordValidator validator;

    @GetMapping("/list")
    public String index(Model model,
                        @RequestParam(defaultValue = "0", required = false) Integer pageNumber,
                        @RequestParam(defaultValue = "", required = false) String searchPatientName,
                        @RequestParam(defaultValue = "", required = false) String searchRecordClass) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, 2,sort);
        Page<MedicalRecord> medicalRecords = medicalRecordService.searchByPatientNameAndRecordClass(searchPatientName, searchRecordClass, pageable);
        model.addAttribute("page", medicalRecords);
        model.addAttribute("searchPatientName", searchPatientName);
        model.addAttribute("searchRecordClass", searchRecordClass);
        model.addAttribute("recordClassList", recordClassService.findAll());
        return "home";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam String deleteId, RedirectAttributes redirectAttributes) {
        if (medicalRecordService.findById(deleteId) != null) {
            medicalRecordService.deleteById(deleteId);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        }
        return "redirect:/medicalRecord/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("MedicalRecordDTO", new MedicalRecordDTO());
        model.addAttribute("recordClassList", recordClassService.findAll());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute MedicalRecordDTO medicalRecordDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        MedicalRecord targetMedicalRecord = new MedicalRecord();
        validator.validate(medicalRecordDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("recordClassList", recordClassService.findAll());
            return "/create";
        }
        BeanUtils.copyProperties(medicalRecordDTO, targetMedicalRecord);
        medicalRecordService.save(targetMedicalRecord);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/medicalRecord/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable(name = "id") String id) {
        MedicalRecord medicalRecord = medicalRecordService.findById(id).get();
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        BeanUtils.copyProperties(medicalRecord,medicalRecordDTO);
        model.addAttribute("medicalRecordDTO", medicalRecordDTO);
        model.addAttribute("recordClassList", recordClassService.findAll());
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute MedicalRecordDTO medicalRecordDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        MedicalRecord targetMedicalRecord = new MedicalRecord();
        validator.validate(medicalRecordDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("recordClassList", recordClassService.findAll());
            return "/edit";
        }

        BeanUtils.copyProperties(medicalRecordDTO,targetMedicalRecord);
        medicalRecordService.save(targetMedicalRecord);
        redirectAttributes.addFlashAttribute("message", "Update thành công");
        return "redirect:/medicalRecord/list";
    }
}
