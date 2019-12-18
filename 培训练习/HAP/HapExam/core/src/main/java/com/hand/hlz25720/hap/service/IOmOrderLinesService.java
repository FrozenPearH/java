package com.hand.hlz25720.hap.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.hlz25720.hap.dto.OmOrderLines;

import java.util.List;

public interface IOmOrderLinesService extends IBaseService<OmOrderLines>, ProxySelf<IOmOrderLinesService>{
    List<OmOrderLines> selectByHeaderId(IRequest var1, OmOrderLines var2, int var3, int var4);

    List<OmOrderLines> myBatchSubmitToLines(IRequest iRequest, List<OmOrderLines> list);

    Long selectMaxLineNumber(Long headerId);
}