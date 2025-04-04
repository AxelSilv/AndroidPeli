package androidgame;

import java.util.Random;

public class Vampire extends Monster {
    private static final String[] names = {"Drac", "Nosferatu", "The Count"};

    public Vampire() {
        super(new Random().nextInt(30) + 20, names[new Random().nextInt(names.length)]);
    }
}
