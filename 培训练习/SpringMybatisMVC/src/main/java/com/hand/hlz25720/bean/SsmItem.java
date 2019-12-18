package com.hand.hlz25720.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SsmItem {
    private Long itemId;
    private String itemCode;//物料编码
    private String itemUom;//物料单位
    private String itemDescription;//'物料描述',
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startActiveDate;//'生效起始时间',
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endActiveDate;//生效结束时间',
    private Integer enabledFlag;//'启用标识',
    private Integer objectVersionNumber;//'版本号',
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    private Integer createdBy;
    private Integer lastUpdatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdateDate;

    public SsmItem(){
        super();
    };

    public SsmItem(String itemCode, String itemUom, String itemDescription, LocalDate startActiveDate, LocalDate endActiveDate, Integer enabledFlag) {
        this.itemCode = itemCode;
        this.itemUom = itemUom;
        this.itemDescription = itemDescription;
        this.startActiveDate = startActiveDate;
        this.endActiveDate = endActiveDate;
        this.enabledFlag = enabledFlag;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getitemDescription() {
        return itemDescription;
    }

    public void setitemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public LocalDate getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(LocalDate startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public LocalDate getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(LocalDate endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
