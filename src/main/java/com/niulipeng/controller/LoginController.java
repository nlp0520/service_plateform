package com.niulipeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.niulipeng.bean.TblUserRecord;
import com.niulipeng.bean.TblUserRole;
import com.niulipeng.returnJson.Permission;
import com.niulipeng.returnJson.Permissions;
import com.niulipeng.returnJson.UserInfo;
import com.niulipeng.service.LoginService;
import com.niulipeng.returnJson.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:niulipeng
 * @Date:2021/8/5
 * @Description:com.niulipeng.controller.base
 * @Version:1.0
 */
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public boolean test(){
        System.out.println("登录页两阶段");
        return true;
    }

    @RequestMapping("/auth/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession httpSession){
//        System.out.println(map);
        System.out.println("userName:"+username+"----password:"+password);
        TblUserRecord tblUserRecord = loginService.login(username, password);
        System.out.println(tblUserRecord);
        tblUserRecord.setToken(username);
        String id = httpSession.getId();
        httpSession.setAttribute("tblUserRecord",tblUserRecord);
        System.out.println(id);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        String s = JSONObject.toJSONString(returnObject);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/user/info")
    public String getInfo(HttpSession httpSession){
        System.out.println(httpSession.getId());
        System.out.println(httpSession.getAttribute("tblUserRecord"));
        TblUserRecord tblUserRecord = (TblUserRecord) httpSession.getAttribute("tblUserRecord");
        System.out.println("tblUserRecord-------:"+tblUserRecord);
        //获取查询出来的user对象中的模块权限
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        System.out.println("split-------:"+split);
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向权限集合对象中添加具体的权限
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        System.out.println("userName---:"+tblUserRecord.getUserName());
        System.out.println("permissions-----:"+permissions);
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(),permissions);
        System.out.println("userInfo--------:"+userInfo);
        //返回的是new ReturnObject
        return  JSONObject.toJSONString(new ReturnObject(userInfo));
    }
}
