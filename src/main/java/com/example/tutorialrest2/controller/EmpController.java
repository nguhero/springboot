package com.example.tutorialrest2.controller;

import com.example.tutorialrest2.entity.Scott;
import com.example.tutorialrest2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/employee")
    public List<Scott> findAll(){
        return this.empService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Scott findById(@PathVariable("id") String id){
        return this.empService.findById(id);
    }
    @PostMapping("/employee")
    public void create(@RequestBody Scott scott){
        this.empService.add(scott);
    }
    @PutMapping("/employee")
    public void update(@RequestBody Scott scott){
        this.empService.update(scott);
    }
    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable("id") String id){
        this.empService.del(this.empService.findById(id));
    }
}
