package com.luglobal.contest.api;


import com.luglobal.contest.annotation.LoginRequired;
import com.luglobal.contest.gson.IdentityApproveGson;
import com.luglobal.contest.gson.IdentityListReqGson;
import com.luglobal.contest.gson.IntlResultGson;
import com.luglobal.contest.model.UserDTO;
import com.luglobal.contest.service.IdentityService;
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
