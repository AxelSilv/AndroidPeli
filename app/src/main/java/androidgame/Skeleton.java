package androidgame;

import java.util.Random;

public class Skeleton extends Monster {
    private static final String[] names = {"Bonehead", "Clacker", "Mr. Rattle"};

    public Skeleton() {
        super(new Random().nextInt(30) + 20, names[new Random().nextInt(names.length)]);
    }
}
