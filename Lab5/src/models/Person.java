package models;

public class Person {
    private String name; // Поле не может быть null, строка не может быть пустой
    private int height; // Значение поля должно быть больше 0
    private Color hairColor; // Поле не может быть null
    private Country nationality; // Поле может быть null
    private Location location; // Поле может быть null

    // Конструктор
    public Person(String name, int height, Color hairColor, Country nationality, Location location) {
        this.name = name;
        this.height = height;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым.");
        }
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть больше 0.");
        }
        this.height = height;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        if (hairColor == null) {
            throw new IllegalArgumentException("Цвет волос не может быть null.");
        }
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }
}