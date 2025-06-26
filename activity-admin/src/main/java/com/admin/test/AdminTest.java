package com.admin.test;

import com.admin.pojo.dto.LoginDto;
import com.admin.pojo.dto.UrlListDto;
import com.admin.pojo.dto.VideoDto;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AdminTest {
    public static void main(String[] args) throws IllegalAccessException {
        doLogin();
        System.out.println("hello world");
    }

    public static void doJson() {
        UrlListDto urlListDto = new UrlListDto("pname", "pvalue", "pkey");
        VideoDto videoDto = new VideoDto("trans", "mag", urlListDto);
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(videoDto));
        Map<String, Object> map = new HashMap<>();
        map.put("peky", jsonObject.get("urlListDto"));
        System.out.println(map);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("urlListDto");
        System.out.println(jsonObject1);
        map.put("pname", jsonObject1.get("pname"));
        System.out.println(map);
    }

    public static void doMap(){
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 5; i++){
            map.put("name-" + i, "value-" + i);
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static void doLogin() throws IllegalAccessException {
        LoginDto login = new LoginDto("tra", "msg", "name", "token");
        for (Field file : login.getClass().getDeclaredFields()) {
            file.setAccessible(true);
            System.out.println(file.getName() + ":" + file.get(login));
        }
    }
}
