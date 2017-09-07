package com.skcc.wallet.framework.api.http.model;

public class GetCouponDetailRq {
    private String campaignId;
    private CommonHeader commonHeader;
    private String merchantId;

    public String getCampaignId() {
        return this.campaignId;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
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

    public void setMerchantId(String str) {
        this.merchantId = str;
    }
}
