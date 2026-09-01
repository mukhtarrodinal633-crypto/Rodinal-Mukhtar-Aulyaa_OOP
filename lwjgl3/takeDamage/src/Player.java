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
    public void tampilkanData() {
        System.out.println("Name       : " + name);
        System.out.println("HP         : " + hp);
        System.out.println("Power      : " + power);
        System.out.println("SpellCards : " + spellCards);
    }
}
