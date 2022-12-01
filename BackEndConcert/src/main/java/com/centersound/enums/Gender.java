package com.centersound.enums;

import java.util.Random;

public enum Gender {
    MASCULINE, FEMININE, NEUTRAL;

    private static final Random PRNG = new Random();

    public static Gender random()  {
        Gender[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }




}
