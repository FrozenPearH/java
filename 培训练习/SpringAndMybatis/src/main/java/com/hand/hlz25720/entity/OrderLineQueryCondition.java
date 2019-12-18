package com.hand.hlz25720.entity;

import java.util.SplittableRandom;

public class OrderLineQueryCondition {
    private String orderNumber;//订单编号(模糊)
    private Long orderLineNumber;//订单行号
    private String itemCode;//物料编码(模糊)
    private String itemName;//物料名称(模糊)
    private Long createdBy;//订单创建人id
    private Long customerUserId;//订单客户id

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Long orderLineNumber) {
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCustomerUserId() {
        return customerUserId;
    }

    public void setCustomerUserId(Long customerUserId) {
        this.customerUserId = customerUserId;
    }
}
