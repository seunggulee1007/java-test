package org.example.animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxyTest implements InvocationHandler {

    private final Object target;

    public JdkProxyTest(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("####################before##################");

        if("eat".equals(method.getName())) {
            System.out.println("eat 메서드 호출을 시작합니다.");
            result = method.invoke(target, args);
            System.out.println("eat 메서드가 종료되었습니다.");
            return result;
        }
        System.out.println("drink 메서드를 실행합니다.");
        result = method.invoke(target, args);
        System.out.println("drink 메서드가 종료되었습니다.");
        return result;
    }


}
