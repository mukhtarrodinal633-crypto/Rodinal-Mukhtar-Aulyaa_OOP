public class Main {
    public static void main(String[] args) {

        Player player = new Player(
            "Reimu Hakurei",
            100,
            15,
            3
        );

        Enemy enemy = new Enemy(
            "Cirno",
            50
        );

        System.out.println("=== PLAYER ===");
        System.out.println("Name       : " + player.name);
        System.out.println("HP         : " + player.hp);
        System.out.println("Power      : " + player.power);
        System.out.println("SpellCards : " + player.spellCards);

        System.out.println();

        System.out.println("=== ENEMY ===");
        System.out.println("Name       : " + enemy.name);
        System.out.println("HP         : " + enemy.hp);
        System.out.println("MaxHP      : " + enemy.maxHp);
    }
}
