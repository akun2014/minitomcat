package com.tomcat.demo.server;

import com.tomcat.demo.servlet.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by akun on 2018/11/8.
 */
public class TomcatServer {


    private int port;

    public TomcatServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("tomcat start...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();

                HttpServletRequest request = new HttpServletRequest(inputStream);
                HttpServletResponse response = new HttpServletResponse(outputStream);

                dispatch(request, response);

                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("dispatcher doing");
        try {
            List<ServletMapping> servletMappingList = ServletMappingData.servletMappingList;
            String clazz = "";
            for (ServletMapping servletMapping : servletMappingList) {
                String url = servletMapping.getUrl();
                if (url.equalsIgnoreCase(request.getUri())) {
                    clazz = servletMapping.getClazz();
                }
            }
            //调用实际处理业务的Servlet
            Class<HttpServlet> httpServletClass = (Class<HttpServlet>) Class.forName(clazz);
            HttpServlet httpServlet = httpServletClass.newInstance();
            httpServlet.service(request, response);
            System.out.println("dispatcher done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
