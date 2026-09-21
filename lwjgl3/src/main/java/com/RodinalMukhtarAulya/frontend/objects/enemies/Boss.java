package com.RodinalMukhtarAulya.frontend.objects.enemies;

import com.RodinalMukhtarAulya.frontend.objects.Collidable;
import com.RodinalMukhtarAulya.frontend.objects.Player;
import com.badlogic.gdx.graphics.Color;

public class Boss extends Enemy {
    private float collisionCooldown = 0;

    public Boss(String name, int hp) {
        super(380, 400, 48, 48, Color.BLUE, name, hp, 5000L);
    }

    public Boss(float x, float y, String name, int hp) {
        super(x, y, 48, 48, Color.BLUE, name, hp, 5000L);
    }

    @Override
    public void update(float delta) {
        if (collisionCooldown > 0) {
            collisionCooldown -= delta;
        }
    }

    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Player && collisionCooldown <= 0) {
            System.out.println("Player touches boss");
            collisionCooldown = 1.0f;
        }
    }
}
