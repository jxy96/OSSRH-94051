package com.example.beaninitself;

import com.example.beaninitself.code.MyAsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MaxBean {

    public void init() throws Exception {
        MyAsyncTaskExecutor.submitTask(() -> {
            log.info("maxBean start ThreadName " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("maxBean end ThreadName " + Thread.currentThread().getName());
        });

    }
}
