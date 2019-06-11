package com.example.stimulate.service.impl;

import com.example.stimulate.dao.UserDao;
import com.example.stimulate.entity.Role;
import com.example.stimulate.entity.User;
import com.example.stimulate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<Role> getRoleList() {
        return userDao.getRoleList();
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public int existUser(String userName) {
        return userDao.existUser(userName);
    }

    @Override
    public int checkRole(String userName, Integer roleId) {
        return userDao.checkRole(userName,roleId);
    }

    @Override
    public int checkUser(String userName, Integer roleId, String password) {
        return userDao.checkUser(userName,roleId,password);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int updatePassword(Integer id, String password) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        return userDao.updatePassword(user);
    }

    @Override
    public int getUserId(String username) {
        return userDao.getUserId(username);
    }
}
