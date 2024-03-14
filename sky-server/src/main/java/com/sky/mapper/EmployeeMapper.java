package com.sky.mapper;

import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     *
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 新增员工
     *
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) VALUES" +
            " (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void addEmployee(Employee employee);

    /**
     * 员工分页查询
     * @param name 可选
     * @param p
     * @param pSize
     * @return
     */
    Employee[] pageQuery(String name, Integer startPage, Integer pageSize);

    /**
     * 查询员工总数
     * @return
     */
    @Select("select count(*) from employee")
    Long totalPages();

    /**
     * 修改员工
     * @param employee
     */
    void update(Employee employee);

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
