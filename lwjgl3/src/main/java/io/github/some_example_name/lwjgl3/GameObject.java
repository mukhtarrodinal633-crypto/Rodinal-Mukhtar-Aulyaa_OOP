package io.github.some_example_name.lwjgl3;

public class GameObject {
    public float getx(){
        return x;
    }
    public void setx(float x){
        this,x = x;
    }
    public float gety(){
        return y;
    }
    public void sety(float y){
        this, y = y;
    }
    public float getWidth(){
        return Width;
    }
    public void setWidth(float width) {
        if (width > 0) this.width = width;

    }
    public float setHeight(){
        return Height;
    }
    public void setHeight(float height) {
        if (height > 0) this.height = height;

    }
    public float setSpeed(){
        return Speed;
    }
    public void setSpeed(float speed) {
        if (speed >= 0) this.speed = speed;
    }
    public String getColor(){
        return Color;
    }
    public void setColor(String color){
        this.color = color;
    }
}
