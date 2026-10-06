package com.RodinalMukhtarAulya.frontend;

import com.RodinalMukhtarAulya.frontend.objects.GameObject;
import com.RodinalMukhtarAulya.frontend.objects.Player;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Boss;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Fairy;
import com.RodinalMukhtarAulya.frontend.objects.items.Item;
import com.RodinalMukhtarAulya.frontend.objects.items.ItemType;
import com.RodinalMukhtarAulya.frontend.Systems.AssetManager;
import com.RodinalMukhtarAulya.frontend.Systems.EntityFactory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;

    private Player Player;
    private Fairy FairyRed;
    private Fairy FairyBlue;
    private Boss Boss;

    private Item PowerItem;
    private Item PointItem;

    private List<GameObject> entities;

    private float shootCooldown = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();

        AssetManager.getInstance().init();

        entities = new ArrayList<>();

        Player = EntityFactory.createPlayer(
            280,
            40,
            "Reimu Hakurei",
            100,
            15,
            3
        );

        FairyRed = EntityFactory.createFairy(
            150,
            380,
            "Red Fairy",
            20
        );

        FairyBlue = EntityFactory.createFairy(
            250,
            380,
            "Blue Fairy",
            20,
            "fairy_idle_blue"
        );

        Boss = EntityFactory.createBoss(
            380,
            400,
            "Rumia",
            150
        );

        PowerItem = EntityFactory.createItem(
            200,
            450,
            ItemType.POWER
        );

        PointItem = EntityFactory.createItem(
            320,
            464,
            ItemType.POINT
        );

        entities.add(Player);
        entities.add(FairyRed);
        entities.add(FairyBlue);
        entities.add(Boss);
        entities.add(PowerItem);
        entities.add(PointItem);
    }

    public <T extends GameObject> void updateAndClean(
        List<T> list,
        float delta,
        float screenWidth,
        float screenHeight
    ) {
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            T entity = iterator.next();

            entity.update(delta);

            if (entity.isOffScreen(screenWidth, screenHeight)
                || entity.isDestroyed()) {

                System.out.println(
                    "Removed via Generic Iterator: " +
                        entity.getClass().getSimpleName()
                );

                iterator.remove();
            }
        }
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        if (shootCooldown > 0) {
            shootCooldown -= delta;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.Z) && shootCooldown <= 0) {
            entities.add(Player.shootBullet());
            shootCooldown = 0.2f;
        }

        updateAndClean(
            entities,
            delta,
            Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight()
        );

        for (int i = 0; i < entities.size(); i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                GameObject a = entities.get(i);
                GameObject b = entities.get(j);

                if (!a.isDestroyed() && !b.isDestroyed()) {
                    if (a.getCoreHitbox().overlaps(b.getCoreHitbox())) {
                        a.onCollision(b);
                        b.onCollision(a);
                    }
                }
            }
        }

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        batch.begin();

        for (GameObject entity : entities) {
            if (!entity.isDestroyed()) {
                entity.render(batch);
            }
        }

        batch.end();
    }

    @Override
    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }

        AssetManager.getInstance().dispose();
    }
}
