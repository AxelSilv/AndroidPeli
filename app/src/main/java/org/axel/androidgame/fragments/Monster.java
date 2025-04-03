package org.axel.androidgame.fragments;

public abstract class Monster {
    private String name;
    private int life;
    private int maxLife;

    public Monster(int maxLife, String name) {
        this.name = name;
        this.maxLife = maxLife;
        this.life = maxLife;
    }

    public void takeDamage(int damage) {
        life -= damage;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public int getMaxLife() {
        return maxLife;
    }
}
