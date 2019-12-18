package com.hand.hlz25720.entity;

import java.math.BigDecimal;

public class OrderLineQueryResult{

    private String orderNumber;//订单编号
    private String userName;//客户名称
    private String address;//客户地址
    private String remark;//订单备注
    private Long createdBy;//订单创建人
    private Integer orderLineNumber;//订单行号
    private String itemCode;//物料编码
    private String itemName;//物料名称
    private BigDecimal unitPrice;//单价
    private BigDecimal quantity;//数量
    private BigDecimal lineAmount;//行总价

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(BigDecimal lineAmount) {
        this.lineAmount = lineAmount;
    }

    @Override
    public String toString() {
        return "OrderLineQueryResult{" +
                "orderNumber='" + orderNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", createdBy=" + createdBy +
                ", orderLineNumber=" + orderLineNumber +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", lineAmount=" + lineAmount +
                '}';
    }
}
