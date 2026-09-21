package com.RodinalMukhtarAulya.frontend;

import com.RodinalMukhtarAulya.frontend.objects.GameObject;
import com.RodinalMukhtarAulya.frontend.objects.Player;
import com.RodinalMukhtarAulya.frontend.objects.bullets.Bullet;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Boss;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Enemy;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Fairy;
import com.RodinalMukhtarAulya.frontend.objects.items.Item;
import com.RodinalMukhtarAulya.frontend.objects.items.ItemType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Input;
import java.util.Iterator;


public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;

    private Player Player;
    private Fairy Fairy;
    private Boss Boss;

    private Item PowerItem;
    private Item PointItem;

    private List<GameObject> entities;
    private List<Bullet> bullets;

    private float shootCooldown = 0;

    public <T extends GameObject> void updateAndClean(List<T> list, float delta, float screenWidth, float screenHeight) {
        // 1. Dapatkan Iterator<T> dari list yang diberikan.

        // 2. Selama masih ada elemen berikutnya (hasNext()):
        //    a. Ambil elemen saat ini menggunakan next(), simpan ke variabel bertipe T.
        //    b. Panggil update(delta) pada elemen tersebut.
        //    c. Jika elemen tersebut isOffScreen(screenWidth, screenHeight) ATAU isDestroyed():
        //       - Tampilkan pesan: "Removed via Generic Iterator: " + [nama class entity, pakai getClass().getSimpleName()]
        //       - Hapus elemen ini dari list menggunakan method milik Iterator (BUKAN list.remove()!).
    }


    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        entities = new ArrayList<>();
        bullets = new ArrayList<>();

        Player = new Player(280, 40, "Reimu Hakurei", 100, 15, 3);

        Fairy = new Fairy(150, 380, "Stage 1 Fairy", 20);

        Boss = new Boss(380, 400, "Cirno", 150);

        PowerItem = new Item(
            200, 300,
            16, 16,
            0,
            ItemType.POWER,
            500L
        );

        PointItem = new Item(
            320, 250,
            16, 16,
            0,
            ItemType.POINT,
            1000L
        );

        entities.add(Player);
        entities.add(Fairy);
        entities.add(Boss);
        entities.add(PowerItem);
        entities.add(PointItem);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        if (shootCooldown > 0) {
            shootCooldown -= delta;
        }

        for (GameObject obj : entities) {
            obj.update(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Z) && shootCooldown <= 0) {
            Bullet bullet = Player.shootBullet();
            bullets.add(bullet);
            shootCooldown = 0.2f;
        }

        for (Bullet bullet : bullets) {
            bullet.update(delta);
        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);

            if (bullet.getY() > 480) {
                bullet.setDestroyed(true);
                continue;
            }

            for (GameObject obj : entities) {
                if (obj instanceof Enemy) {
                    Enemy enemy = (Enemy) obj;

                    if (enemy.isAlive() &&
                        bullet.getCoreHitbox().overlaps(enemy.getCoreHitbox())) {

                        boolean defeated = enemy.takeDamage(bullet.getDamage());

                        if (defeated) {
                            Player.addScore(enemy.getScoreValue());
                        }

                        bullet.setDestroyed(true);
                        break;
                    }
                }
            }
        }

        bullets.removeIf(Bullet::isDestroyed);

        for (int i = 0; i < entities.size(); i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                GameObject a = entities.get(i);
                GameObject b = entities.get(j);

                if (a.getCoreHitbox().overlaps(b.getCoreHitbox())) {
                    a.onCollision(b);
                    b.onCollision(a);
                }
            }
        }

        entities.removeIf(obj ->
            obj instanceof Item &&
                ((Item) obj).isCollected()
        );

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (GameObject obj : entities) {
            obj.render(shapeRenderer);
        }

        for (Bullet bullet : bullets) {
            bullet.render(shapeRenderer);
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        if (shapeRenderer != null) {
            shapeRenderer.dispose();
        }
    }
}
