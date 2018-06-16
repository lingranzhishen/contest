package com.keji.contest.api;


import com.keji.contest.annotation.LoginRequired;
import com.keji.contest.gson.IdentityApproveGson;
import com.keji.contest.gson.IdentityListReqGson;
import com.keji.contest.gson.IntlResultGson;
import com.keji.contest.model.UserDTO;
import com.keji.contest.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/identity/")
public class IdentityApi {

    @Autowired
    private IdentityService identityService;

    @LoginRequired
    @PostMapping("add")
    public Object add(@RequestParam("param") String param) throws Exception{
        IntlResultGson result= identityService.addTask(param);
        return result;
    }

    @LoginRequired
    @PostMapping("list")
    public Object list( @RequestBody(required = false)IdentityListReqGson req) throws Exception{
        IntlResultGson result= identityService.listTask(req);
        return result;
    }

    @LoginRequired
    @RequestMapping(method = RequestMethod.POST, value = "/{id:.+}")
    public Object detail(@PathVariable Long id) throws Exception{
        IntlResultGson result= identityService.detail(id);
        return result;
    }

    @LoginRequired
    @PostMapping("approve")
    public Object approve(@RequestBody IdentityApproveGson req) throws Exception{
        IntlResultGson result= identityService.approveIdentity(req);
        return result;
    }
}
