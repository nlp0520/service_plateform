package com.niulipeng.service;

import com.niulipeng.bean.TblUserRecord;
import com.niulipeng.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther:niulipeng
 * @Date:2021/8/16
 * @Description:com.niulipeng.service
 * @Version:1.0
 */
@Component
public class LoginService {

    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username,String password){
        return tblUserRecordMapper.login(username,password);
    }
}
