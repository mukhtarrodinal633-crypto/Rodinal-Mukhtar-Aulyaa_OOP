package frontend;

public class Player {
    public String name;
    public int hp;
    public int power;
    public int spellCards;

    public Player(String name, int hp, int power, int spellCards) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;

        if (this.hp < 0) {
            this.hp = 0;
        }

        if (this.hp > 0) {
            System.out.println(this.name + " took " + damage + " damage! Remaining HP: " + this.hp);
        } else {
            System.out.println(this.name + " took " + damage + " damage! Remaining HP: 0");
            System.out.println(this.name + " was defeated!");
        }
    }

    public void shoot(Enemy target) {
        int damage = this.power + 10;
        System.out.println(this.name + " shoots " + target.name + " dealing " + damage + " DMG!");
        target.takeDamage(damage);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void tampilkanData() {
        System.out.println("Name       : " + name);
        System.out.println("HP         : " + hp);
        System.out.println("Power      : " + power);
        System.out.println("SpellCards : " + spellCards);
    }
}
