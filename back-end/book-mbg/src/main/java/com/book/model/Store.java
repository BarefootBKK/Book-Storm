package com.book.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
    private Integer id;

    private Long storeManagerId;

    private String storePhoneNum;

    private String storeTelephone;

    private String storeName;

    private Date created;

    private Date updated;

    private String storePosition;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(Long storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public String getStorePhoneNum() {
        return storePhoneNum;
    }

    public void setStorePhoneNum(String storePhoneNum) {
        this.storePhoneNum = storePhoneNum;
    }

    public String getStoreTelephone() {
        return storeTelephone;
    }

    public void setStoreTelephone(String storeTelephone) {
        this.storeTelephone = storeTelephone;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getStorePosition() {
        return storePosition;
    }

    public void setStorePosition(String storePosition) {
        this.storePosition = storePosition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeManagerId=").append(storeManagerId);
        sb.append(", storePhoneNum=").append(storePhoneNum);
        sb.append(", storeTelephone=").append(storeTelephone);
        sb.append(", storeName=").append(storeName);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", storePosition=").append(storePosition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}