package cn.zql.goodsui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
public class GoodsUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsUiApplication.class, args);
    }

}
