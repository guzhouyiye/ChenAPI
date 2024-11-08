package com.chen.chenapiinterface.controller;

import com.chen.chenapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;
import com.chen.chenapiclientsdk.model.User;
import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author chen
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");

        // 检查请求头
        if (accessKey == null) {
            throw new RuntimeException("accessKey不能为空");
        }
        if (nonce == null) {
            throw new RuntimeException("nonce不能为空");
        }
        if (sign == null) {
            throw new RuntimeException("sign不能为空");
        }

        // todo 实际情况应该是去数据库中查是否已分配给用户
        if (!accessKey.equals("chen")) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // 时间和当前时间不能超过5分钟
//        if (timestamp) {
//
//        }
        // todo 实际情况是从数据库中查出 secretKey
        String severSign = SignUtils.genSign(body, "abcdefgh");
        if (!sign.equals(severSign)) {
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是" + user.getUsername();
    }
}
