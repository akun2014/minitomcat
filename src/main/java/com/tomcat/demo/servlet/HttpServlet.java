package com.tomcat.demo.servlet;

/**
 * Created by akun on 2018/11/8.
 */
public abstract class HttpServlet {

    private static final String METHOD_GET = "GET";

    public abstract void doGet(HttpServletRequest request, HttpServletResponse response);

    public abstract void doPost(HttpServletRequest request, HttpServletResponse response);

    public void service(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equalsIgnoreCase(METHOD_GET)) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }

    }
}
