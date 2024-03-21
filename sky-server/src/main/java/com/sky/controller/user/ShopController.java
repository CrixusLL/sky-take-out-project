package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ShopController
 * Package: com.sky.controller.admin.user
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/19 13:59
 * @Version 1.0
 */
@RestController("userShopController")
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {
    private static final String STATUS_KEY = "SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result getStatus(){
        Integer shopStatus = (Integer)redisTemplate.opsForValue().get(STATUS_KEY);
        log.info("获取店铺营业状态为：{}",(shopStatus == 1)?"营业中":"已打烊");
        return Result.success(shopStatus);
    }
}
