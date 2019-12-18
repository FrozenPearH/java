package com.hand.hlz25720.hap.controllers;

import com.hand.hap.excel.annotation.ExcelExport;
import com.hand.hlz25720.hap.dto.InvInventoryItems;
import com.hand.hlz25720.hap.dto.OmOrderLines;
import com.hand.hlz25720.hap.service.IInvInventoryItemsService;
import com.hand.hlz25720.hap.service.IOmOrderLinesService;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hlz25720.hap.dto.OmOrderHeaders;
import com.hand.hlz25720.hap.service.IOmOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;

    @Controller
    public class OmOrderHeadersController extends BaseController{

    @Autowired
    private IOmOrderHeadersService service;
    @Autowired
    IInvInventoryItemsService invInventoryItemsService;
    @Autowired
    IOmOrderLinesService omOrderLinesService;

    @RequestMapping(value = "/hap/om/order/headers/daochu")
    @ResponseBody
    public ResponseData daochu(OmOrderHeaders dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.daochu(requestContext,dto,page,pageSize));
    }


    @RequestMapping(value = "/hap/om/order/headers/query")
    @ResponseBody
    public ResponseData query(OmOrderHeaders dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.selectByHeader(requestContext,dto,page,pageSize));
    }



    @RequestMapping(value = "/hap/om/order/headers/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<OmOrderHeaders> dto, BindingResult result, HttpServletRequest request){
        IRequest requestCtx = createRequestContext(request);
        Long headerId;
        Long companyId;
        for (int i = 0; i < dto.size(); i++) {
            headerId = dto.get(i).getHeaderId();
            companyId = dto.get(i).getCompanyId();
            dto.get(i).setOrderStatus("NEW");
            List<OmOrderLines> omOrderLinesList = dto.get(i).getOmOrderLinesList();
            for (int j = 0; j < omOrderLinesList.size(); j++) {

                    if (omOrderLinesList.get(j).getLineNumber() == null) {
                        Long aLong = omOrderLinesService.selectMaxLineNumber(headerId);
                        omOrderLinesList.get(j).setLineNumber(aLong);
                    }

                omOrderLinesList.get(j).setHeaderId(headerId);
                omOrderLinesList.get(j).setCompanyId(companyId);
                Long inventoryItemId = omOrderLinesList.get(j).getInventoryItemId();
                InvInventoryItems invInventoryItems = new InvInventoryItems();
                invInventoryItems.setInventoryItemId(inventoryItemId);
                InvInventoryItems invInventoryItems1 = invInventoryItemsService.selectByPrimaryKey(requestCtx, invInventoryItems);
                omOrderLinesList.get(j).setOrderQuantityUom(invInventoryItems1.getItemUom());
            }
        }
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }

        return new ResponseData(service.myBatchSubmittoHeaders(requestCtx, dto));
    }

        @RequestMapping(value = "/hap/om/order/headers/submitOrderStatus")
        @ResponseBody
        public ResponseData submitOrderStatus(HttpServletRequest request,@RequestParam Long headerId) {
        OmOrderHeaders omOrderHeaders = new OmOrderHeaders();
        omOrderHeaders.setHeaderId(headerId);
        omOrderHeaders.setOrderStatus("SUBMITED");
        IRequest requestCtx = createRequestContext(request);
        service.updateByPrimaryKeySelective(requestCtx, omOrderHeaders);
        return new ResponseData();
        }

        @RequestMapping(value = "/hap/om/order/headers/approvedOrderStatus")
        @ResponseBody
        public ResponseData approvedOrderStatus(HttpServletRequest request,@RequestParam Long headerId) {
            OmOrderHeaders omOrderHeaders = new OmOrderHeaders();
            omOrderHeaders.setHeaderId(headerId);
            omOrderHeaders.setOrderStatus("APPROVED");
            IRequest requestCtx = createRequestContext(request);
            service.updateByPrimaryKeySelective(requestCtx, omOrderHeaders);
            return new ResponseData();
        }

        @RequestMapping(value = "/hap/om/order/headers/rejectedOrderStatus")
        @ResponseBody
        public ResponseData rejectedOrderStatus(HttpServletRequest request,@RequestParam Long headerId) {
            OmOrderHeaders omOrderHeaders = new OmOrderHeaders();
            omOrderHeaders.setHeaderId(headerId);
            omOrderHeaders.setOrderStatus("REJECTED");
            IRequest requestCtx = createRequestContext(request);
            service.updateByPrimaryKeySelective(requestCtx, omOrderHeaders);
            return new ResponseData();
        }

    @RequestMapping(value = "/hap/om/order/headers/remove")
        @ResponseBody
        public ResponseData delete(HttpServletRequest request,@RequestBody List<OmOrderHeaders> dto){
            Long headerId;
            for (int i = 0; i < dto.size(); i++) {
                headerId = dto.get(i).getHeaderId();
                service.deleteAll(headerId);
            }
            return new ResponseData();
        }

        @RequestMapping(value = "/hap/om/order/headers/orderRemove")
        @ResponseBody
        public ResponseData orderDelete(HttpServletRequest request,@RequestParam Long headerId){
            service.deleteAll(headerId);
            return new ResponseData();
        }
    }