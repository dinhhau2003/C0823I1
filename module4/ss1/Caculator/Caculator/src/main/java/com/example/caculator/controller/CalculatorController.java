package com.example.caculator.controller;

import com.example.caculator.model.Caculator;
import com.example.caculator.service.CalculatorServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/caculator")
public class CalculatorController {
    @Autowired
    CalculatorServiceImpl calculatorService;
//    @RequestMapping(value = "/caculator", method = RequestMethod.GET)

    @GetMapping("")
    public String displayCaculator(){
        return "home";
    }

    @PostMapping("/result")
    public String displayResult(@RequestParam double usd, @RequestParam double rate, Model model){
        double result=calculatorService.convert(usd,rate);
        Caculator caculator=new Caculator(usd,rate,result);
        model.addAttribute("caculator",caculator);
        return "result";
    }
}
