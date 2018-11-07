package com.tomcat.demo.webservlet;

import com.tomcat.demo.servlet.HttpServlet;
import com.tomcat.demo.servlet.HttpServletRequest;
import com.tomcat.demo.servlet.HttpServletResponse;

import java.io.IOException;

/**
 * Created by akun on 2018/11/8.
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String data = "{\"data\":\"hello world do get\"}";
        try {
            response.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String data = "{\"data\":\"hello world do post\"}";
        try {
            response.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
