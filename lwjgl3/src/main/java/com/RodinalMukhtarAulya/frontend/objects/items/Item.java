package com.RodinalMukhtarAulya.frontend.objects.items;

import com.RodinalMukhtarAulya.frontend.objects.Collidable;
import com.RodinalMukhtarAulya.frontend.objects.GameObject;
import com.badlogic.gdx.graphics.Color;

public class Item extends GameObject {
    private String itemType;
    private long scoreValue;
    private ItemType itemTypeEnum;
    private boolean collected = false;

    public Item(float x, float y, String itemType) {
        super(x, y, 16, 16, 0, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = 1000L;
    }

    public Item(float x, float y, float width, float height, float speed, String itemType) {
        super(x, y, width, height, 0, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = 1000L;
    }

    public Item(float x, float y, float width, float height, float speed, String itemType, long scoreValue) {
        super(x, y, width, height, 0, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = scoreValue;
    }

    public Item(float x, float y, ItemType itemTypeEnum) {
        this(x, y, 16, 16, 0, itemTypeEnum, itemTypeEnum.getScoreValue());
    }

    public Item(float x, float y, float width, float height, float speed, ItemType itemTypeEnum, long scoreValue) {
        super(x, y, width, height, 0, getItemColor(itemTypeEnum));

        this.itemTypeEnum = itemTypeEnum;
        this.itemType = itemTypeEnum.name();
        this.scoreValue = scoreValue;
    }

    private static Color getItemColor(ItemType type) {
        switch (type) {
            case POWER:
                return Color.RED;

            case POINT:
                return Color.YELLOW;

            case BOMB:
                return Color.PURPLE;

            case LIFE:
                return Color.GREEN;

            default:
                return Color.WHITE;
        }
    }

    @Override
    public void update(float delta) {
        // Item tetap diam
    }

    public String getItemType() {
        return itemType;
    }

    public long getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(long scoreValue) {
        this.scoreValue = scoreValue;
    }

    public ItemType getItemTypeEnum() {
        return itemTypeEnum;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    @Override
    public void onCollision(Collidable other) {
    }

}
