package com.yiii.shardingsphere.demo.controller;

import com.yiii.shardingsphere.demo.model.User;
import com.yiii.shardingsphere.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shardingsphere")
public class Query {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/select")
    public List<User> selectUserList() {
        List<User> queryUser = userService.selectUserList();
        return queryUser;
    }


}
