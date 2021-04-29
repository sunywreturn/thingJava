package com.proxy.pro;

/**
 * 静态代理示例
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new CalculatorImp());
        int result = proxy.add();
        System.out.println(result);
    }
}
