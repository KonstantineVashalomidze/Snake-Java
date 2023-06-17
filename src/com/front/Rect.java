package com.front;

public class Rect {
    public double x, y, width, height;

    public Rect(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isInRect(double x, double y){
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;

    }

}
