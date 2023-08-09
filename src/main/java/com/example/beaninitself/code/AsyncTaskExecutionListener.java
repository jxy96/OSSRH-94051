package com.example.beaninitself.code;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author qilong.zql
 * @since 2.6.0
 */
public class AsyncTaskExecutionListener implements PriorityOrdered,
        ApplicationListener<ContextRefreshedEvent>,
        ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (applicationContext.equals(event.getApplicationContext())) {
            MyAsyncTaskExecutor.ensureAsyncTasksFinish();
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

