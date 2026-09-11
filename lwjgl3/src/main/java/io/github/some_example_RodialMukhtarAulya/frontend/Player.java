package io.github.some_example_RodialMukhtarAulya.frontend;

public class Player extends io.github.some_example_RodialMukhtarAulya.frontend.GameObject {
    private String name;
    private int hp;
    private int power;
    private int spellCards;
    private long score;

    public Player(String name, int hp, int power, int spellCards) {
        super(0, 0, 32, 32, 0);
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        this.score = 0;
    }

    public void shoot(io.github.some_example_RodialMukhtarAulya.frontend.Enemy target) {
        int damage = 10 + getPower();

        System.out.println(getName() + " shoots " + target.getName()
            + " dealing " + damage + " DMG!");

        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        setHp(getHp() - damage);

        System.out.println(getName() + " took " + damage
            + " damage! Remaining HP: " + getHp());

        if (getHp() == 0) {
            System.out.println(getName() + " was defeated (Pichuun~)!");
        }
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addScore(long points) {
        if (points > 0) {
            this.score += points;

            System.out.println(getName() + " gained " + points
                + " pts! Total Score: " + this.score);
        }
    }

    public void collectItem(io.github.some_example_RodialMukhtarAulya.frontend.Item item) {
        System.out.println(getName() + " collected "
            + item.getItemType() + "!");

        if (item.getScoreValue() > 0) {
            addScore(item.getScoreValue());
        }
    }
}
