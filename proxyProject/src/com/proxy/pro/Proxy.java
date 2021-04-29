package com.proxy.pro;

public class Proxy {
    private CalculatorImp target;
    public Proxy(CalculatorImp cal){
        target = cal;
    }

    public int add(){
        return target.add();
    }
}
