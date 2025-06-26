package com.admin.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HttpUtils {
    public static Map<String, String> doPost(String url, String param, String token) throws IOException, DocumentException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(param));
        httpPost.addHeader("Content-Type", "application/json");
        if (token != null){
            token = "Bearer " + "token";
        }
        httpPost.addHeader("Authorization", token);
        HttpResponse response = aDefault.execute(httpPost);
        HttpEntity entity = response.getEntity();
        SAXReader reader = new SAXReader();
        Document document = reader.read(entity.getContent());
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        Map<String, String> map = new HashMap<>();
        for (Element element : elements) {
            map.put(element.getName(), element.getText());
        }
        return map;
    }
}
