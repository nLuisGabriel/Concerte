package com.centersound.enums;

import java.util.Random;

public enum GeographicRegion {
    AFRICA, ASIA, EUROPE, CENTRAL_AMERICA, MIDDLE_EST,
    NORTH_AFRICA, SOUTH_AMERICA, SOUTHEAST_ASIA;

    private static final Random PRNG = new Random();

    public static GeographicRegion random()  {
        GeographicRegion[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}

