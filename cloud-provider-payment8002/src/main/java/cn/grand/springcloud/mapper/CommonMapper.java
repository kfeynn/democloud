package cn.grand.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//@Repository
@Mapper
public interface CommonMapper
{
    List<LinkedHashMap<String, Object>> commonSelect(String sql);

    /** 查询类似 select count 的语句 返回 int */
    int commonSelectInt(String sql);

    int commonSql(String sql);

    //通用分页工具
    List<LinkedHashMap<String, Object>> Paging(Map<String, Object> map);

}