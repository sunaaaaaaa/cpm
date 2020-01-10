package com.cpm.demo.Controller;

import com.cpm.demo.component.AuthLogin;
import com.cpm.demo.model.DdUser;
import com.cpm.demo.model.User;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AuthLogin authLogin;

    /*@CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public String Login(@RequestBody User user, HttpSession session){
        session.setAttribute("user",user);
      return user.getName();
    }*/

    @CrossOrigin
    @RequestMapping("/xxx")
    @ResponseBody
    public int Loginxxx(@RequestBody User user,HttpSession session){
        //session.setAttribute("user",user);
        return user.getId();
    }

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public OapiUserGetResponse noLogin(@RequestParam(value="code") String code) throws ApiException {
        String token= authLogin.getDdToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(code);
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = client.execute(request, token);

        System.out.println(token);
        System.out.println(response.getUserid());
        //DdUser ddUser = new DdUser();
        //dUser.setUserid(response.getUserid());
        //ddUser.setErrcode(response.getErrcode());
        //ddUser.setErrmsg(response.getErrmsg());
        //ddUser.setIs_sys(response.getIsSys());
        //ddUser.setSys_level(response.getSysLevel());
        DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
        OapiUserGetRequest request1 = new OapiUserGetRequest();
        request1.setUserid(response.getUserid());
        request1.setHttpMethod("GET");
        OapiUserGetResponse res = client1.execute(request1, token);
        return res;
    }
}
