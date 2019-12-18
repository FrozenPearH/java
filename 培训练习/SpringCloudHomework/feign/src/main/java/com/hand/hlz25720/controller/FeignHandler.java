package com.hand.hlz25720.controller;

import com.hand.hlz25720.entity.Emp;
import com.hand.hlz25720.entity.Msg;
import com.hand.hlz25720.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignHandler {

    @Autowired
    private FeignProviderClient feignProviderClient;

//    确定有该用户
    public Emp findById(Integer id ){
        return feignProviderClient.findById(id);
    }

    @GetMapping("/findById")
    public Msg findOtherMsg(Integer oid){
        Emp emp = this.findById(oid);
        return feignProviderClient.findMsgById( emp.getId());
    }
}
