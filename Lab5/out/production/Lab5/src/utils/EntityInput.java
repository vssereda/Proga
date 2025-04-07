package utils;

import models.*;
import java.time.LocalDateTime;

import static utils.InputHelp.*;

public class EntityInput {
    private final ConsoleReader consoleReader;
    private final EnumReader enumReader;
    private final IdGenerator idGenerator;
    private final InputValidator validator;

    public EntityInput(ConsoleReader consoleReader, EnumReader enumReader,
                       IdGenerator idGenerator, InputValidator validator) {
        this.consoleReader = consoleReader;
        this.enumReader = enumReader;
        this.idGenerator = idGenerator;
        this.validator = validator;
    }

    public ConsoleReader getConsoleReader() {
        return this.consoleReader;
    }

    public EnumReader getEnumReader() {
        return this.enumReader;
    }

    public StudyGroup readStudyGroup() {
        System.out.println("\nВведите данные учебной группы:");

        StudyGroup group = new StudyGroup(
                readString("Название группы", false),
                readCoordinates(),
                readLong("Количество студентов", true),
                readInteger("Количество отчисленных", true),
                readFormOfEducation(),
                readSemester(),
                readPerson()
        );
        group.setId(idGenerator.generateId());
        group.setCreationDate(LocalDateTime.now());

        group.setName(consoleReader.readString("Название группы", false));
        group.setCoordinates(readCoordinates());
        group.setStudentsCount(consoleReader.readLong("Количество студентов", true));
        group.setShouldBeExpelled(consoleReader.readInteger("Количество отчисленных", true));
        group.setFormOfEducation(enumReader.readFormOfEducation());
        group.setSemesterEnum(enumReader.readSemester());
        group.setGroupAdmin(readPerson());

        return group;
    }

    public Person readPerson() {
        System.out.println("\nВведите данные администратора группы (оставьте пусто, чтобы пропустить):");
        String name = consoleReader.readString("Имя администратора", true);
        if (name == null) return null;

        Person person = new Person(
                readString("Имя администратора", true),
                readInteger("Рост (целое число > 0)", false),
                readColor(),
                readCountry(),
                readLocation()
        );
        person.setName(name);
        person.setHeight(consoleReader.readInteger("Рост (целое число > 0)", false));
        person.setHairColor(enumReader.readColor());
        person.setNationality(enumReader.readCountry());
        person.setLocation(readLocation());

        return person;
    }

    public Location readLocation() {
        System.out.println("\nВведите данные локации (оставьте пусто, чтобы пропустить):");
        String name = consoleReader.readString("Название локации", true);
        if (name == null) return null;

        return new Location(
                consoleReader.readInteger("Координата X (целое число)", false),
                consoleReader.readDouble("Координата Y (дробное число)", false),
                consoleReader.readLong("Координата Z", false),
                name.isEmpty() ? null : name
        );
    }

    public Coordinates readCoordinates() {
        System.out.println("Введите координаты:");
        while (true) {
            Integer x = consoleReader.readInteger("Координата X (целое число ≤ 394)", false);
            if (!validator.validateCoordinatesX(x)) {
                System.out.println("Координата X должна быть ≤ 394!");
                continue;
            }
            Long y = consoleReader.readLong("Координата Y", false);

            try {
                return new Coordinates(x, y);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в координатах: " + e.getMessage());
            }
        }
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
}