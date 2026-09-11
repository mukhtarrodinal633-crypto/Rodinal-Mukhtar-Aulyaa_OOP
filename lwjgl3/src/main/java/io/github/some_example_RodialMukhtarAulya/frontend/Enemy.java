package io.github.some_example_RodialMukhtarAulya.frontend;

public class Enemy extends io.github.some_example_RodialMukhtarAulya.frontend.GameObject {
    private String name;
    private int hp;
    private int maxHp;
    private int scoreValue;

    public Enemy(String name, int hp) {
        super(0, 0, 32, 32, 0);
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.scoreValue = 0;
    }

    public boolean takeDamage(int damage) {
        int previousHp = getHp();

        setHp(getHp() - damage);

        System.out.println(getName() + " took " + damage +
            " damage! HP: " + getHp() + "/" + getMaxHp());

        if (getHp() == 0) {
            System.out.println(getName() + " was defeated!");
        }

        return previousHp > 0 && getHp() == 0;
    }

    public void attack(io.github.some_example_RodialMukhtarAulya.frontend.Player player, int damage) {
        System.out.println(getName() +
            " unleashes bullet barrage on " +
            player.getName() + "!");
        player.takeDamage(damage);
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

    public int getMaxHp() {
        return maxHp;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }
}
