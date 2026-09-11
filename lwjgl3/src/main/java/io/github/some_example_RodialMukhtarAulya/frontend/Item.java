package io.github.some_example_RodialMukhtarAulya.frontend;

public class Item extends io.github.some_example_RodialMukhtarAulya.frontend.GameObject {
    private String itemType;
    private long scoreValue;

    public Item(float x, float y, float width, float height, float speed,
                String itemType, long scoreValue) {
        super(x, y, width, height, speed);
        this.itemType = itemType;
        this.scoreValue = scoreValue;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public long getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(long scoreValue) {
        this.scoreValue = scoreValue;
    }

    @Override
    public void update(float delta) {
        setY(getY() - getSpeed() * delta);
    }
}
