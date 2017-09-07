package com.skcc.wallet.framework.api.http.model;

import java.util.ArrayList;

public class GetTcashPurchaseTemplateRs extends ResultRs {
    private ArrayList<Template> linkTemplates;

    public ArrayList<Template> getTemplates() {
        return this.linkTemplates;
    }

    public void setTemplates(ArrayList<Template> arrayList) {
        this.linkTemplates = arrayList;
    }
}
