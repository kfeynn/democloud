package cn.grand.springcloud.controller;


import cn.grand.springcloud.entity.XpGridUser;
import cn.grand.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController
{
    //public static final String PAYMENT_URL= "http://localhost:8001";

    //用eureka里 服务名 http://eureka7001.com:7001/
    //多个服务，启用负载均衡，， 在applicationContextConfig  @LoadBalanced  //消费者只用关心微服务名称。
    public static final String PAYMENT_URL= "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getUserInfo/{sid}")
    public CommonResult<XpGridUser> getUserInfo(@PathVariable("sid") Long sid)  //@PathVariable("id") Long id
    {
        CommonResult oo = restTemplate.getForObject(PAYMENT_URL + "/Hello/aaa/" + sid,CommonResult.class);

        CommonResult result = new CommonResult(200,"ee",oo);
        return oo;
    }

    @RequestMapping("/aaa")
    public CommonResult aaa()
    {
        Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        log.debug("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");
        log.error("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");
        log.info("统计异常池数量异常,异常信息如下:e.getStackTrace().toString()");


        //log.info("******插入结果：" + result);
        CommonResult result1 = new CommonResult(200,"成功","");
        return result1;
    }






}
