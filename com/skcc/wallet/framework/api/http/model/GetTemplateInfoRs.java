package com.skcc.wallet.framework.api.http.model;

public class GetTemplateInfoRs extends ResultRs {
    private MenuTemplate[] menuTemplate;

    public MenuTemplate getMenuTemplate() {
        return (this.menuTemplate == null || this.menuTemplate.length <= 0) ? null : this.menuTemplate[0];
    }

    public void setMenuTemplate(MenuTemplate[] menuTemplateArr) {
        this.menuTemplate = menuTemplateArr;
    }
}
