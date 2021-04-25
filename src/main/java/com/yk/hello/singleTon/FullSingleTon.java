package com.yk.hello.singleTon;

/**
 * 饱汉模式单例
 */
public class FullSingleTon {

    private FullSingleTon(){};

    private static FullSingleTon instance = new FullSingleTon();

    public FullSingleTon getInstance(){
        return instance;
    }
}
