package com.skcc.wallet.framework.api.http.model;

public class MenuTemplate {
    private String apiMenuId;
    private String menuName;
    private String subMenuId;
    private String subMenuName;
    private String templateName;

    public String getApiMenuId() {
        return this.apiMenuId;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public String getSubMenuId() {
        return this.subMenuId;
    }

    public String getSubMenuName() {
        return this.subMenuName;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setApiMenuId(String str) {
        this.apiMenuId = str;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public void setSubMenuId(String str) {
        this.subMenuId = str;
    }

    public void setSubMenuName(String str) {
        this.subMenuName = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }
}
