package com.hand.hlz25720.mapper;

import com.hand.hlz25720.entity.OrderLineQueryCondition;
import com.hand.hlz25720.entity.OrderLineQueryResult;
import com.hand.hlz25720.entity.User;

import java.util.List;
public interface UserMapper {
    List<OrderLineQueryResult> selectOrderLinesByCondition(OrderLineQueryCondition condition);//OrderLineQueryCondition condition
    int selectUser();
    Long selectUserByNumber(String userNumber);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Long userId);
}
