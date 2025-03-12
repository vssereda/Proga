package utils;

import models.*;
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    public static long readLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    public static StudyGroup readStudyGroup() {
        System.out.println("Введите данные для StudyGroup:");
        String name = readString("Имя: ");
        Coordinates coordinates = readCoordinates();
        Long studentsCount = readLong("Количество студентов: ");
        Integer shouldBeExpelled = readInt("Количество отчисленных: ");
        FormOfEducation formOfEducation = readFormOfEducation();
        Semester semesterEnum = readSemester();
        Person groupAdmin = readPerson();

        return new StudyGroup(null, name, coordinates, LocalDateTime.now(), studentsCount, shouldBeExpelled, formOfEducation, semesterEnum, groupAdmin);
    }

    public static Coordinates readCoordinates() {
        System.out.println("Введите данные для Coordinates:");
        Integer x = readInt("X: ");
        long y = readLong("Y: ");
        return new Coordinates(x, y);
    }

    public static Person readPerson() {
        System.out.println("Введите данные для Person:");
        String name = readString("Имя: ");
        int height = readInt("Рост: ");
        Color hairColor = readColor();
        Country nationality = readCountry();
        Location location = readLocation();
        return new Person(name, height, hairColor, nationality, location);
    }

    public static Location readLocation() {
        System.out.println("Введите данные для Location:");
        Integer x = readInt("X: ");
        Double y = readDouble("Y: ");
        long z = readLong("Z: ");
        String name = readString("Название: ");
        return new Location(x, y, z, name);
    }

    public static FormOfEducation readFormOfEducation() {
        System.out.println("Доступные значения FormOfEducation:");
        for (FormOfEducation form : FormOfEducation.values()) {
            System.out.println(form);
        }
        while (true) {
            try {
                return FormOfEducation.valueOf(readString("Введите FormOfEducation: "));
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введите корректное значение.");
            }
        }
    }

    public static Semester readSemester() {
        System.out.println("Доступные значения Semester:");
        for (Semester semester : Semester.values()) {
            System.out.println(semester);
        }
        while (true) {
            try {
                return Semester.valueOf(readString("Введите Semester: "));
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введите корректное значение.");
            }
        }
    }

    public static Color readColor() {
        System.out.println("Доступные значения Color:");
        for (Color color : Color.values()) {
            System.out.println(color);
        }
        while (true) {
            try {
                return Color.valueOf(readString("Введите Color: "));
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введите корректное значение.");
            }
        }
    }

    public static Country readCountry() {
        System.out.println("Доступные значения Country:");
        for (Country country : Country.values()) {
            System.out.println(country);
        }
        while (true) {
            try {
                return Country.valueOf(readString("Введите Country: "));
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введите корректное значение.");
            }
        }
    }
}