package com.book.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class BxClickstreamLog implements Serializable {
    @ApiModelProperty(value = "ip地址")
    private String ipaddress;

    @ApiModelProperty(value = "用户唯一标识")
    private String uniqueid;

    @ApiModelProperty(value = "用户访问的链接")
    private String url;

    @ApiModelProperty(value = "发生点击行为的区域")
    private String areaAddress;

    @ApiModelProperty(value = "发生点击行为的详细地址")
    private String localAddress;

    @ApiModelProperty(value = "用户浏览器信息")
    private String browserType;

    @ApiModelProperty(value = "用户操作系统信息")
    private String operationsys;

    @ApiModelProperty(value = "上一个浏览的网页")
    private String referUrl;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "该点击行为在session中的顺序")
    private String csvp;

    @ApiModelProperty(value = "访问的url描述")
    private String description;

    @ApiModelProperty(value = "session的唯一编号")
    private String sessionId;

    @ApiModelProperty(value = "session的次数")
    private String sessiontimes;

    @ApiModelProperty(value = "日志在服务端接收的时间")
    private String receivetime;

    private static final long serialVersionUID = 1L;

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getOperationsys() {
        return operationsys;
    }

    public void setOperationsys(String operationsys) {
        this.operationsys = operationsys;
    }

    public String getReferUrl() {
        return referUrl;
    }

    public void setReferUrl(String referUrl) {
        this.referUrl = referUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCsvp() {
        return csvp;
    }

    public void setCsvp(String csvp) {
        this.csvp = csvp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessiontimes() {
        return sessiontimes;
    }

    public void setSessiontimes(String sessiontimes) {
        this.sessiontimes = sessiontimes;
    }

    public String getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(String receivetime) {
        this.receivetime = receivetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ipaddress=").append(ipaddress);
        sb.append(", uniqueid=").append(uniqueid);
        sb.append(", url=").append(url);
        sb.append(", areaAddress=").append(areaAddress);
        sb.append(", localAddress=").append(localAddress);
        sb.append(", browserType=").append(browserType);
        sb.append(", operationsys=").append(operationsys);
        sb.append(", referUrl=").append(referUrl);
        sb.append(", username=").append(username);
        sb.append(", csvp=").append(csvp);
        sb.append(", description=").append(description);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", sessiontimes=").append(sessiontimes);
        sb.append(", receivetime=").append(receivetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}