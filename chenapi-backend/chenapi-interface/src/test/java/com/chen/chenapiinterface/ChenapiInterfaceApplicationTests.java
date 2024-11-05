package com.chen.chenapiinterface;

import com.chen.chenapiclientsdk.client.ChenApiClient;
import com.chen.chenapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ChenapiInterfaceApplicationTests {

    @Resource
    private ChenApiClient chenApiClient;

    @Test
    void contextLoads() {
        String result = chenApiClient.getNameByGet("chen");
        User user = new User();
        user.setUsername("guzhouyiye");
        String usernameByPost = chenApiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
