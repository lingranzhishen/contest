package com.keji.contest.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.keji.contest.gson.FaceLoginReqGson;
import com.keji.contest.gson.IntlResultGson;
import com.keji.contest.model.UserDTO;
import com.keji.contest.model.req.LoginReq;
import com.keji.contest.service.AuthenticationService;
import com.keji.contest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AuthenticationApi {
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("authentication")
    public Object login(@RequestParam(value = "param", required = false) String param, @RequestBody(required = false) UserDTO user) {
        if (param != null) {
            LoginReq req = JSON.parseObject(param, LoginReq.class);
            user=new UserDTO();
            user.setUsername(req.getUserName());
            user.setPassword(req.getPassword());
        }
        UserDTO userInDataBase = userService.findByName(user.getUsername());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            jsonObject.put("error", "用户不存在");
        } else if (!userService.comparePassword(user, userInDataBase)) {
            jsonObject.put("error", "密码不正确");
        } else {
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
            userInDataBase.setPassword(null);
            jsonObject.put("user", userInDataBase);
        }
        IntlResultGson resultGson = new IntlResultGson();
        resultGson.setData(jsonObject);
        return resultGson;
    }

    @PostMapping("face-authentication")
    public Object faceAuthentication(@RequestParam(value = "param", required = false) String param) {
        FaceLoginReqGson user = JSON.parseObject(param, FaceLoginReqGson.class);
        UserDTO userInDataBase = userService.findByName(user.getUsername());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            jsonObject.put("error", "用户不存在");
        } else {
            //TODO 图片识别
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
            userInDataBase.setPassword(null);
            jsonObject.put("user", userInDataBase);
        }
        IntlResultGson resultGson = new IntlResultGson();
        resultGson.setData(jsonObject);
        return resultGson;
    }
}
