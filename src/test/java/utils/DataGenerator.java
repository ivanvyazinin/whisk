package utils;

import java.util.Random;

public final class DataGenerator {

    private DataGenerator() {
        throw new IllegalStateException("Utility class");
    }

    private static Random r = new Random();

    public static String getRandomName() {
        return "List N " + r.nextInt(10000);
    }
}
