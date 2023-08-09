package com.example.beaninitself.code;

import com.example.beaninitself.code.AsyncInitBeanFactoryPostProcessor;
import com.example.beaninitself.code.AsyncProxyBeanPostProcessor;
import com.example.beaninitself.code.AsyncTaskExecutionListener;
import com.sun.security.sasl.ClientFactoryImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * @author xuanbei 18/3/17
 */
@Configuration(proxyBeanMethods = false)
public class SofaRuntimeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AsyncTaskExecutionListener asyncTaskExecutionListener() {
        return new AsyncTaskExecutionListener();
    }

    @Bean
    @ConditionalOnMissingBean
    public static AsyncProxyBeanPostProcessor asyncProxyBeanPostProcessor() {
        return new AsyncProxyBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public static AsyncInitBeanFactoryPostProcessor asyncInitBeanFactoryPostProcessor() {
        return new AsyncInitBeanFactoryPostProcessor();
    }

}
