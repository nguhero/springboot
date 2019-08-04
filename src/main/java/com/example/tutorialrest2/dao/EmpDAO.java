package com.example.tutorialrest2.dao;


import com.example.tutorialrest2.entity.Scott;
import com.example.tutorialrest2.model.EmpSearch;

import java.util.List;

public interface EmpDAO {
    List<Scott> findAll();
    List<Scott> find(EmpSearch empSearch);
    Scott findById(String id);
    List<String> findDep();
    List<String> findMgr();
    void update(Scott emp);
    void del(Scott emp);
    void add(Scott emp);
}
