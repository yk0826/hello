package com.yk.hello.a;

import java.util.concurrent.Callable;

/**
 * 测试lei
 */
public class TestB extends TestA implements Callable {

    @Override
    public void show() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        TestA c = new TestA() {
            @Override
            public void show() {

            }
        };
        TestA a = new TestB();
        a.show();
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
