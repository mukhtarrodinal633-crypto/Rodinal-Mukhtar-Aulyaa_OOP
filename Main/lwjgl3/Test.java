package io.github.some_example_RodinalMukhtarAulya.frontend;

public class Test {
    public static void main(String[] args) {

        // ==========================================a
        // MODULE 1: BASIC CLASSES & OBJECT INTERACTION
        // ==========================================
        System.out.println("=== TOUHOU OOP PRACTICUM - MODULE 1: BASIC CLASSES & OBJECT INTERACTION ===");

        io.github.some_example_name.frontend.Player reimu = new io.github.some_example_name.frontend.Player("Reimu Hakurei", 100, 15, 3);
        io.github.some_example_name.frontend.Enemy fairyBoss = new io.github.some_example_name.frontend.Enemy("Cirno (Stage 2 Boss)", 50);

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
