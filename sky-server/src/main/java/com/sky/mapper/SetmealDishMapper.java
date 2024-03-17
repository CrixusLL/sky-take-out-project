package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: SetmealDishMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author Leland_Lau
 * @Create 2024/3/17 21:14
 * @Version 1.0
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐数量
     *
     * @param ids
     * @return
     */
    Integer countByDishId(Long[] ids);

    /**
     * 根据菜品id查询套餐
     *
     * @param id
     * @return
     */
    @Select("select * from setmeal_dish where dish_id = #{id}")
    List<SetmealDish> getByDishId(Long id);

    /**
     * 批量插入套餐-菜品表
     *
     * @param setmealDishes
     */
    void batchInsert(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐ID删除关联表
     *
     * @param id
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long id);

    /**
     * 根据套餐id查询套餐-菜品关联表
     *
     * @param id
     */
    @Select("select * from setmeal_dish where setmeal_id = #{id}")
    List<SetmealDish> getBySetmealId(Long id);

    /**
     * 根据套餐ID查询对应菜品的售卖状态
     *
     * @param id
     * @return
     */
    @Select(
            "select count(*) from setmeal_dish sd " +
                    "left join dish d on sd.dish_id = d.id " +
                    "where sd.setmeal_id = #{id} " +
                    "and d.status = 0")
    Integer countDishStatusBySetmealId(Long id);
}
