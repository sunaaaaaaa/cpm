package com.cpm.demo.component;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
//@Controller
public class AuthLogin {

    @Value("${dd.AppKey}")
    private String appKey;
    @Value("${dd.AppSecret}")
    private String appSecret;

    public String getDdToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dings5xbyuqiydfohr7r");
        request.setAppsecret("5wci1yjoQ2m6OnTb6qcnYMYQSRCFbOVNjo19P0sSuwJCGgbGh9fsTGeoSF42te-8");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }



}
