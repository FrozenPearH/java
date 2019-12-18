package com.hand.hlz25720.hap.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import com.hand.hlz25720.hap.dto.ExcelDaoChuDTO;
import com.hand.hlz25720.hap.dto.OmOrderHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{
    List<OmOrderHeaders> selectByHeader(IRequest var1, OmOrderHeaders var2, int var3, int var4);

    List<OmOrderHeaders> myBatchSubmittoHeaders(IRequest iRequest , List<OmOrderHeaders> list);

    Long maxHeaderId();

    int deleteAll(Long headerId);

    List<ExcelDaoChuDTO> daochu(IRequest var1, OmOrderHeaders var2, int var3, int var4);
}