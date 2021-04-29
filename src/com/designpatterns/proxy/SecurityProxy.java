package com.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

    private Object object;

    private SecurityProxy(Object obj) {
        this.object = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new SecurityProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            System.out.println("Proxy invoke method called");
            if(method.getName().equals("postToTimeline")) {
                throw new IllegalAccessException("Post method calls are denied at this moment");
            }
            result = method.invoke(object, args);

            return result;
        } catch (Exception e2) {
            throw new RuntimeException("unexpected invocation exception" + e2.getMessage());
        }
    }
}
