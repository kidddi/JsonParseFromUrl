package com.beto.test.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class parserJsonParserFromUrl {

    public static Data getData(String url) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            HttpGet httpGet = new HttpGet(url);
            //httpGet.addHeader("accept", "application/json");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            CloseableHttpResponse response1 = httpClient.execute(httpGet);
            try {
                System.out.println("UTILS" + EntityUtils.toString(response.getEntity()));

            String data = readData(response1);
            Gson gson = new Gson();

            return gson.fromJson(data, Data.class);
            }finally {
                response.close();
                response1.close();
            }
        }finally {
            httpClient.close();
        }



    }

    public static List<Data> getDataList(String url) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        String data =  readData(response);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Data>>(){}.getType();
        return gson.fromJson(data, type);
    }

    public static String readData(HttpResponse response) throws Exception {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder buffer = new StringBuilder();
            char[] dataLength = new char[1024];
            int read;
            while ((read = bufferedReader.read(dataLength)) != -1){
                buffer.append(dataLength, 0, read);
            }
            return buffer.toString();
        } finally {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        }
    }
}
