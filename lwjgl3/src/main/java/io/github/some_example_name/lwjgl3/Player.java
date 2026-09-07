package com.nama.frontend;

public class Player {
    String name;
    int hp;
    int power;
    int spellCards;

    public Player(String name, int hp, int power, int spellCards) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
    }

    public void shoot(Enemy target) {
        int damage = 10 + getPower();
        System.out.println(getName() + " shoots " + target.getName() + " dealing " + damage + " DMG!");
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(name + " took " + damage + " damage! Remaining HP: " + this.hp);
        if (this.hp == 0) {
            System.out.println(name + " was defeated (Pichuun~)! ");
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }
    public String getname(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPower(){
        return power;
    }
    public String getSpellCards(String spellCards){
        this.spellCards = spellCards;
    }
    public int getScore(){
        return score;
    }
    public void takeDamage(int damage) {
        setHp(getHp() - damage);
    }
}
