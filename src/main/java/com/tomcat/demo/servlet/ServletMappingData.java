package com.tomcat.demo.servlet;

import com.tomcat.demo.webservlet.HelloWorldServlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akun on 2018/11/8.
 * 类比: web.xml 中
 * <servlet></servlet>和<servlet-mapping></servlet-mapping>
 * 配置servlet
 */
public class ServletMappingData {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("helloWorldServlet", "/helloworld", HelloWorldServlet.class.getCanonicalName()));
    }

}
