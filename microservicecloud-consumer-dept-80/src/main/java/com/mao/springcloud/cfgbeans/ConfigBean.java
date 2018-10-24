package com.mao.springcloud.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/10/15/015.
 */

@Configuration  //boot-->spring  applicationContext.xml--> @Configuration配置
public class ConfigBean {  //等于添加上下文

    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    /**
     *new RoundRobinRule(); //轮询算法  默认
     RandomRule(); //随机的算法二
     AvailabilityFilteringRule();会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务 还有并发的连续数量超过阈值的服务
                                    然后对剩余的服务列表使用RoundRobinRule策略进行访问

     WeightedResponseTimeRule();根据响应时间计算所有服务的权重，响应时间越快的服务权重越大，被选中的几率越高
                                    刚启动时，统计信息不足，则使用RoundRobinRule策略，等统计信息足够会切换到WeightedResponseTimeRule

     RetryRule();先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
     BestAvailableRule(); 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务 然后选择一个并发量最小的服务
     ZoneAvoidanceRule(); 默认规则 复合判断server所在区域的性能和server的可用性选择服务器
     */
    @Bean
    public IRule myRule()
    {
        //达到的目的，用我们重新选择的随机算法替代默认的轮询。
        //七中算法
        IRule iRule = null;
        iRule = new RoundRobinRule(); //轮询算法  默认
        iRule = new RandomRule(); //随机的算法
        iRule = new AvailabilityFilteringRule();
        iRule = new WeightedResponseTimeRule();
        iRule = new RetryRule();
        iRule = new BestAvailableRule();
        iRule = new ZoneAvoidanceRule();
        return new RetryRule();
    }

}
//    @Bean
//    public UserService getUserService(){
//        return new UserServiceImpl();
//    }

// applicationContext.xml== ConfigBean(@Configuration)
// <bean id="userService" class="om.mao.springcloud.service.UserServiceImpl">