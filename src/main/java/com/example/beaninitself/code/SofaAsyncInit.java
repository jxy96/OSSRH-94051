package com.example.beaninitself.code;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to mark a spring bean async init. Sample usage:
 *
 * <pre>
 *
 * &#064;SofaAsyncInit
 * public class SampleServiceImpl implements InitializingBean {
 *
 *     &#064;Override
 *     public void afterPropertiesSet() {
 *         //do something slowly;
 *     }
 * }
 * </pre>
 * @author huzijie
 * @version SofaAsyncInit.java, v 0.1 2022年03月25日 11:52 AM huzijie Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface SofaAsyncInit {

    /**
     * Whether init-method async invoke should occur.
     */
    boolean value() default true;

}

