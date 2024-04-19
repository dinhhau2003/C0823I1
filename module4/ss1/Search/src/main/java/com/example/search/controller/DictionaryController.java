package com.example.search.controller;

import com.example.search.model.Search;
import com.example.search.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("dictionary")
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping("")
    public String dictionary(){
        return "dictionary";
    }
    @PostMapping("")
    public String displayResult(@RequestParam String dictionary , Model model){
        String result = dictionaryService.searchEng(dictionary);
        Search searchWord = new Search(dictionary,result);
        model.addAttribute("searchWord",searchWord);
        return "dictionary";
    }
}
