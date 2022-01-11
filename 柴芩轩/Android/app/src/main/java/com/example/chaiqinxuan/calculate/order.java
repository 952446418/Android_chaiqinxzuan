package com.example.chaiqinxuan.calculate;

import java.io.Serializable;

/** * Created by joker on 2016/1/30. */
public class order implements Serializable {
    public String id;
    public String restPhone;
    public String restName;
    public String receiverAddr;

    public order() {
    }

    public order(String id, String restPhone, String restName, String receiverAddr) {
        this.id = id;
        this.restPhone = restPhone;
        this.restName = restName;
        this.receiverAddr = receiverAddr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestPhone() {
        return restPhone;
    }

    public void setRestPhone(String restPhone) {
        this.restPhone = restPhone;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }
}