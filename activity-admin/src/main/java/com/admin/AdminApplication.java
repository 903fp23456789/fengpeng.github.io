package com.admin;

import com.admin.pojo.dto.UrlListDto;
import com.admin.pojo.dto.VideoDto;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
//        doJson();
        System.out.println("启动成功");
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
}
