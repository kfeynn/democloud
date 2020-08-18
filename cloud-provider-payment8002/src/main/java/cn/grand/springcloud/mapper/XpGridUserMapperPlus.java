package cn.grand.springcloud.mapper;

import cn.grand.springcloud.entity.XpGridUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
//@Repository
public interface XpGridUserMapperPlus
{
    //多个参数，用注入的方式传入
    int isExists(@Param("username") String username, @Param("password") String password);

    XpGridUser selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

}