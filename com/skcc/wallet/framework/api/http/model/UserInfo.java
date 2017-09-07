package com.skcc.wallet.framework.api.http.model;

public class UserInfo {
    private String address = null;
    private String city = null;
    private String dateOfBirth = null;
    private String email = null;
    private String encryptedToken = null;
    private String firstName = null;
    private String gender = null;
    private String lastName = null;
    private String middleName = null;
    private String mno = null;
    private String motherName = null;
    private String postCode = null;
    private String province = null;
    private String token = null;

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncryptedToken() {
        return this.encryptedToken;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getMno() {
        return this.mno;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getProvince() {
        return this.province;
    }

    public String getToken() {
        return this.token;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEncryptedToken(String str) {
        this.encryptedToken = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMiddleName(String str) {
        this.middleName = str;
    }

    public void setMno(String str) {
        this.mno = str;
    }

    public void setMotherName(String str) {
        this.motherName = str;
    }

    public void setPostCode(String str) {
        this.postCode = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
