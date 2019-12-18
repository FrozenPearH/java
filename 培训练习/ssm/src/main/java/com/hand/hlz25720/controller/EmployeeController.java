package com.hand.hlz25720.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.hand.hlz25720.bean.Employee;
import com.hand.hlz25720.bean.Msg;
import com.hand.hlz25720.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/*
处理员工CRUD请求
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
//员工保存
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }

//    需导入jackson包
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn" , defaultValue = "1") Integer pn){
//        引入PageHelper分页插件
        PageHelper.startPage(pn,5);
//        startPage后面紧跟的就是分页查询
        List<Employee> emps = employeeService.getAll();
//        使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
//        封装了详细的分页信息,包括查询出来的数据,传入连续传入的页数
        PageInfo page = new PageInfo(emps,5);
        return Msg.success().add("pageInfo",page);
    }
/*
分页查询员工信息
 */
//    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn" , defaultValue = "1") Integer pn , Model model){
//        引入PageHelper分页插件
        PageHelper.startPage(pn,5);
//        startPage后面紧跟的就是分页查询
        List<Employee> emps = employeeService.getAll();
//        使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
//        封装了详细的分页信息,包括查询出来的数据,传入连续传入的页数
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
