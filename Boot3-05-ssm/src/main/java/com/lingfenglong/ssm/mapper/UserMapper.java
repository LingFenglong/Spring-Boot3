package com.lingfenglong.ssm.mapper;

import com.lingfenglong.ssm.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserById(@Param("id") Integer id);
}
