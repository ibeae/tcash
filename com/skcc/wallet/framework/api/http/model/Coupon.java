package com.skcc.wallet.framework.api.http.model;

public class Coupon {
    private String campaignDescription = null;
    private String campaignEndDate = null;
    private String campaignId = null;
    private String campaignShortDescription = null;
    private String campaignStartDate = null;
    private String campaignTitle = null;
    private String couponImageUrl = null;
    private String couponProfileNo = null;
    private String couponSerialNo;
    private String couponStatus = null;
    private String couponUserStatus = null;
    private String distanceFromBranch = null;
    private String expiryDate;
    private String isRedeemed = "N";
    private String merchantId = null;
    private String merchantName = null;
    private String priority = null;

    public String getCampaignDescription() {
        return this.campaignDescription;
    }

    public String getCampaignEndDate() {
        return this.campaignEndDate;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCampaignShortDescription() {
        return this.campaignShortDescription;
    }

    public String getCampaignStartDate() {
        return this.campaignStartDate;
    }

    public String getCampaignTitle() {
        return this.campaignTitle;
    }

    public String getCouponImageUrl() {
        return this.couponImageUrl;
    }

    public String getCouponProfileNo() {
        return this.couponProfileNo;
    }

    public String getCouponSerialNo() {
        return this.couponSerialNo;
    }

    public String getCouponStatus() {
        return this.couponStatus;
    }

    public String getCouponUserStatus() {
        return this.couponUserStatus;
    }

    public String getDistanceFromBranch() {
        return this.distanceFromBranch;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public String getIsRedeemed() {
        return this.isRedeemed;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setCampaignDescription(String str) {
        this.campaignDescription = str;
    }

    public void setCampaignEndDate(String str) {
        this.campaignEndDate = str;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setCampaignShortDescription(String str) {
        this.campaignShortDescription = str;
    }

    public void setCampaignStartDate(String str) {
        this.campaignStartDate = str;
    }

    public void setCampaignTitle(String str) {
        this.campaignTitle = str;
    }

    public void setCouponImageUrl(String str) {
        this.couponImageUrl = str;
    }

    public void setCouponProfileNo(String str) {
        this.couponProfileNo = str;
    }

    public void setCouponSerialNo(String str) {
        this.couponSerialNo = str;
    }

    public void setCouponStatus(String str) {
        this.couponStatus = str;
    }

    public void setCouponUserStatus(String str) {
        this.couponUserStatus = str;
    }

    public void setDistanceFromBranch(String str) {
        this.distanceFromBranch = str;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public void setIsRedeemed(String str) {
        this.isRedeemed = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setPriority(String str) {
        this.priority = str;
    }
}
