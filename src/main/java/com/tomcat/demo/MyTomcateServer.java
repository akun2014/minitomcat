package com.tomcat.demo;

import com.tomcat.demo.server.TomcatServer;

/**
 * Created by akun on 2018/11/8.
 */
public class MyTomcateServer {

    public static void main(String[] args) {
        TomcatServer server = new TomcatServer(8080);
        server.start();
    }
}
