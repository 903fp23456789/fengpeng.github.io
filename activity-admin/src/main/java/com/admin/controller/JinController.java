package com.admin.controller;

import com.admin.pojo.dto.*;
import com.admin.pojo.vo.AttachmentPushVo;
import com.admin.pojo.vo.CustomerInputVo;
import com.admin.pojo.vo.NotarizationVo;
import com.admin.utils.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jinzheng")
public class JinController {
    @PostMapping("/login")
    public LoginDto login(@PathParam("username") String username, @PathParam("password") String password) {
        if (StringUtils.isNotEmpty(username)) {
            // toDO 登录逻辑
        }
        if (StringUtils.isNotEmpty(password)) {
            // toDO 登录逻辑
        }

        LoginDto result = new LoginDto();

        return result;
    }

    @PostMapping("/thoughtCustomerInfoInput")
    public CustomerInputDto thoughtCustomerInfoInput(CustomerInputVo customerInputVo) throws IOException, DocumentException {
        String url = "https://www.stg.goldcert.cn/cchs_admin/api/goldcert/customerInfoInput";
        Object json = JSONObject.toJSON(customerInputVo);
        String param = json.toString();
        String token = null;
        Map<String, String> map = HttpUtils.doPost(url, param, token);

        // map: transStaus, transMsg
        CustomerInputDto customerInputDto = new CustomerInputDto(map.get("transStaus"), map.get("transMsg"));
        return customerInputDto;
    }

    @PostMapping("/attachmentPush")
    public CustomerInputDto attachmentPush(AttachmentPushVo attachmentPushVo) throws IOException, DocumentException {
        String url = "https://www.stg.goldcert.cn/cchs_admin/api/goldcert/attachmentPush";
        Object json = JSONObject.toJSON(attachmentPushVo);
        String param = json.toString();
        String token = null;
        Map<String, String> map = HttpUtils.doPost(url, param, token);
        // map: transStaus, transMsg
        CustomerInputDto customerInputDto = new CustomerInputDto(map.get("transStaus"), map.get("transMsg"));

        return customerInputDto;
    }

    @PostMapping("/videoUrl")
    public VideoDto videoUrl(NotarizationVo notarizationVo) throws DocumentException, IOException {
        String url = "https://www.stg.goldcert.cn/cchs_admin/api/goldcert/attachmentPush";
        Object json = JSONObject.toJSON(notarizationVo);
        String param = json.toString();
        String token = null;
        Map<String, String> map = HttpUtils.doPost(url, param, token);
        JSONObject j = (JSONObject) JSONObject.toJSON(map.get("urlListDto"));
        UrlListDto urlList = new UrlListDto(j.get("urlList").toString(), j.get("pname").toString(), j.get("pkey").toString());
        VideoDto videoDto = new VideoDto(map.get("transStaus"), map.get("transMsg"), urlList);
        return videoDto;
    }

    @PostMapping("/notarization")
    public NotarizationDto notarizationDto(NotarizationVo notarizationVo) throws IOException, DocumentException {
        String url = "https://www.stg.goldcert.cn/cchs_admin/api/goldcert/notarization";
        Object json = JSONObject.toJSON(notarizationVo);
        String param = json.toString();
        String token = null;
        Map<String, String> map = HttpUtils.doPost(url, param, token);
        NotarizationDto notarizationDto = new NotarizationDto(map.get("transStaus"), map.get("transMsg"));
        return notarizationDto;
    }

    public void getNote() throws IOException, DocumentException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://www.stg.goldcert.cn/cchs_admin/api/goldcert/notarization");
        post.setEntity(new StringEntity("//"));
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer host");
        CloseableHttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        SAXReader reader = new SAXReader();
        Document document = reader.read(entity.getContent());
        Map<String, String> map = new HashMap<String, String>();
        document.getRootElement().elements().forEach(element -> {
            map.put(element.getName(), element.getText());
        });
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
