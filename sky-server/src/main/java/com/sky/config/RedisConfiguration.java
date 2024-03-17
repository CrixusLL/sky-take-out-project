package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * ClassName: RedisConfiguration
 * Package: com.sky.config
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/18 21:57
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模板对象...");
        RedisTemplate redis = new RedisTemplate();
        //设置redis的连接工厂对象
        redis.setConnectionFactory(redisConnectionFactory);
        //设置redis key的序列化器
        redis.setKeySerializer(new StringRedisSerializer());
//        redis.setValueSerializer(new StringRedisSerializer());
        return redis;
    }
}
