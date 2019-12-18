package com.hand.hlz25720.hap.mapper;

import com.hand.hap.mybatis.common.Mapper;
import com.hand.hlz25720.hap.dto.OmOrderLines;

import java.util.List;

public interface OmOrderLinesMapper extends Mapper<OmOrderLines>{
    List<OmOrderLines> selectByHeaderId (OmOrderLines omOrderLines);
    Long selectMaxLineNumber(Long headerId);
}