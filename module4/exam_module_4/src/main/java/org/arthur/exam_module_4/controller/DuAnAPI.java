package org.arthur.exam_module_4.controller;

import org.arthur.exam_module_4.model.DuAn;
import org.arthur.exam_module_4.service.IDuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DuAnAPI {
    @Autowired
    IDuAnService duAnService;
    @PostMapping("/info/{id}")
    public ResponseEntity<DuAn> deleteStudent(@PathVariable("id") Long id){
        DuAn duAn = duAnService.findById(id);
        return  new ResponseEntity<>(duAn,HttpStatus.OK);
    }
}
