package com.hand.hlz25720;

import com.hand.hlz25720.entity.OrderLineQueryCondition;
import com.hand.hlz25720.entity.OrderLineQueryResult;
import com.hand.hlz25720.entity.User;
import com.hand.hlz25720.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class UserTest {
    private ApplicationContext applicationContext;
    private UserMapper userMapper;
    @Before
    public void before() throws IOException {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        userMapper = applicationContext.getBean(UserMapper.class);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserNumber("25720");
        user.setUserName("黄力章");
        user.setAddress("汉得");
        user.setObjectVersionNumber(33);
        user.setCreatedBy(25720);
        user.setLastUpdatedBy(25720);
        userMapper.insertUser(user);
        System.out.println("用户的ID"+userMapper.selectUserByNumber(user.getUserNumber()));
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUserId(26);
        user.setUserNumber("2572025720");
        user.setUserName("黄力章");
        user.setAddress("上海汉得");
        user.setObjectVersionNumber(55);
        user.setCreatedBy(25720);
        user.setLastUpdatedBy(25720);
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUser(){
        long userId;
        userId = 26;
        int i = userMapper.deleteUser(userId);
        System.out.println("删除数据条数"+i);
    }

    @Test
    public void selectOrderLinesByCondition(){
        OrderLineQueryCondition orderLineQueryCondition = new OrderLineQueryCondition();
        orderLineQueryCondition.setOrderNumber("71600");
        orderLineQueryCondition.setItemCode("49");
        orderLineQueryCondition.setItemName("卫龙");
        List<OrderLineQueryResult> orderLineQueryResults = userMapper.selectOrderLinesByCondition(orderLineQueryCondition);
        for (OrderLineQueryResult l:orderLineQueryResults){
            System.out.println(l.toString());
        }
    }

}
