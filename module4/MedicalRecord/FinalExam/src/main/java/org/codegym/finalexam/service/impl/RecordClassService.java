package org.codegym.finalexam.service.impl;

import org.codegym.finalexam.model.RecordClass;
import org.codegym.finalexam.repository.IRecordClassRepository;
import org.codegym.finalexam.service.IRecordClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordClassService implements IRecordClassService {
    @Autowired
    private IRecordClassRepository recordClassRepository;
    @Override
    public List<RecordClass> findAll() {
        return recordClassRepository.findAll();
    }
}
