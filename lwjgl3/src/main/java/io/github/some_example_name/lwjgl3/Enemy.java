package com.nama.frontend;

public class Enemy {
    String name;
    int hp;
    int maxHp;

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(name + " took " + damage + " damage! HP: " + this.hp + "/" + this.maxHp);
        if (this.hp == 0) {
            System.out.println(name + " was defeated!");
        }
    }

    public void attack(Player player, int damage) {
        System.out.println(name + " unleashes bullet barrage on " + player.name + "!");
        player.takeDamage(damage);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getScoreValue(){
        return scoreValue;
    }
    public void setScoreValue(int scoreValue){
        this.scoreValue = scoreValue;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }
    public boolean takeDamage(int damage){
        setHp(getHp() - damage);
        return getHp() <= 0;
    }
}
