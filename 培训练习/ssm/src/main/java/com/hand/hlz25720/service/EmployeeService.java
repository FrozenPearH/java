package com.hand.hlz25720.service;

import com.hand.hlz25720.bean.Employee;
import com.hand.hlz25720.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }
//员工保存
    public void saveEmp(Employee employee){
        employeeMapper.insertSelective(employee);
    }
}
