package io.github.some_example_RodialMukhtarAulya.frontend;

public class Boss extends io.github.some_example_RodialMukhtarAulya.frontend.Enemy {

    public Boss(String name, int hp) {
        super(name, hp);
        setScoreValue(5000);
    }

    @Override
    public boolean takeDamage(int damage) {
        return super.takeDamage(damage);
    }
}
