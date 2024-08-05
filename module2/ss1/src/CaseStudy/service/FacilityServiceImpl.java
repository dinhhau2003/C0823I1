package CaseStudy.service;
import java.io.IOException;


import CaseStudy.model.Facility;
import CaseStudy.model.Villa;
import MVC.model.Student;

import java.util.LinkedHashMap;


public class FacilityServiceImpl implements FacilityService {
//    private static List<Facility> list=new ArrayList<>();
private static LinkedHashMap<Facility,Integer> facilities = new LinkedHashMap<>();
    static {
        facilities.put(new Villa(001,"village",50000,6,"Tháng","thường",3,200),0);
    }
    @Override
    public void display() {
       facilities=new LinkedHashMap<>();
        LinkedHashMap<Facility,Integer> list=new LinkedHashMap<>();
    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
