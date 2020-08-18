package cn.grand.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zyq
 * @version 1.0
 * @date DATE 2020/8/13 22:02
 **/
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced  //负载均衡，多个eureka时配置
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
