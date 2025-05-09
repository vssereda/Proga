package commands;

import utils.CollectionManager;
import models.StudyGroup;
import models.Semester;

public class FilterLessThanSemestErenumCommand implements Command {
    private CollectionManager collectionManager;

    public FilterLessThanSemestErenumCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: filter_less_than_semester_enum semesterEnum");
            return;
        }
        Semester semester = Semester.valueOf(args[1]);
        for (StudyGroup group : collectionManager.getCollection().values()) {
            if (group.getSemesterEnum().compareTo(semester) < 0) {
                System.out.println(group);
            }
        }
    }

    @Override
    public String getName() {
        return "filter_less_than_semester_enum";
    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля semesterEnum которых меньше заданного";
    }
}