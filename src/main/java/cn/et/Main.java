package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient 服务提供  @EnableDiscoveryClient 将当前服务注册到Eureka服务器  
@EnableDiscoveryClient

//表示当前这个服务调用的其他服务的名称（application.properties文件中已配）
@RibbonClient(value="SENDCLIENT")
@Configuration
public class Main {
	
	@LoadBalanced  //启动负载均衡
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

}
