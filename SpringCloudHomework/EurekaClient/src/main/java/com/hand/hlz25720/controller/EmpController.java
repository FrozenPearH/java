package com.hand.hlz25720.controller;

import com.hand.hlz25720.entity.Emp;
import com.hand.hlz25720.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/provider")
public class EmpController {
    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/findById/{id}")
    public Emp findById(@PathVariable("id") Integer id){
        return empMapper.findById(id);
    }

    @GetMapping("/findAll")
    public Collection<Emp> findAll(){
        return empMapper.findAll();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Emp emp){
        empMapper.insertToEmp(emp);
    }

    @PutMapping("/update")
    public void update(@RequestBody Emp emp){
        empMapper.updateToEmp(emp);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        empMapper.deleteById(id);
    }

}
