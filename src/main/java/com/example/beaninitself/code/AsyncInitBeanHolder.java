package com.example.beaninitself.code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author qilong.zql
 * @author xuanbei
 * @since 2.6.0
 */
public class AsyncInitBeanHolder {
    private static final ConcurrentMap<String, Map<String, String>> asyncBeanInfos = new ConcurrentHashMap<String, Map<String, String>>();

    public static void registerAsyncInitBean(String moduleName, String beanId, String methodName) {
        if (moduleName == null || beanId == null || methodName == null) {
            return;
        }

        Map<String, String> asyncBeanInfosInModule = asyncBeanInfos.get(moduleName);
        if (asyncBeanInfosInModule == null) {
            asyncBeanInfos.putIfAbsent(moduleName, new ConcurrentHashMap<String, String>());
            asyncBeanInfosInModule = asyncBeanInfos.get(moduleName);
        }

        asyncBeanInfosInModule.put(beanId, methodName);
    }

    public static String getAsyncInitMethodName(String moduleName, String beanId) {
        Map<String, String> asyncBeanInfosInModule;
        asyncBeanInfosInModule = (moduleName == null) ? null : asyncBeanInfos.get(moduleName);
        return (beanId == null || asyncBeanInfosInModule == null) ? null : asyncBeanInfosInModule
                .get(beanId);
    }
}

