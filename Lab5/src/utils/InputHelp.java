package utils;

import models.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import models.StudyGroup;
import models.FormOfEducation;
import models.Semester;

//Утилита для ввода данных с консоли с валидацией

public class InputHelp {
    private static final Scanner scanner = new Scanner(System.in);
    private static long nextId = 1;


    //Читает Location из консоли

    public static Location readLocation() {
        System.out.println("\nВведите данные локации (оставьте пусто, чтобы пропустить):");
        String name = readString("Название локации", true);
        if (name == null) return null;

        return new Location(
                readInteger("Координата X (целое число)", false),
                readDouble("Координата Y (дробное число)", false),
                readLong("Координата Z", false),
                name.isEmpty() ? null : name
        );
    }

    //Читает enum значение с консоли

    private static <T extends Enum<T>> T readEnum(Class<T> enumType, String prompt) {
        T[] constants = enumType.getEnumConstants();
        if (constants == null) {
            return null;
        }

        String[] enumNames = Arrays.stream(enumType.getEnumConstants())
                .map(Enum::name)
                .toArray(String[]::new);
        System.out.println("\n" + prompt + " (Доступные значения: " +
                String.join(", ", enumNames) + ")");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                return null;
            }
            try {
                return Enum.valueOf(enumType, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение! Допустимые варианты: " +
                        Arrays.stream(enumType.getEnumConstants())
                                .map(Enum::name)
                                .collect(Collectors.joining(", ")));
            }
        }
    }

    public static FormOfEducation readFormOfEducation() {
        return readEnum(FormOfEducation.class, "Форма обучения");
    }

    public static Semester readSemester() {
        return readEnum(Semester.class, "Семестр");
    }

    public static Color readColor() {
        return readEnum(Color.class, "Цвет волос");
    }

    public static Country readCountry() {
        return readEnum(Country.class, "Страна");
    }

    public static Long readLong(String prompt, boolean nullable) {
        while (true) {
            System.out.print(prompt + (nullable ? " (или пусто): " : ": "));
            String input = scanner.nextLine().trim();

            if (input.isEmpty() && nullable) {
                return null;
            }

            try {
                long value = Long.parseLong(input);
                if (value <= 0) {
                    System.out.println("Значение должно быть больше 0!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа! Попробуйте еще раз.");
            }
        }
    }

    public static Integer readInteger(String prompt, boolean nullable) {
        while (true) {
            System.out.print(prompt + (nullable ? " (или пусто): " : ": "));
            String input = scanner.nextLine().trim();

            if (input.isEmpty() && nullable) {
                return null;
            }

            try {
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Значение должно быть больше 0!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа! Попробуйте еще раз.");
            }
        }
    }

    public static Double readDouble(String prompt, boolean nullable) {
        while (true) {
            System.out.print(prompt + (nullable ? " (или пусто): " : ": "));
            String input = scanner.nextLine().trim();

            if (input.isEmpty() && nullable) {
                return null;
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа! Попробуйте еще раз.");
            }
        }
    }

    public static String readString(String prompt, boolean nullable) {
        while (true) {
            System.out.print(prompt + (nullable ? " (или пусто): " : ": "));
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                if (nullable) {
                    return null;
                }
                System.out.println("Значение не может быть пустым!");
                continue;
            }
            return input;
        }
    }

    public static StudyGroup readStudyGroup() {
        StudyGroup group = new StudyGroup(
                readString("Название группы", false),
                readCoordinates(),
                readLong("Количество студентов", true),
                readInteger("Количество отчисленных", true),
                readFormOfEducation(),
                readSemester(),
                readPerson()
        );

        // Автогенерация ID и даты создания
        group.setId(generateId());
        group.setCreationDate(LocalDateTime.now());

        System.out.println("\nВведите данные учебной группы:");

        // Обязательные поля
        group.setName(readString("Название группы", false));
        group.setCoordinates(readCoordinates());
        group.setSemesterEnum(readSemester());

        // Необязательные поля
        group.setStudentsCount(readLong("Количество студентов", true));
        group.setShouldBeExpelled(readInteger("Количество отчисленных", true));
        group.setFormOfEducation(readFormOfEducation());
        group.setGroupAdmin(readPerson());

        return group;
    }

    //Читает Person из консоли

    public static Person readPerson() {
        System.out.println("\nВведите данные администратора группы (оставьте пусто, чтобы пропустить):");
        String name = readString("Имя администратора", true);
        if (name == null) return null;

        Person person = new Person(
                readString("Имя администратора", true),
                readInteger("Рост (целое число > 0)", false),
                readColor(),
                readCountry(),
                readLocation()
        );
        person.setName(name);
        person.setHeight(readInteger("Рост (целое число > 0)", false));
        person.setHairColor(readColor());
        person.setNationality(readCountry());
        person.setLocation(readLocation());

        return person;
    }

    //Читает Coordinates из консоли

    public static Coordinates readCoordinates() {
        System.out.println("Введите координаты:");
        while (true) {
            Integer x = readInteger("Координата X (целое число ≤ 394)", false);
            if (x != null && x > 394) {
                System.out.println("Координата X должна быть ≤ 394!");
                continue;
            }
            Long y = readLong("Координата Y", false);
            try {
                return new Coordinates(x, y);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в координатах: " + e.getMessage());
            }
        }
    }


    private static synchronized long generateId() {
        return nextId++;
    }

    public static void setNextId(long id) {
        nextId = id;
    }
}