package com.zlm.community.controller;

import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class OAuthController {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private String url ="https://github.com/login/oauth/access_token";
    @RequestMapping("/callback")
    public String hello(String code,String state) throws IOException {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

        //return "index";
    }
}
