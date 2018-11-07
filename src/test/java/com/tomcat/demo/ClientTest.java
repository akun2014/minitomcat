package com.tomcat.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by akun on 2018/11/8.
 */
public class ClientTest {


    public static void main(String[] args) throws IOException {

        URL url = new URL("http://localhost:8080/helloworld");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("accept", "application/json");
        urlConnection.setRequestProperty("Content-Type", "application/json");

        String response = "";
        byte[] requestBytes = new byte[1024];
        int length;
        if ((length = urlConnection.getInputStream().read(requestBytes)) > 0) {
            response = new String(requestBytes, 0, length);
        }
        System.out.println(response);
    }
}
