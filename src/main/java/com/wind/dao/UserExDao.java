package com.wind.dao;

import com.wind.auth.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserExDao extends UserDao {

    /**
     * 分页列表查询
     * 
     * @param param 参数
     * @return 返回结果
     */
    @Select(SELECT_SQL + " WHERE id = :1")
    List<User> findPage(Map<String, Object> param);

}
