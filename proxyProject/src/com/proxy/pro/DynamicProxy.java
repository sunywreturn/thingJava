package com.proxy.pro;

import java.lang.reflect.*;
import java.lang.reflect.Proxy;

/**
 * 动态代理示例
 */
public class DynamicProxy {
    public static void main(String[] args) {
        CalculatorImp target = new CalculatorImp();
        //传入目标对象
        //目的：1.根据它实现的接口生成代理对象2.代理对象调用目标对象方法
        Calculator calculatorProxy = (Calculator)getProxy(target);
        calculatorProxy.add();
    }

    private static Object getProxy(final Object target){
        //参数1：随便找个类加载器
        //参数2：代理对象和目标对象实现相同的接口
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName()+"方法开始执行...");
                        Object result = method.invoke(target,args);
                        System.out.println(result);
                        System.out.println(method.getName()+"方法执行结束...");
                        return result;
                    }
                });
        return proxy;
    }
}
