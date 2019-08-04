package com.example.tutorialrest2.service;

import com.example.tutorialrest2.entity.Scott;
import com.example.tutorialrest2.model.EmpSearch;

import java.util.List;
public interface EmpService {
    List<Scott> findAll();
    Scott findById(String id);
    List<Scott> find(EmpSearch empSearch);
    List<String> findDep();
    List<String> findMgr();
    void update(Scott emp);
    void del(Scott emp);
    void add(Scott emp);
}
