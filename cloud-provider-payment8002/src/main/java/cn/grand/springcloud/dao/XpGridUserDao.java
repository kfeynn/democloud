package cn.grand.springcloud.dao;

import cn.grand.springcloud.entity.XpGridUser;
import cn.grand.springcloud.entity.XpGridUserExample;
import cn.grand.springcloud.mapper.XpGridUserMapper;
import cn.grand.springcloud.mapper.XpGridUserMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XpGridUserDao
{
    @Resource
    XpGridUserMapper xpGridUserMapper;
    //@Autowired
    @Resource
    XpGridUserMapperPlus xpGridUserMapperPlus;


    //获取用户信息
    public XpGridUser getModelByUserID(int sid)
    {
        return xpGridUserMapper.selectByPrimaryKey(sid);
    }
    //XpGridUserExample
    public List<XpGridUser> selectByExample()
    {

        //准备查询条件
        XpGridUserExample example = new XpGridUserExample();
        XpGridUserExample.Criteria criteria = example.createCriteria();
        //查询条件
       //criteria.a("%" + roleName + "%");

        List<XpGridUser> list = xpGridUserMapper.selectByExample(null);



        return list;
    }
    /**
     * 判断用户密码是否存在
     * @param username
     * @param password
     * @return
     */
    public boolean isExists(String username,String password)
    {
        int i = xpGridUserMapperPlus.isExists(username,password);
        if(i>0)
            return true;
        else
            return false;
    }

    /**
     * 根据用户名密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public XpGridUser selectByUserNameAndPassword(String username,String password)
    {
        return xpGridUserMapperPlus.selectByUserNameAndPassword(username,password);
    }


    public int insert(XpGridUser user)
    {
        return xpGridUserMapper.insert(user);
    }

    public int delete(int sid)
    {
        return xpGridUserMapper.deleteByPrimaryKey(sid);
    }

    /** 更新信息 */
    public int edit(XpGridUser model)
    {
        return xpGridUserMapper.updateByPrimaryKeySelective(model);
    }





}
