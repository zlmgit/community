package com.zlm.community.provider;

import com.alibaba.fastjson.JSON;
import com.zlm.community.pojo.AccessTokenDTO;
import com.zlm.community.pojo.GitUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GIthubProvider {
    public static final MediaType mediaType
            = MediaType.get("application/json; charset=utf-8");

    @Value("${github.accessToken.url}")
    private String url ;
    @Value("${github.getUser.url}")
    private String getUserUrl;

    public String getAccessToken(AccessTokenDTO dto){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(dto));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String access_token = response.body().string();
            return access_token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public GitUser getUserByAccessToken(String accessToken){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getUserUrl+accessToken)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String string = response.body().string();
            GitUser gitUser = JSON.parseObject(string, GitUser.class);
            return gitUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
