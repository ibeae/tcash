package com.skcc.wallet.framework.api.http.model;

public class RequestCouponDownloadRq {
    private String campaignId;
    private CommonHeader commonHeader;
    private String couponProfileNo;
    private String merchantId;

    public String getCampaignId() {
        return this.campaignId;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getCouponProfileNo() {
        return this.couponProfileNo;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setCouponProfileNo(String str) {
        this.couponProfileNo = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }
}
