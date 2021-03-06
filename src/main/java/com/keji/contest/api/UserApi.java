package com.keji.contest.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.keji.contest.model.UserDTO;
import com.keji.contest.service.UserService;
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
    public Object add(@RequestBody UserDTO user) {
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
