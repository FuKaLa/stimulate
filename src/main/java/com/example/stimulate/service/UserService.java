package com.example.stimulate.service;

import com.example.stimulate.entity.Role;
import com.example.stimulate.entity.User;
import com.example.stimulate.utils.R;

import java.sql.Savepoint;
import java.util.List;

/**
 * Created by Administrator on 2019/6/6.
 */
public interface UserService {


        List<Role> getRoleList();

        User getUserById(Integer userId);

        int existUser(String userName);

        int checkRole(String userName,Integer roleId);

        int checkUser(String userName,Integer roleId,String password);

        int save(User user);

        int update(User user);

        int updatePassword(Integer id,String password);

        int getUserId(String username);
}
