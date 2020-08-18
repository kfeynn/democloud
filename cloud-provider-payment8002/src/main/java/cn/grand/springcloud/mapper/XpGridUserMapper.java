package cn.grand.springcloud.mapper;

import cn.grand.springcloud.entity.XpGridUser;
import cn.grand.springcloud.entity.XpGridUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Repository
@Mapper
public interface XpGridUserMapper {
    long countByExample(XpGridUserExample example);

    int deleteByExample(XpGridUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(XpGridUser record);

    int insertSelective(XpGridUser record);

    List<XpGridUser> selectByExample(XpGridUserExample example);

    XpGridUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") XpGridUser record, @Param("example") XpGridUserExample example);

    int updateByExample(@Param("record") XpGridUser record, @Param("example") XpGridUserExample example);

    int updateByPrimaryKeySelective(XpGridUser record);

    int updateByPrimaryKey(XpGridUser record);
}