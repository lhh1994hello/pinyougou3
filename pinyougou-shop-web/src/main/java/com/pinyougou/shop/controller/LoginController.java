package com.pinyougou.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/name")
    public Map name() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginName", name);
        logger.info("登录用户名称:{}", name);
        return map;
    }
}
