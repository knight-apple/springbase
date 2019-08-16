package cn.knightapple.entity;

import java.io.Serializable;

public class Shout implements Serializable {
    private String message;
    public Shout()
    {
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
