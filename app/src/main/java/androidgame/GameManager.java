package androidgame;

import java.util.Random;

public class GameManager {
    private static GameManager instance;
    private Player player;
    private Monster latestMonster;
    private Random random;

    private GameManager() {
        player = new Player();
        random = new Random();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster generateMonster() {
        Monster monster;
        if (random.nextBoolean()) {
            monster = new Vampire();
        } else {
            monster = new Skeleton();
        }
        latestMonster = monster;
        return monster;
    }

    public Monster getLatestMonster() {
        return latestMonster;
    }
}
