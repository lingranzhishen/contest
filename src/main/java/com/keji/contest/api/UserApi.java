package com.luglobal.contest.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luglobal.contest.model.UserDTO;
import com.luglobal.contest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public Object add(@RequestParam("param")String param) {
        UserDTO user= JSON.parseObject(param,UserDTO.class);
        if (userService.findByName(user.getUsername()) != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error","用户名已被使用");
            return jsonObject;
        }
        return userService.add(user);
    }

    @GetMapping("{id}")
    public Object findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
