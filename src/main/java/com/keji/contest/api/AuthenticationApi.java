package com.luglobal.contest.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luglobal.contest.gson.FaceLoginReqGson;
import com.luglobal.contest.gson.IntlResultGson;
import com.luglobal.contest.model.UserDTO;
import com.luglobal.contest.service.AuthenticationService;
import com.luglobal.contest.service.UserService;
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
            user = JSON.parseObject(param, UserDTO.class);
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
