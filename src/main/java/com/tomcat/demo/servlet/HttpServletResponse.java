package com.tomcat.demo.servlet;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by akun on 2018/11/8.
 */
public class HttpServletResponse {


    private OutputStream outputStream;

    public HttpServletResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }


    public void write(String content) throws IOException {

        String data = "{\"data\":\"hello world\"}";

        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("content-type: application/json; charset=utf-8\n")
                .append("\r\n")
                .append(content);
        outputStream.write(sb.toString().getBytes());
        outputStream.close();
    }
}
