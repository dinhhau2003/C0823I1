package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Customer;
import com.example.spring_mvc.service.ICustomerService;
import com.example.spring_mvc.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;


//    @GetMapping
//    public ModelAndView listCustomer() {
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        Iterable<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
@GetMapping("")
public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                       @RequestParam (required = false,defaultValue = "")String searchName,
                       ModelMap model) {
    Sort sort =Sort.by("firstName").ascending();
    Pageable pageable = PageRequest.of(page, 2,sort);

    Page<Customer> customerPage = customerService.searchByName(searchName, pageable);
    model.addAttribute("customerPage", customerPage);
    model.addAttribute("searchName", searchName);
    return "customer/list";
}

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Customer customer, BindingResult bindingResult) {
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Customer> customer = Optional.ofNullable(customerService.findById(id));
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer.get());
            modelAndView.addObject("provinces", provinceService.findAll());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer,
                         RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Update customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/customers";
    }
//    @GetMapping("/search")
//    public ModelAndView searchCustomerByName(@RequestParam("name") String name) {
//        List<Customer> customers = customerService.searchByName(name);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
}
