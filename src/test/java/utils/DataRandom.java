package utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DataRandom {

    public static String nameRandom() {
        Faker faker = new Faker();
        String name = "QA" + faker.name().firstName();
        return name;
    }


    public static String middleRandom() {
        Faker faker = new Faker();
        String name = "QA" + faker.name().nameWithMiddle();
        return name;
    }

    public static String lastNameRandom() {
        Faker faker = new Faker();
        String name = "QA" + faker.name().firstName();
        return name;
    }


    public static String idRandom() {
        int min = 10000;
        int max = 99999;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return Integer.toString(random_int);
    }



}
