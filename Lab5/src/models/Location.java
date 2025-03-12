package models;

public class Location {
    private Integer x; // Поле не может быть null
    private Double y; // Поле не может быть null
    private long z;
    private String name; // Строка не может быть пустой, Поле может быть null

    // Конструктор
    public Location(Integer x, Double y, long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    // Геттеры и сеттеры
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException("X не может быть null.");
        }
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        if (y == null) {
            throw new IllegalArgumentException("Y не может быть null.");
        }
        this.y = y;
    }

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
}