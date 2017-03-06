package com.example.administrator.seaydemo;

/**
 * Created by Administrator on 2017/3/4.
 */

public class Message {

    private String mes;

    private int key;

    public Message(int key, String mes) {
        this.key = key;
        this.mes = mes;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getKey() {
        return key;
    }

    public String getMes() {
        return mes;
    }
}
