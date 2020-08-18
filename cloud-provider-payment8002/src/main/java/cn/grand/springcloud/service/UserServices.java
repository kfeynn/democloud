package cn.grand.springcloud.service;


import cn.grand.springcloud.dao.XpGridUserDao;
import cn.grand.springcloud.mapper.CommonMapper;
import cn.grand.springcloud.mapper.XpGridUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserServices
{
//    @Autowired
    @Resource
    XpGridUserMapper xpGridUserMapper;



    //@Autowired  // spring 提供
    @Resource  //jdk提供
    CommonMapper  commonMapper;

    @Resource
    XpGridUserDao xpGridUserDao;

    public int deleteUser(int sid)
    {
        return xpGridUserMapper.deleteByPrimaryKey(sid);
    }

    /**
     * 获取角色权限列表
     */
    public List<LinkedHashMap<String,Object>> userAuthorizationRoleList(int sid)
    {
        //mybatis 执行原生sql语句
        String sql = "select [xpGrid_Role].*,isnull(checked,0) as checked from [dbo].[xpGrid_Role] left join (select [xpGrid_UsersInRoles].*,1 as checked from [dbo].[xpGrid_User] inner join [xpGrid_UsersInRoles] on [xpGrid_User].UserID = [xpGrid_UsersInRoles].UserID where [xpGrid_User].userid = " + sid + " ) CheckedRole  on  [xpGrid_Role].RoleId = CheckedRole.RoleId ";

        List<LinkedHashMap<String,Object>>  list =  commonMapper.commonSelect(sql);
        return list;
    }



}
