/**
 * 文件名：ExcelInputServiceImpl.java
 * 版权：Copyright Lightkit All Rights Reserved.
 * 描述：ExcelInputServiceImpl
 */
package com.lightkits.willsemi.domain.service.excelinput.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lightkits.framework.common.exception.LightKitsBizException;
import com.lightkits.framework.common.utility.object.ObjectUtil;
import com.lightkits.willsemi.checkexcel.dto.CheckLotAndQtyDTO;
import com.lightkits.willsemi.checkexcel.dto.ExcelInputInventoryRetentionsDTO;
import com.lightkits.willsemi.db.dao.arrivalnotice.ArrivalNoticeMapper;
import com.lightkits.willsemi.db.dao.checkexcel.CheckExcelMapper;
import com.lightkits.willsemi.db.dao.common.FndWmAreaMapper;
import com.lightkits.willsemi.db.dao.common.WmsRequestHeaderMapper;
import com.lightkits.willsemi.db.dao.common.WmsWarehouseMapper;
import com.lightkits.willsemi.db.dao.ecfinishednotice.DeliveryTicketMapper;
import com.lightkits.willsemi.db.entity.arrivalnotice.PoArrivalNoticeModel;
import com.lightkits.willsemi.db.entity.common.BdBuPrice;
import com.lightkits.willsemi.db.entity.common.BdMoBase;
import com.lightkits.willsemi.db.entity.common.BdMoExecute;
import com.lightkits.willsemi.db.entity.common.BdReservation;
import com.lightkits.willsemi.db.entity.common.FndDocumentTypeBase;
import com.lightkits.willsemi.db.entity.common.FndItemBase;
import com.lightkits.willsemi.db.entity.common.FndItemMe;
import com.lightkits.willsemi.db.entity.common.FndOrganizationBase;
import com.lightkits.willsemi.db.entity.common.FndOrganizationTl;
import com.lightkits.willsemi.db.entity.common.FndPartyBase;
import com.lightkits.willsemi.db.entity.common.FndWarehouse;
import com.lightkits.willsemi.db.entity.common.FndWmArea;
import com.lightkits.willsemi.db.entity.common.ScmPoHeader;
import com.lightkits.willsemi.db.entity.common.ScmPoLine;
import com.lightkits.willsemi.db.entity.common.WmRequestHeader;
import com.lightkits.willsemi.db.entity.so.SopSoHeader;
import com.lightkits.willsemi.db.entity.so.SopSoLine;
import com.lightkits.willsemi.db.model.KVCodeModel;
import com.lightkits.willsemi.db.model.MoStatusWithHead;
import com.lightkits.willsemi.domain.service.excelinput.ExcelCheckService;
import com.lightkits.willsemi.domain.service.excelinput.ExcelInputService;
import com.lightkits.willsemi.domain.service.excelinput.SaveExcelService;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputArrivalNoticeDTO;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputArrivalNoticeRequestType;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputEcFinishedNoticeDTO;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputEcFinishedNoticeRequestType;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputInventoryRetentionsRequestType;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputPcShipOrderDTO;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputPcShipOrderRequestType;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputRequestTicketDto;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputRequestTicketRequestType;
import com.lightkits.willsemi.domain.service.excelinput.dto.ExcelInputResponseType;
import com.lightkits.willsemi.ecfinishednotice.model.LotCodeDto;
import com.lightkits.willsemi.warehouse.WareHouseOrgDTO;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jianwyuan.zhang@hand-china.com
 * 2019/9/23 11:20
 * lightkits-willsemi-service
 */
@Service
public class ExcelInputServiceImpl implements ExcelInputService {

    private static final String MO_STATUS_1 = "Released";
    private static final String MO_STATUS_2 = "Completed";
    private static final String DOCUMENT_CLASS = "ALLOT";
    private static final String NEED_AREA_DOCUMENT_TYPE = "NEED_AREA_DOCUMENT_TYPE";
    private static final String GET_PRICE_DOCUMENT_TYPE = "GET_PRICE_DOCUMENT_TYPE";
    private static final String WM_TO_SWAP = "WM_TO_SWAP";
    private static final String WM_TO_SWAP_RETURN = "WM_TO_SWAP_RETURN";
    private static final String EXECUTED = "EXECUTED";
    private static final String CANCELED_1 = "Canceled";
    private static final String CANCELED_2 = "CANCELED";
    private static final String FND_RESERVATION_TYPE = "FND_RESERVATION_TYPE";
    private static final String FND_RESERVATION_RULE = "FND_RESERVATION_RULE";
    private static final String STRING_1 = "第";
    private static final String STRING_2 = "行";


    private final ArrivalNoticeMapper arrivalNoticeMapper;
    private final FndWmAreaMapper fndWmAreaMapper;
    private final DeliveryTicketMapper deliveryTicketMapper;
    private final SaveExcelService saveExcelService;
    private final WmsRequestHeaderMapper wmsRequestHeaderMapper;
    private final WmsWarehouseMapper wmsWarehouseMapper;
    private final CheckExcelMapper checkExeclMapper;

    private final ExcelCheckService excelCheckService;

    private static final Logger LOG = LoggerFactory.getLogger(ExcelInputServiceImpl.class);

    @Autowired
    @SuppressWarnings("all")
    public ExcelInputServiceImpl(ArrivalNoticeMapper arrivalNoticeMapper,
                                 FndWmAreaMapper fndWmAreaMapper,
                                 DeliveryTicketMapper deliveryTicketMapper,
                                 SaveExcelService saveExcelService,
                                 WmsRequestHeaderMapper wmsRequestHeaderMapper,
                                 WmsWarehouseMapper wmsWarehouseMapper,
                                 CheckExcelMapper checkExeclMapper,
                                 ExcelCheckService excelCheckService) {
        this.arrivalNoticeMapper = arrivalNoticeMapper;
        this.fndWmAreaMapper = fndWmAreaMapper;
        this.deliveryTicketMapper = deliveryTicketMapper;
        this.saveExcelService = saveExcelService;
        this.wmsRequestHeaderMapper = wmsRequestHeaderMapper;
        this.wmsWarehouseMapper = wmsWarehouseMapper;
        this.checkExeclMapper = checkExeclMapper;
        this.excelCheckService = excelCheckService;
    }


    @Override
    public ExcelInputResponseType excelInputInventoryRetentions(ExcelInputInventoryRetentionsRequestType request) {
        //excel解析集合
        List<ExcelInputInventoryRetentionsDTO> eiInventoryRetentionsDTOList = request.getEiInventoryRetentionsDTOList();
        //excel校验
        this.checkInventory(eiInventoryRetentionsDTOList);
        //保存数据
        return saveExcelService.saveInventoryRetentions(eiInventoryRetentionsDTOList);
    }

    /**
     * 库存保留的excel校验
     *
     * @param eiInventoryRetentionsDTOList dto
     */
    private void checkInventory(List<ExcelInputInventoryRetentionsDTO> eiInventoryRetentionsDTOList) {
        //记录报错行信息
        List<String> line = new ArrayList<>();
        //收集校验数据
        List<String> warehouseCodes = new ArrayList<>();
        List<String> reservationTypes = new ArrayList<>();
        List<String> reservationRules = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> lotNumbers = new ArrayList<>();
        for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
            warehouseCodes.add(dto.getWarehouseCode());
            reservationTypes.add(dto.getReservationType());
            reservationRules.add(dto.getReservationRule());
            itemCodes.add(dto.getItemCode());
            lotNumbers.add(dto.getLotNumber());
        }
        //校验输入的WAREHOUSE_CODE在FND_WAREHOUSE是否存在，若不存在报错
        warehouseCodes = warehouseCodes.stream().distinct().collect(Collectors.toList());
        List<FndOrganizationTl> organizationTls = new FndOrganizationTl()
                .selectList(new EntityWrapper<>()
                        .in(FndOrganizationTl.ORGANIZATION_NAME, warehouseCodes));
        if (ObjectUtil.isNullOrEmpty(organizationTls)) {
            throw new LightKitsBizException("所输入的仓库全都不存在");
        }
        List<String> warehouseCodesAll = organizationTls.stream()
                .map(FndOrganizationTl::getOrganizationName).distinct().collect(Collectors.toList());
        if (warehouseCodes.size() != warehouseCodesAll.size()) {
            warehouseCodes.removeAll(warehouseCodesAll);
            for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
                if (warehouseCodes.toString().contains(dto.getWarehouseCode())) {
                    line.add(dto.getIndexExcel());
                }
            }
            throw new LightKitsBizException("第" + line.toString() + "行所输入的仓库不存在");
        }
        //校验所输入的保留类型在快码：FND_RESERVATION_TYPE存在且标为有效，若不存在报错
        List<String> fndReservaTionTypes =
                wmsWarehouseMapper.querySysCode(FND_RESERVATION_TYPE, null, null)
                        .stream().map(KVCodeModel::getValue).collect(Collectors.toList());
        reservationTypes = reservationTypes.stream().distinct().collect(Collectors.toList());
        List<String> reservationTypesAll = reservationTypes.stream()
                .filter(fndReservaTionTypes::contains).distinct().collect(Collectors.toList());
        if (reservationTypes.size() != reservationTypesAll.size()) {
            reservationTypes.removeAll(reservationTypesAll);
            for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
                if (reservationTypes.toString().contains(dto.getReservationType())) {
                    line.add(dto.getIndexExcel());
                }
            }
            throw new LightKitsBizException("第" + line.toString() + "行的保留类型无效");
        }
        //校验所输入的保留规则在快码：FND_RESERVATION_RULE存在且有效，若不存在报错
        reservationRules = reservationRules.stream().distinct().collect(Collectors.toList());
        List<String> fndReservaTionRules =
                wmsWarehouseMapper.querySysCode(FND_RESERVATION_RULE, null, null)
                        .stream().map(KVCodeModel::getValue).collect(Collectors.toList());
        List<String> reservationRulesAll = reservationRules.stream()
                .filter(fndReservaTionRules::contains).distinct().collect(Collectors.toList());
        if (reservationRules.size() != reservationRulesAll.size()) {
            reservationRules.removeAll(reservationRulesAll);
            for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
                if (reservationRules.toString().contains(dto.getReservationRule())) {
                    line.add(dto.getIndexExcel());
                }
            }
            throw new LightKitsBizException("第" + line.toString() + "行的保留规则无效");
        }
        //根据输入的WAREHOUSE_CODE关联FND_WAREHOUSE获取ORGANIZATION_ID，
        // 根据ITEM_CODE+ORGANIZATION组合关联FND_ITEM_ME的ITEM_CODE+ME_OU_ID,若获取不到则报错
        List<FndItemMe> fndItemMes = checkExeclMapper.checkItemCode(eiInventoryRetentionsDTOList);
        if (ObjectUtil.isNullOrEmpty(fndItemMes)) {
            throw new LightKitsBizException("每一行都不匹配，输入的仓库下无此物料");
        }
        itemCodes = itemCodes.stream().distinct().collect(Collectors.toList());
        List<String> itemCodesAll = fndItemMes.stream()
                .map(FndItemMe::getItemCode).distinct().collect(Collectors.toList());
        if (itemCodes.size() != itemCodesAll.size()) {
            itemCodes.removeAll(itemCodesAll);
            for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
                if (itemCodes.toString().contains(dto.getItemCode())) {
                    line.add(dto.getIndexExcel());
                }
            }
            throw new LightKitsBizException("第" + line.toString() + "行,该仓库下无此物料");
        }
        //根据Excel输入的WAREHOUSE_ID+ITEM_CODE+LOT_NUMBER组合在bd_onhand_quantity入参检索获取LOT_NUMBER，若无法获取数据则报错
        List<CheckLotAndQtyDTO> checkLotAndQtyDTOList = checkExeclMapper.checkLotAndQty(eiInventoryRetentionsDTOList);
        if (ObjectUtil.isNullOrEmpty(checkLotAndQtyDTOList)) {
            throw new LightKitsBizException("每一行都不匹配，该仓库下此物料无此批次");
        }
        lotNumbers = lotNumbers.stream().distinct().collect(Collectors.toList());
        List<String> lotNumbersAll = checkLotAndQtyDTOList.stream()
                .map(CheckLotAndQtyDTO::getLotNumber).distinct().collect(Collectors.toList());
        if (lotNumbers.size() != lotNumbersAll.size()) {
            lotNumbers.removeAll(lotNumbersAll);
            for (ExcelInputInventoryRetentionsDTO dto : eiInventoryRetentionsDTOList) {
                if (lotNumbers.toString().contains(dto.getLotNumber())) {
                    line.add(dto.getIndexExcel());
                }
            }
            throw new LightKitsBizException("第" + line.toString() + "行,该仓库下此物料无此批次");
        }
        //根据Excel输入的WAREHOUSE_ID+ITEM_CODE+LOT_NUMBER在bd_onhand_quantity入参获取QUANTITY，若输入QTY＞QNAUTITY则报错
        List<String> line1 = new ArrayList<>();
        List<String> line2 = new ArrayList<>();
        List<String> line3 = new ArrayList<>();
        for (CheckLotAndQtyDTO dto : checkLotAndQtyDTOList) {
            //若保留规则为整个批次，则数量字段不允许输入
            if (Objects.equals("整个批次", dto.getReservationRule())) {
                if (!ObjectUtil.isNullOrEmpty(dto.getQty())) {
                    line1.add(dto.getIndexExcel());
                }
            } else {
                if (ObjectUtil.isNullOrEmpty(dto.getQty())) {
                    line2.add(dto.getIndexExcel());
                }
                if (new BigDecimal(dto.getQty()).compareTo(dto.getQuantity()) > 0) {
                    line3.add(dto.getIndexExcel());
                }
            }
        }
        if (line1.size() > 0) {
            throw new LightKitsBizException("第" + line1.toString() + "行，保留规则为整个批次，保留数量不允许输入");
        }
        if (line2.size() > 0) {
            throw new LightKitsBizException("第" + line2.toString() + "行，保留规则为批次的时候，保留数量必输");
        }
        if (line3.size() > 0) {
            throw new LightKitsBizException("第" + line3.toString() + "行，保留规则为批次的时候，保留数量大于现有量");
        }
    }


}
