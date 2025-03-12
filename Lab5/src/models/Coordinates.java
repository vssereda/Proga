package models;

public class Coordinates {
    private Integer x; // Максимальное значение поля: 394, Поле не может быть null
    private long y;

    // Конструктор
    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры и сеттеры
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        if (x == null || x > 394) {
            throw new IllegalArgumentException("X не может быть null или больше 394.");
        }
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}