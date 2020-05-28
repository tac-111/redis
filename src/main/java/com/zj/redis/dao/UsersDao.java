package com.zj.redis.dao;

import com.zj.redis.bean.Users;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface UsersDao {
    @Select("select * from users")
    List<Users> queryAll();

    @Select("select * from users where uid = #{id}")
    Users findUserById(int id);

    @Update("UPDATE USERS SET username = CASE WHEN (#{userName} != NULL) AND (#{userName} != '') THEN #{userName},PASSWORD = CASE WHEN (#{passWord} != NULL) AND (#{passWord} != '') THEN #{passWord},salary = CASE WHEN (#{salary} != 0) THEN #{salary} WHERE uid = #{uid}")
    int updateUser(@Param("user") Users user);

    @Delete("delete from users where uid = #{id}")
    int deleteUserById(int id);
}
