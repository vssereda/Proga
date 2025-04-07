package utils;

import models.*;
import java.util.Scanner;

public class InputHelp {
    private static final EntityInput factory = initFactory();

    private static EntityInput initFactory() {
        Scanner scanner = new Scanner(System.in);
        ConsoleReader consoleReader = new ConsoleReader(scanner);
        EnumReader enumReader = new EnumReader(consoleReader);
        IdGenerator idGenerator = new IdGenerator();
        InputValidator validator = new InputValidator();

        return new EntityInput(
                consoleReader,
                enumReader,
                idGenerator,
                validator
        );
    }

    public static StudyGroup readStudyGroup() {
        return factory.readStudyGroup();
    }

    public static Person readPerson() {
        return factory.readPerson();
    }

    public static Location readLocation() {
        return factory.readLocation();
    }

    public static Coordinates readCoordinates() {
        return factory.readCoordinates();
    }

    public static FormOfEducation readFormOfEducation() {
        return factory.getEnumReader().readFormOfEducation();
    }

    public static Semester readSemester() {
        return factory.getEnumReader().readSemester();
    }

    public static Color readColor() {
        return factory.getEnumReader().readColor();
    }

    public static Country readCountry() {
        return factory.getEnumReader().readCountry();
    }

    public static Long readLong(String prompt, boolean nullable) {
        return factory.getConsoleReader().readLong(prompt, nullable);
    }

    public static Integer readInteger(String prompt, boolean nullable) {
        return factory.getConsoleReader().readInteger(prompt, nullable);
    }

    public static Double readDouble(String prompt, boolean nullable) {
        return factory.getConsoleReader().readDouble(prompt, nullable);
    }

    public static String readString(String prompt, boolean nullable) {
        return factory.getConsoleReader().readString(prompt, nullable);
    }

    public static void setNextId(long id) {
        factory.getIdGenerator().setNextId(id);
    }
}