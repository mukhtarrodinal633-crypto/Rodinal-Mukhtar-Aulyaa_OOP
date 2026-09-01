public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Reimu Hakurei", 100, 15, 3);

        Enemy enemy1 = new Enemy("Cirno", 50);

        System.out.println("=== PLAYER ===");
        System.out.println("Name       : " + player1.name);
        System.out.println("HP         : " + player1.hp);
        System.out.println("Power      : " + player1.power);
        System.out.println("SpellCards : " + player1.spellCards);

        System.out.println();

        System.out.println("=== ENEMY ===");
        System.out.println("Name       : " + enemy1.name);
        System.out.println("HP         : " + enemy1.hp);
        System.out.println("MaxHP      : " + enemy1.maxHp);
    }
}
