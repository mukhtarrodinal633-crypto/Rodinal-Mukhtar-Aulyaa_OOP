package com.RodinalMukhtarAulya.frontend.objects.bullets;

import com.RodinalMukhtarAulya.frontend.objects.BulletType;
import com.RodinalMukhtarAulya.frontend.objects.Collidable;
import com.RodinalMukhtarAulya.frontend.objects.GameObject;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Enemy;
import com.badlogic.gdx.graphics.Color;
import org.lwjgl.openal.SOFTOutputLimiter;

public class Bullet extends GameObject {
    private BulletType bulletType;
    private int damage;
    private boolean destroyed;

    public Bullet(float x, float y, BulletType bulletType, int damage) {
        super(x, y, 8, 16, 400f, Color.YELLOW);

        this.bulletType = bulletType;
        this.damage = damage;
        this.destroyed = false;
    }

    public Bullet(
        float x,
        float y,
        float speed,
        BulletType bulletType,
        int damage
    ) {
        super(x, y, 8, 16, speed, Color.YELLOW);

        this.bulletType = bulletType;
        this.damage = damage;
        this.destroyed = false;
    }

    @Override
    public void update(float delta) {
        y += speed * delta;
    }

    public BulletType getBulletType() {
        return bulletType;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Enemy enemy) {
            // 1. Tampilkan pesan bahwa Bullet mengenai Enemy dalam format:
            //    Bullet hit [EnemyName] for [damage] DMG!
            int buletShoot = damage;

            if (damage >= Enemy){
                System.out.println("Bullet Hit" + name + damage);
            }else if (damage >= Enemy) {
                System.out.println("Bulet Hit" + name + damage);
            }else {
                System.out.println("Bulet Hit" + Enemy);
            }

            // 2. Panggil takeDamage() milik Enemy dengan damage milik Bullet ini.
            int takeDamage(){
                return getDamage;
            }
            // 3. Bikin si bullet hancur (destroy) setelah mengenai Enemy, apapun hasilnya
            //    (baik enemy kalah atau masih hidup), krn satu bullet cuma boleh kena satu target.
            public boolean isdestroyd(){
                return destroyd;
            }

            }
        }
    }

}
