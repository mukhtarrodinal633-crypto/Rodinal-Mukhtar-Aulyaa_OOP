package com.RodinalMukhtarAulya.frontend.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class GameObject implements Collidable {
    public String name;
    public String hp;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float speed;
    protected Color color;
    private boolean destroyed;

    protected TextureRegion sprite;
    protected Animation<TextureRegion> animation;
    protected float stateTime = 0f;

    public GameObject(float x, float y, float width, float height, float speed, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
        this.destroyed = false;
    }

    public void update(float delta) {
        // TODO: Tambah waktu internal objek agar animasi bergerak maju
        stateTime += delta;
    }

    public void render(ShapeRenderer shapeRenderer) {
        if (shapeRenderer != null && color != null) {
            shapeRenderer.setColor(color);
            shapeRenderer.rect(x, y, width, height);
        }
    }

    public void render(SpriteBatch batch) {
        if (batch != null && !destroyed) {
            if (animation != null) {
                TextureRegion currentFrame =
                    animation.getKeyFrame(stateTime, true);

                batch.draw(currentFrame, x, y, width, height);
            } else if (sprite != null) {
                batch.draw(sprite, x, y, width, height);
            }
        }
    }

    @Override
    public Rectangle getCoreHitbox() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public Rectangle getGrazeHitbox() {
        float padding = 10f;
        return new Rectangle(
            x - padding,
            y - padding,
            width + 20f,
            height + 20f
        );
    }

    @Override
    public void onCollision(Collidable other) {
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }

    public boolean isOffScreen(float screenWidth, float screenHeight) {
        return x + width < 0 ||
            x > screenWidth ||
            y + height < 0 ||
            y > screenHeight;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getWidth() { return width; }

    public void setWidth(float width) {
        if (width > 0) this.width = width;
    }

    public float getHeight() { return height; }

    public void setHeight(float height) {
        if (height > 0) this.height = height;
    }

    public float getSpeed() { return speed; }

    public void setSpeed(float speed) {
        if (speed >= 0) this.speed = speed;
    }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public TextureRegion getSprite() {
        return sprite;
    }

    public void setSprite(TextureRegion sprite) {
        this.sprite = sprite;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }
}
