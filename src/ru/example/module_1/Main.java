package ru.example.module_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private final static int COLUMN_COUNT = 6;
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final List<City> cities = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File("src/ru/example/module_1/input/city_ru.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                cities.add(parse(row));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            logger.warning("File not found");
        }
        cities.forEach(System.out::println);
    }

    private static City parse(String row) {
        String[] data = row.split(";");
        City city;
        if (data.length == COLUMN_COUNT) {
            city = new City(data[1], data[2], data[3], data[4], data[5]);
        } else {
            city = new City(data[1], data[2], data[3], data[4]);
        }
        return city;
    }
}
