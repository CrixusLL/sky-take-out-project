package com.sky.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ShopInterceptor
 * Package: com.sky.interceptor
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/19 14:11
 * @Version 1.0
 */

@Component
@Slf4j
public class ShopInterceptor implements HandlerInterceptor {
    private static final String STATUS_KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        if(!redisTemplate.hasKey(STATUS_KEY)){
            log.info("店铺营业状态初始化...");
            redisTemplate.opsForValue().set(STATUS_KEY, 0);
        }
        return true;
    }
}
