package com.hand.hlz25720.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderLine {
    private long orderLineId;//订单行id
    private long orderHeaderId;//订单头id
    private int orderLineNumber;//订单行号
    private String itemCode;//物料编码
    private String itemName;//物料名称
    private BigDecimal unitPrice;//单价
    private BigDecimal quantity;//数量
    private BigDecimal lineAmount;//行总价
    private long objectVersionNumber;//版本号
    private Date creationDate;//创建时间
    private long createBy;//创建人id
    private Date lastUpdateDate;//最后更新时间
    private long lastUpdatedBy;//最后更新人id

    public long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public long getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(long orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
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

    public long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
