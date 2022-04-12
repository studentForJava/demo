package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * @param user
     * @author Lwx
     * @date 2022/3/7 6:01 PM
     * @desc 新增
     */
    @Insert("insert into user values(#{id},#{name})")
    void addUser(UserEntity user);

    /**
     * @author Lwx
     * @date 2022/3/15 2:41 PM
     * @desc 删除
     */
    @Delete("delete from user where id= #{id}")
    void deleteUserById(@Param("id") int id);

    /**
     * @author Lwx
     * @date 2022/3/15 2:54 PM
     * @desc 更新
     */
    @Update("update user set name=#{name} where id=#{id}")
    void updateUser(UserEntity user);

    /**
     * @author Lwx
     * @date 2022/3/15 3:05 PM
     * @desc 查询全部
     */
    @Select("select * from user ")
    List<UserEntity> selectAll();
}
