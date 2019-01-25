package com.wind.service;

import com.wind.auth.model.User;
import com.wind.dao.UserExDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * UserService
 *
 * @author qianchun 2019/1/10
 **/
@Service
public class UserService {

    private UserExDao userDao;

    public User get(long id) {
        return userDao.getByPrimary(id);
    }

    public List<User> findPage(Map<String, Object> params) {
        return userDao.findPage(params);
    }
}
