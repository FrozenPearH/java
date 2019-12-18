package com.hand.hlz25720.feign.impl;

import com.hand.hlz25720.entity.Emp;
import com.hand.hlz25720.entity.Msg;
import com.hand.hlz25720.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Emp findById(Integer id) {
        return null;
    }

    @Override
    public Msg findMsgById(Integer oid) {
        return null;
    }
}
