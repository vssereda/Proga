package commands;

import utils.CollectionManager;
import models.StudyGroup;
import models.FormOfEducation;

import java.util.Comparator;
import java.util.stream.Collectors;

// print_field_descending_form_of_education : вывести значения
// поля formOfEducation всех элементов в порядке убывания

public class PrintFieldDescendingFormOfEducationCommand implements Command {
    private CollectionManager collectionManager;

    public PrintFieldDescendingFormOfEducationCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.getCollection().values().stream()
                .sorted(Comparator.comparing(StudyGroup::getFormOfEducation).reversed())
                .map(StudyGroup::getFormOfEducation)
                .forEach(System.out::println);
    }
}