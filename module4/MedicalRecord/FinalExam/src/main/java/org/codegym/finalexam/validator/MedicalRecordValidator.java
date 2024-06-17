package org.codegym.finalexam.validator;

import org.codegym.finalexam.dto.MedicalRecordDTO;
import org.codegym.finalexam.repository.IMedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class MedicalRecordValidator implements Validator {
    @Autowired
    IMedicalRecordRepository medicalRecordRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) target;
        if (medicalRecordDTO.getEndDate().isBefore(medicalRecordDTO.getStartDate())) {
            errors.rejectValue("endDate", null,"Ngày ra viện không được trước ngày nhập viện");
        }

    }
}
