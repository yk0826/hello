package com.yk.hello.pojo;

public class HelloWorld {

    private String name;

    private String msg;

    public void say(){
        System.out.println(name+" say " + msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
