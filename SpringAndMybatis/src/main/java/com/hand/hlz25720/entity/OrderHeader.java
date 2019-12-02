package com.hand.hlz25720.entity;

import java.util.Date;

public class OrderHeader {
    private long orderHeaderId;//订单头id
    private String orderNumber;//订单编号
    private long customerUserId;//客户id
    private String remark;//备注
    private long objectVersionNumber;//版本号
    private Date creationDate;//创建时间
    private long createdBy;//创建人id
    private Date lastUpdateDate;//最后更新时间
    private long lastUpdatedBy;//最后更新人id

    public long getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(long orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getCustomerUserId() {
        return customerUserId;
    }

    public void setCustomerUserId(long customerUserId) {
        this.customerUserId = customerUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
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
