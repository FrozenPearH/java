package com.hand.hlz25720.hap.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.hlz25720.hap.dto.OmOrderHeaders;
import com.hand.hlz25720.hap.mapper.OmOrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.hlz25720.hap.dto.OmOrderLines;
import com.hand.hlz25720.hap.service.IOmOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService{

    @Autowired
    private OmOrderLinesMapper omOrderLinesMapper;

    @Autowired
    IOmOrderLinesService omOrderLinesService;

    @Override
    public List<OmOrderLines> selectByHeaderId(IRequest var1, OmOrderLines var2, int var3, int var4) {
        PageHelper.startPage(var3, var4);
        return omOrderLinesMapper.selectByHeaderId(var2);
    }

    @Override
    public List<OmOrderLines> myBatchSubmitToLines(IRequest iRequest, List<OmOrderLines> list) {
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                OmOrderLines omOrderLines = list.get(i);
                Long lineId = omOrderLines.getLineId();
                Long headerId = omOrderLines.getHeaderId();
                if (lineId == null){
//                    insert
                    omOrderLinesService.insertSelective(iRequest,omOrderLines);
                }else {
//                    update
                    omOrderLinesService.updateByPrimaryKeySelective(iRequest,omOrderLines);
                }
            }
        }
        return list;
    }

    @Override
    public Long selectMaxLineNumber(Long headerId) {
        return omOrderLinesMapper.selectMaxLineNumber(headerId);
    }
}