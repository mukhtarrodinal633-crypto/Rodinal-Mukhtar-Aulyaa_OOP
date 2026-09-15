package com.RodialMukhtarAulya.frontend.frontend;

import com.RodinalMukhtarAulya.frontend.enemies.Boss;
import com.RodinalMukhtarAulya.frontend.enemies.Fairy;
import com.RodinalMukhtarAulya.frontend.items.Item;
import com.RodinalMukhtarAulya.frontend.items.ItemType;
import com.RodinalMukhtarAulya.frontend.objects.GameObject;
import com.RodinalMukhtarAulya.frontend.objects.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;

    private Player Player;
    private Fairy Fairy;
    private Boss Boss;
    private Item PowerItem;
    private Item PointItem;
    private List<GameObject> entities;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        entities = new ArrayList<>();

        Player = new Player(280, 40, "Reimu Hakurei", 100, 15, 3);

        Fairy = new Fairy(150, 380, "Stage 1 Fairy", 20);

        Boss = new Boss(380, 400, "Cirno", 150);

        PowerItem = new Item(200, 450, 16, 16, 80f, ItemType.POWER, 500L);
        PointItem = new Item(320, 480, 12, 12, 120f, ItemType.POINT, 1000L);

        entities.add(Player);
        entities.add(Fairy);
        entities.add(Boss);
        entities.add(PowerItem);
        entities.add(PointItem);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        for (GameObject obj : entities) {
            obj.update(delta);
        }

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

        entities.removeIf(obj -> obj instanceof Item && ((Item) obj).isCollected());

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (GameObject obj : entities) {
            obj.render(shapeRenderer);
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
