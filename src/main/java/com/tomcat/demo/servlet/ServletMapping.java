package com.tomcat.demo.servlet;

/**
 * Created by akun on 2018/11/8.
 */
public class ServletMapping {
    private String servlerName;
    private String url;
    private String clazz;

    public ServletMapping(String servlerName, String url, String clazz) {
        this.servlerName = servlerName;
        this.url = url;
        this.clazz = clazz;
    }

    public String getServlerName() {
        return servlerName;
    }

    public void setServlerName(String servlerName) {
        this.servlerName = servlerName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
