package com.example.stimulate.dao;

import com.example.stimulate.entity.Role;
import com.example.stimulate.entity.User;
import com.example.stimulate.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2019/6/6.
 */
@Mapper
@Repository
public interface UserDao {

    List<Role> getRoleList();

    int existUser(@Param("userName")String userName);

    int checkRole(@Param("userName")String userName,@Param("roleId") Integer roleId);

    int checkUser(@Param("userName") String userName,@Param("roleId") Integer roleId,@Param("password") String password);

    int save(User user);

    int updatePassword(User user);

    int update(User user);

    User getUserById(@Param("id")Integer id);

    int getUserId(@Param("username") String username);

    List<UserVO> getTeacherList();

}
