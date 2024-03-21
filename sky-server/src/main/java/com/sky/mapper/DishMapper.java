package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 新增菜品
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void addDish(Dish dish);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 查询起售中的菜品数
     * @param ids
     * @return
     */
    Long checkOnSale(Long[] ids);

    /**
     * 根据ID批量删除菜品
     * @param ids
     */
    void deleteByIds(Long[] ids);

    /**
     * 根据ID查询菜品
     * @param id
     * @return
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /**
     * 更新菜品数据
     * @param dish
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 根据分类ID查询菜品
     * @param categoryId
     * @return
     */
    @Select("select * from dish where category_id = #{categoryId} order by create_time desc")
    List<Dish> getByCategoryId(Long categoryId);

    /**
     * 动态条件查询菜品（针对C端）
     *
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);

}
