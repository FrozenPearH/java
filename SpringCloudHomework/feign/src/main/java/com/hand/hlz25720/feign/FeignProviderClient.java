package com.hand.hlz25720.feign;

import com.hand.hlz25720.entity.Emp;
import com.hand.hlz25720.entity.Msg;
import com.hand.hlz25720.feign.impl.FeignError;
import org.apache.ibatis.annotations.Select;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("/provider/findById")
    public Emp findById(Integer id);

    @Select("SELECT id , email , qq , wechat FROM msg WHERE oid = #{oid}")
    public Msg findMsgById(Integer oid);
}
