package cn.grand.springcloud.controller;

import cn.grand.springcloud.dao.XpGridUserDao;

import cn.grand.springcloud.entity.XpGridUser;
import cn.grand.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

@RequestMapping("/Hello")
@RestController
@Slf4j
public class HelloController
{
    //@Autowired
    @Resource
    XpGridUserDao xpGridUserDao;

    @RequestMapping("/bbb")
    public String bbb()
    {
        return "bbbbb";
    }


    @Value("${server.port}")
    private String serverPort;

    //@RequestMapping("/aaa")
    @GetMapping("/aaa/{sid}")  //restful格式
    public CommonResult aaa(@PathVariable("sid")  int sid) //@RequestBody
    {
        String result = "222";
        System.out.println("2131321312");

        XpGridUser user = xpGridUserDao.getModelByUserID(sid);

        List<XpGridUser> listuser = xpGridUserDao.selectByExample();

        //log

        Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        log.debug("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");
        log.error("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");
        log.info("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");

        if(user != null)
        {
            result= "存在admin";
        }
        else
        {
            result= "------------不存在admin";
        }
        //log.info("******插入结果：" + result);
        CommonResult result1 = new CommonResult(200,"成功,serverPort" + serverPort,user);
        return result1;
    }



}
