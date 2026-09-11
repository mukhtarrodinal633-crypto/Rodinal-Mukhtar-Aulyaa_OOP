package io.github.some_example_RodialMukhtarAulya.frontend;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject {
    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;
    private String color;

    public GameObject(float x, float y, float width, float height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = "white";
    }

    public void update(float delta) {
    }

    public void render(SpriteBatch batch) {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height > 0) {
            this.height = height;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
