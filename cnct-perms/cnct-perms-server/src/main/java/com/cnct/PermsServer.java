package com.cnct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cnct.mapper")
public class PermsServer {
    public static void main(String[] args) {
        SpringApplication.run(PermsServer.class,args);
    }
}
