package org.example.animal;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("#######before method#######");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("#######after method#######");

        return result;
    }

}
