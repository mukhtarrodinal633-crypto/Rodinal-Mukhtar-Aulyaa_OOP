package com.RodinalMukhtarAulya.frontend.enemies;

import com.RodinalMukhtarAulya.frontend.objects.Collidable;
import com.badlogic.gdx.graphics.Color;

public class Fairy extends Enemy {
    public Fairy(String name, int hp) {
        super(150, 380, 24, 24, Color.PINK, name, hp, 500L);
    }

    public Fairy(float x, float y, String name, int hp) {
        super(x, y, 24, 24, Color.PINK, name, hp, 500L);
    }

    @Override
    public void onCollision(Collidable other) {
        // TODO: Cek apakah other yang diterima method ini adalah Player
        // TODO: Cetak "Player touches fairy"
    }


}
