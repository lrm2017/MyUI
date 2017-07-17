package com.example.myui;

/**
 * Created by 123 on 2017/7/16.
 */

public class IdentityMessage {
    private String name;

    private int imageId;

    public IdentityMessage(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
