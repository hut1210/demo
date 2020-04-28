package com.example.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Hut
 * @Date: 2020/04/21 17:28
 **/
@Configuration
public class RedissonManager {
    @Value("${redisson.address}")
    private String addressUrl;

    @Bean
    public RedissonClient getRedisson() throws Exception{
        RedissonClient redisson = null;
        Config config = new Config();
        config.useSingleServer()
                .setAddress(addressUrl);
        redisson = Redisson.create(config);

        System.out.println(redisson.getConfig().toJSON().toString());
        return redisson;
    }
}
