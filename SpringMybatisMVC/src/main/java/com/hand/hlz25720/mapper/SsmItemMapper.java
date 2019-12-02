package com.hand.hlz25720.mapper;

import com.hand.hlz25720.bean.Complex;
import com.hand.hlz25720.bean.SsmItem;

import java.util.List;

public interface SsmItemMapper {
    List<SsmItem> selectAll();
    List<SsmItem> selectItem(SsmItem ssmItem);
    String selectMaxCode();
    SsmItem selectItemByCode(Integer id);
    int deleteById(Integer itemId);
    int deleteByExample(Complex example);
    int insertItem(SsmItem ssmItem);
    int updateByCode(SsmItem ssmItem);

}
