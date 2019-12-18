package com.hand.hlz25720.hap.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import com.hand.hlz25720.hap.dto.ExcelDaoChuDTO;
import com.hand.hlz25720.hap.dto.InvInventoryItems;
import com.hand.hlz25720.hap.dto.OmOrderLines;
import com.hand.hlz25720.hap.mapper.OmOrderHeadersMapper;
import com.hand.hlz25720.hap.service.IInvInventoryItemsService;
import com.hand.hlz25720.hap.service.IOmOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.hlz25720.hap.dto.OmOrderHeaders;
import com.hand.hlz25720.hap.service.IOmOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService{


    @Autowired
    IOmOrderHeadersService omOrderHeadersService;

    @Autowired
    IOmOrderLinesService omOrderLinesService;

    @Autowired
    private OmOrderHeadersMapper omOrderHeadersMapper;
    @Override
    public List<OmOrderHeaders> selectByHeader(IRequest var1, OmOrderHeaders var2, int var3, int var4) {
        PageHelper.startPage(var3, var4);
        return omOrderHeadersMapper.selectByHeader(var2);
    }

    @Override
    public List<OmOrderHeaders> myBatchSubmittoHeaders(IRequest iRequest, List<OmOrderHeaders> list) {
        if (list !=null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                OmOrderHeaders omOrderHeaders = list.get(i);
                Long headerId = omOrderHeaders.getHeaderId();
                if (headerId == null || headerId == -1){
//                    insert
                    omOrderHeadersService.insertSelective(iRequest,omOrderHeaders);
                    headerId = omOrderHeaders.getHeaderId();
                    List<OmOrderLines> omOrderLinesList = omOrderHeaders.getOmOrderLinesList();
                    if (omOrderLinesList != null && !omOrderLinesList.isEmpty()){
                        for (int j = 0; j < omOrderLinesList.size(); j++) {
                            omOrderLinesList.get(j).setHeaderId(headerId);
                        }
                    }
                    omOrderLinesService.myBatchSubmitToLines(iRequest,omOrderLinesList);
                }else {
//                    update
                    omOrderHeadersService.updateByPrimaryKeySelective(iRequest,omOrderHeaders);
                    List<OmOrderLines> omOrderLinesList = omOrderHeaders.getOmOrderLinesList();
                    if (omOrderLinesList != null && !omOrderLinesList.isEmpty()){
                        for (int j = 0; j < omOrderLinesList.size(); j++) {
                            if (omOrderLinesList.get(j).getHeaderId() == null) {
                                omOrderLinesList.get(j).setHeaderId(headerId);
                            }
                        }
                    }
                    omOrderLinesService.myBatchSubmitToLines(iRequest,omOrderLinesList);
                }
            }
        }
        return list;
    }

    @Override
    public Long maxHeaderId() {
        return omOrderHeadersMapper.maxHeaderId();
    }

    @Override
    public int deleteAll(Long headerId) {
        return omOrderHeadersMapper.deleteAll(headerId);
    }

    @Override
    public List<ExcelDaoChuDTO> daochu(IRequest var1, OmOrderHeaders var2, int var3, int var4) {
        PageHelper.startPage(var3, var4);
        return omOrderHeadersMapper.daochu(var2);
    }
}