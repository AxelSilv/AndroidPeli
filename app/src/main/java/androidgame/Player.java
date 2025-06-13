package androidgame;

public class Player {
    private int damage;
    private int score;

    public Player() {
        this.damage = 10;
        this.score = 0;
    }

    public void attack(Monster monster) {
        monster.takeDamage(damage);
        score += 10;
    }

    public int getScore() {
        return score;
    }
}
