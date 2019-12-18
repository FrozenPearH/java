package com.hand.hlz25720;

import com.hand.hlz25720.bean.Department;
import com.hand.hlz25720.bean.Employee;
import com.hand.hlz25720.mapper.DepartmentMapper;
import com.hand.hlz25720.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Target;
import java.util.UUID;
//1、导入SpringTest测试模块
//2、@ContextConfiguration指定Spring配置文件的位置
//3、直接autowired要使用的组件即可

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        //插入几个部门
//        departmentMapper.insertSelective(new Department(null,"开发部"));
////        departmentMapper.insertSelective(new Department(null,"测试"));
        //生成员工数据
//        employeeMapper.insertSelective(new Employee(null,"黄力章","M","572118110@qq.com",1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 50; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@hand.com",1));
        }
        System.out.println("批量完成");
    }
}
