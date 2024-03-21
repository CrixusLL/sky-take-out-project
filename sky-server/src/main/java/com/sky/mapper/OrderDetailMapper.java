package com.sky.mapper;

import com.sky.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: OrderDetailMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/21 14:24
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper {
    /**
     * 批量插入订单明细
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
