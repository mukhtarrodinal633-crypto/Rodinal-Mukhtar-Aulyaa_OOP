package com.RodinalMukhtarAulya.frontend.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.RodinalMukhtarAulya.frontend.objects.bullets.Bullet;
import com.RodinalMukhtarAulya.frontend.objects.enemies.Enemy;
import com.RodinalMukhtarAulya.frontend.objects.items.Item;
import com.RodinalMukhtarAulya.frontend.objects.items.ItemType;

import static com.badlogic.gdx.Gdx.input;

public class Player extends GameObject {
    public String name;
    public int hp;
    public int power;
    public int spellCards;

    private long score;

    public Player(String name, int hp, int power, int spellCards) {
        super(280, 40, 32, 32, 200, Color.RED);

        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        this.score = 0;
    }

    public Player(float x, float y, String name, int hp, int power, int spellCards) {
        super(x, y, 32, 32, 200, Color.RED);

        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        this.score = 0;
    }

    public Bullet shootBullet() {
        int damage = 10 + power;

        System.out.println(
            getName() + " shoots bullet dealing " + damage + " DMG!"
        );

        return new Bullet(
            x + width / 2 - 4,
            y + height,
            400f,
            BulletType.DANMAKU,
            damage
        );
    }

    public void shoot(Enemy target) {
        int damage = 10 + getPower();

        System.out.println(
            getName() + " shoots " +
                target.getName() +
                " dealing " +
                damage +
                " DMG!"
        );

        boolean defeated = target.takeDamage(damage);

        if (defeated) {
            addScore(target.getScoreValue());
        }
    }

    public void collectItem(Item item) {
        ItemType type = item.getItemTypeEnum();

        if (type != null) {
            switch (type) {
                case POWER:
                    this.power += type.getPowerBonus();
                    addScore(item.getScoreValue());
                    System.out.println(
                        name +
                            " collected POWER item! Power increased to " +
                            power
                    );
                    break;

                case POINT:
                    addScore(item.getScoreValue());
                    System.out.println(
                        name + " collected POINT item!"
                    );
                    break;

                case BOMB:
                    this.spellCards += 1;
                    addScore(item.getScoreValue());
                    System.out.println(
                        name +
                            " collected BOMB item! SpellCards: " +
                            spellCards
                    );
                    break;

                case LIFE:
                    this.hp += 20;
                    addScore(item.getScoreValue());
                    System.out.println(
                        name +
                            " collected LIFE item! HP: " +
                            hp
                    );
                    break;
            }
        }
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage);

        System.out.println(
            getName() +
                " took " +
                damage +
                " damage! Remaining HP: " +
                getHp()
        );

        if (getHp() == 0) {
            System.out.println(
                getName() +
                    " was defeated (Pichuun~)!"
            );
        }
    }

    public void addScore(long points) {
        if (points > 0) {
            this.score += points;

            System.out.println(
                getName() +
                    " gained " +
                    points +
                    " pts! Total Score: " +
                    this.score
            );
        }
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpellCards() {
        return spellCards;
    }

    public void setSpellCards(int spellCards) {
        this.spellCards = spellCards;
    }

    public long getScore() {
        return score;
    }
    public void collectItem(Item item) {
        if (item.isDestroyed()) return; // Mencegah item diambil dua kali di frame yang sama
        // ... switch-case type item yang sudah kalian buat sebelumnya ...
        // TODO: Tandai item ini sebagai destroyed agar nanti dihapus oleh Iterator
        // Panggil method destroy() milik item di sini!
    }


    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= speed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed * delta;
        }
    }

    @Override
    public void onCollision(Collidable other) {
        if (other instanceof Item) {
            Item item = (Item) other;

            if (!item.isCollected()) {
                collectItem(item);
                item.setCollected(true);
            }
        }
    }

}
