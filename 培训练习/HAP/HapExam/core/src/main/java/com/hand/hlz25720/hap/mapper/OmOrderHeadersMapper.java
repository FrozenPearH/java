package com.hand.hlz25720.hap.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hlz25720.hap.dto.ExcelDaoChuDTO;
import com.hand.hlz25720.hap.dto.OmOrderHeaders;

import java.util.List;

public interface OmOrderHeadersMapper extends Mapper<OmOrderHeaders>{
    List<OmOrderHeaders> selectByHeader(OmOrderHeaders selectOrderConditionDTO);
    Long maxHeaderId();
    int deleteAll(Long headerId);
    List<ExcelDaoChuDTO> daochu(OmOrderHeaders omOrderHeaders);
}