package commands;

import utils.CollectionManager;
import models.StudyGroup;


// filter_greater_than_students_count studentsCount : вывести
// элементы, значение поля studentsCount которых больше заданного

public class FilterGreaterThanStudentsCountCommand implements Command {
    private CollectionManager collectionManager;

    public FilterGreaterThanStudentsCountCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: filter_greater_than_students_count studentsCount");
            return;
        }
        long studentsCount = Long.parseLong(args[1]);
        for (StudyGroup group : collectionManager.getCollection().values()) {
            if (group.getStudentsCount() != null && group.getStudentsCount() > studentsCount) {
                System.out.println(group);
            }
        }
    }
}