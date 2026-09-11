package io.github.some_example_RodialMukhtarAulya.frontend;

public class Test {
    public static void main(String[] args) {

        // ==========================================
        // MODULE 1: BASIC CLASSES & OBJECT INTERACTION
        // ==========================================
        System.out.println("=== TOUHOU OOP PRACTICUM - MODULE 1: BASIC CLASSES & OBJECT INTERACTION ===");

        io.github.some_example_RodialMukhtarAulya.frontend.Player reimu = new io.github.some_example_RodialMukhtarAulya.frontend.Player("Reimu Hakurei", 100, 15, 3);
        io.github.some_example_RodialMukhtarAulya.frontend.Enemy fairyBoss = new io.github.some_example_RodialMukhtarAulya.frontend.Enemy("Cirno (Stage 2 Boss)", 50);

        // Menampilkan kondisi awal
        System.out.println("\n--- Initial Battle State ---");
        System.out.println("Player: " + reimu.getName() +
            " | HP: " + reimu.getHp() +
            " | Power: " + reimu.getPower() +
            " | SpellCards: " + reimu.getSpellCards());

        System.out.println("Enemy:  " + fairyBoss.getName() +
            " | HP: " + fairyBoss.getHp());

        // Player menyerang Enemy
        System.out.println("\n--- Turn 1: Player Shoots Enemy ---");
        reimu.shoot(fairyBoss);

        // Enemy menyerang Player
        System.out.println("\n--- Turn 2: Enemy Counter-attacks ---");
        fairyBoss.attack(reimu, 30);

        // Player menyerang Enemy lagi
        System.out.println("\n--- Turn 3: Player Shoots Enemy Finishing Blow ---");
        reimu.shoot(fairyBoss);

        // Enemy memberikan damage fatal
        System.out.println("\n--- Turn 4: Enemy Deals Fatal Damage to Reimu ---");
        fairyBoss.attack(reimu, 80);

        System.out.println("\n=== Battle Simulation Complete ===");


        // ==========================================
        // MODULE 2: ENCAPSULATION, INHERITANCE & SCORE SYSTEM
        // ==========================================
        System.out.println("\n\n=== TOUHOU OOP PRACTICUM - MODULE 2: ENCAPSULATION, INHERITANCE & SCORE SYSTEM ===");

        // Membuat object untuk pengujian Modul 2
        io.github.some_example_RodialMukhtarAulya.frontend.Player reimu2 = new io.github.some_example_RodialMukhtarAulya.frontend.Player("Reimu Hakurei", 100, 15, 3);
        io.github.some_example_RodialMukhtarAulya.frontend.Fairy fairy = new io.github.some_example_RodialMukhtarAulya.frontend.Fairy("Stage 1 Fairy", 20);
        io.github.some_example_RodialMukhtarAulya.frontend.Boss cirno = new io.github.some_example_RodialMukhtarAulya.frontend.Boss("Cirno (Stage 2 Boss)", 150);
        io.github.some_example_RodialMukhtarAulya.frontend.Item pointItem = new io.github.some_example_RodialMukhtarAulya.frontend.Item(200, 450, 12, 12, 120f, "Point Item", 1000L);

        // Menguji encapsulation dan inheritance
        System.out.println("\n--- Testing Encapsulation & Inheritance ---");
        System.out.println("Player: " + reimu2.getName() +
            " | Position: (" + reimu2.getX() + ", " + reimu2.getY() + ")");

        System.out.println("Fairy:  " + fairy.getName() +
            " | Defeat Worth: " + fairy.getScoreValue() + " pts");

        System.out.println("Boss:   " + cirno.getName() +
            " | Defeat Worth: " + cirno.getScoreValue() +
            " pts | Size: " + cirno.getWidth() + "x" + cirno.getHeight());

        System.out.println("Item:   " + pointItem.getItemType() +
            " | Value: " + pointItem.getScoreValue() +
            " pts | Speed: " + pointItem.getSpeed());

        // Menguji pergerakan Item
        System.out.println("\n--- Testing Item Movement Update ---");
        System.out.println("Initial Item Y: " + pointItem.getY());

        pointItem.update(0.5f);

        System.out.println("Item Y after 0.5s update: " +
            pointItem.getY() + " (linear downward movement)");

        // Menguji sistem scoring
        System.out.println("\n--- Testing Scoring System ---");
        System.out.println("Initial Score: " + reimu2.getScore());

        reimu2.shoot(fairy);
        reimu2.collectItem(pointItem);
        reimu2.shoot(cirno);

        System.out.println("Final Score: " + reimu2.getScore() + " pts");

        System.out.println("\n=== Module 2 Test Completed Successfully ===");
    }
}
