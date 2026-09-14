package com.RodialMukhtarAulya.frontend.frontend;

import com.RodinalMukhtarAulya.frontend.enemies.Boss;
import com.RodinalMukhtarAulya.frontend.enemies.Fairy;
import com.RodinalMukhtarAulya.frontend.items.Item;
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
    private List<GameObject> gameObjects;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        gameObjects = new ArrayList<>();

        // 1. Player: Red square (stationary) at bottom
        Player = new Player(280, 40, "Reimu Hakurei", 100, 15, 3);

        // 2. Fairy: Pink square (stationary, small)
        Fairy = new Fairy(150, 380, "Stage 1 Fairy", 20);

        // 3. Boss: Blue square (stationary, larger size)
        Boss = new Boss(380, 400, "Cirno", 150);

        // 4. Items: White squares (moving downwards linearly)
        PowerItem = new Item(200, 450, 16, 16, 80f, "Power");
        PointItem = new Item(320, 480, 12, 12, 120f, "Point");

        gameObjects.add(Player);
        gameObjects.add(Fairy);
        gameObjects.add(Boss);
        gameObjects.add(PowerItem);
        gameObjects.add(PointItem);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        // Update logic: items move downwards linearly
        for (GameObject obj : gameObjects) {
            obj.update(delta);
        }

        // Clear screen
        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        // Render filled hitboxes with ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (GameObject obj : gameObjects) {
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
