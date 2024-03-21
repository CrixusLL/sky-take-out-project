package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.ShoppingCartMapper;

import java.util.List;

/**
 * ClassName: ShoppingCartService
 * Package: com.sky.service
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/20 20:56
 * @Version 1.0
 */
public interface ShoppingCartService {
    /**
     * 查看购物车
     * @return
     */
    List<ShoppingCart> showShoppingCart();

    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * 清空购物车
     */
    void cleanShoppingCart();

    /**
     * 删除购物车其中一个商品
     * @param shoppingCartDTO
     */
    void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
