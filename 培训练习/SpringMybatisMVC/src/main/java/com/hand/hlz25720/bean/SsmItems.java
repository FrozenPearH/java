package com.hand.hlz25720.bean;

public class SsmItems {
    private String itemCode;//物料编码
    private String itemUom;//物料单位
    private String itemDescription;//'物料描述',
    private String startActiveDate;//'生效起始时间',
    private String endActiveDate;//生效结束时间',
    private Integer enabledFlag;//'启用标识',

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

    public String getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(String startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public String getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(String endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    @Override
    public String toString() {
        return "SsmItems{" +
                "itemCode='" + itemCode + '\'' +
                ", itemUom='" + itemUom + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", startActiveDate='" + startActiveDate + '\'' +
                ", endActiveDate='" + endActiveDate + '\'' +
                ", enabledFlag=" + enabledFlag +
                '}';
    }
}
