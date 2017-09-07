package com.appsflyer.cache;

import java.util.Scanner;

public class RequestCacheData {
    private String cacheKey;
    private String postData;
    private String requestURL;
    private String version;

    public RequestCacheData(String str, String str2, String str3) {
        this.requestURL = str;
        this.postData = str2;
        this.version = str3;
    }

    public RequestCacheData(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.requestURL = nextLine.substring("url=".length()).trim();
            } else if (nextLine.startsWith("version=")) {
                this.version = nextLine.substring("version=".length()).trim();
            } else if (nextLine.startsWith("data=")) {
                this.postData = nextLine.substring("data=".length()).trim();
            }
        }
        scanner.close();
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public String getPostData() {
        return this.postData;
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public void setPostData(String str) {
        this.postData = str;
    }

    public void setRequestURL(String str) {
        this.requestURL = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
