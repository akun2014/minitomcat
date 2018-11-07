package com.tomcat.demo.servlet;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by akun on 2018/11/8.
 */
public class HttpServletRequest {

    private String method;
    private String uri;

    public HttpServletRequest(InputStream inputStream) {
        try {
            read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * GET /helloworld HTTP/1.1
     * cache-control: no-cache
     * Postman-Token: 7cc1aeab-2346-45b5-ae93-2328a62d3618
     * User-Agent: PostmanRuntime/7.3.0
     * Host: localhost:8080
     * cookie: JSESSIONID=66CCA6E7CF53D9E9E3A9A300D50B968C
     * accept-encoding: gzip, deflate
     * Connection: keep-alive
     */

    public void read(InputStream inputStream) throws IOException {
        String request = "";
        byte[] requestBytes = new byte[1024];
        int length;
        if ((length = inputStream.read(requestBytes)) > 0) {
            request = new String(requestBytes, 0, length);
        }
        System.out.println(request);
        String httpHead = request.split("\n")[0]; //GET /helloworld HTTP/1.1
        method = httpHead.split("\\s")[0];
        uri = httpHead.split("\\s")[1];
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
