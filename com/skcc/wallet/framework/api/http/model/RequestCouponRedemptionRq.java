package com.skcc.wallet.framework.api.http.model;

public class RequestCouponRedemptionRq {
    private String branchId;
    private String campaignId;
    private CommonHeader commonHeader;
    private String couponCampaignKey;
    private String couponInstanceId;
    private String couponProfileNo;
    private String couponSerialNo;
    private String merchantId;
    private String redeemType;

    public String getBranchId() {
        return this.branchId;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getCouponCampaignKey() {
        return this.couponCampaignKey;
    }

    public String getCouponInstanceId() {
        return this.couponInstanceId;
    }

    public String getCouponProfileNo() {
        return this.couponProfileNo;
    }

    public String getCouponSerialNo() {
        return this.couponSerialNo;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getRedeemType() {
        return this.redeemType;
    }

    public void setBranchId(String str) {
        this.branchId = str;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setCouponCampaignKey(String str) {
        this.couponCampaignKey = str;
    }

    public void setCouponInstanceId(String str) {
        this.couponInstanceId = str;
    }

    public void setCouponProfileNo(String str) {
        this.couponProfileNo = str;
    }

    public void setCouponSerialNo(String str) {
        this.couponSerialNo = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setRedeemType(String str) {
        this.redeemType = str;
    }
}
