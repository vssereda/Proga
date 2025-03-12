package models;

import java.time.LocalDateTime;

public class StudyGroup implements Comparable<StudyGroup> {
    private Long id; // Поле не может быть null, значение должно быть больше 0, уникальное, генерируется автоматически
    private String name; // Поле не может быть null, строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private LocalDateTime creationDate; // Поле не может быть null, генерируется автоматически
    private Long studentsCount; // Значение поля должно быть больше 0, может быть null
    private Integer shouldBeExpelled; // Значение поля должно быть больше 0, может быть null
    private FormOfEducation formOfEducation; // Поле может быть null
    private Semester semesterEnum; // Поле не может быть null
    private Person groupAdmin; // Поле может быть null

    // Статический счётчик для генерации уникального id
    private static long idCounter = 1;

    // Конструктор
    public StudyGroup(String name, Coordinates coordinates, Long studentsCount,
                      Integer shouldBeExpelled, FormOfEducation formOfEducation,
                      Semester semesterEnum, Person groupAdmin) {
        this.id = generateId(); // Генерация уникального id
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now(); // Автоматическая генерация даты создания
        this.studentsCount = studentsCount;
        this.shouldBeExpelled = shouldBeExpelled;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    // Метод для генерации уникального id
    private Long generateId() {
        return idCounter++;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID не может быть null или меньше/равно 0.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым.");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Координаты не могут быть null.");
        }
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        if (creationDate == null) {
            throw new IllegalArgumentException("Дата создания не может быть null.");
        }
        this.creationDate = creationDate;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long studentsCount) {
        if (studentsCount != null && studentsCount <= 0) {
            throw new IllegalArgumentException("Количество студентов должно быть больше 0.");
        }
        this.studentsCount = studentsCount;
    }

    public Integer getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public void setShouldBeExpelled(Integer shouldBeExpelled) {
        if (shouldBeExpelled != null && shouldBeExpelled <= 0) {
            throw new IllegalArgumentException("Количество отчисленных должно быть больше 0.");
        }
        this.shouldBeExpelled = shouldBeExpelled;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        if (semesterEnum == null) {
            throw new IllegalArgumentException("SemesterEnum не может быть null.");
        }
        this.semesterEnum = semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", shouldBeExpelled=" + shouldBeExpelled +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }
}