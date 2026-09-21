package com.RodinalMukhtarAulya.frontend.objects.enemies;

import com.RodinalMukhtarAulya.frontend.objects.Collidable;
import com.RodinalMukhtarAulya.frontend.objects.Player;
import com.badlogic.gdx.graphics.Color;

public class Fairy extends Enemy {
    private float collisionCooldown = 0;

    public Fairy(String name, int hp) {
        super(150, 380, 24, 24, Color.PINK, name, hp, 500L);
    }

    public Fairy(float x, float y, String name, int hp) {
        super(x, y, 24, 24, Color.PINK, name, hp, 500L);
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
            System.out.println("Player touches fairy");
            collisionCooldown = 1.0f;
        }
    }
}
