package com.yk.hello.singleTon;

/**
 * @author yk
 * 饥汉模式单例
 */
public class HungrySingleTon {

    private HungrySingleTon(){}

    private static HungrySingleTon instance;

    public static synchronized HungrySingleTon getInstance(){
        if (instance == null){
            instance = new HungrySingleTon();
        }
        return instance;
    }
}
