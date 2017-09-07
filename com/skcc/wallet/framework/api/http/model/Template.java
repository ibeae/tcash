package com.skcc.wallet.framework.api.http.model;

public class Template {
    private String linkTemplate;
    private String linkType;
    private String menuId;
    private String menuName;
    private String subMenuId;
    private String subMenuName;
    private String templateId;

    public String getLinkTemplate() {
        return this.linkTemplate;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public String getMenuId() {
        return this.menuId;
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

    public String getTemplateId() {
        return this.templateId;
    }

    public void setLinkTemplate(String str) {
        this.linkTemplate = str;
    }

    public void setLinkType(String str) {
        this.linkType = str;
    }

    public void setMenuId(String str) {
        this.menuId = str;
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

    public void setTemplateId(String str) {
        this.templateId = str;
    }
}
