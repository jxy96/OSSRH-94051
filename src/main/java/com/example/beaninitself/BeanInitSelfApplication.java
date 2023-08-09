package com.example.beaninitself;

import com.example.beaninitself.code.SofaAsyncInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class BeanInitSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanInitSelfApplication.class, args);
    }

    @Bean(value = "max", initMethod = "init")
//    @SofaAsyncInit
    public MaxBean maxBean(){return new MaxBean();}

    @Bean(value = "why", initMethod = "init")
//    @SofaAsyncInit
    public WhyBean whyBean(){return new WhyBean();}

    @Bean
    public Executor whyExecutors() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        return executor;
    }

}
