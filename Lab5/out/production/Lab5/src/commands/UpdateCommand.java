package commands;

import utils.CollectionManager;
import utils.InputHelp;
import models.StudyGroup;

// обновить значение элемента коллекции, id которого равен заданному

public class UpdateCommand implements Command {
    private CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Корректное использование: update id {element}");
            return;
        }
        long id = Long.parseLong(args[1]);
        StudyGroup newGroup = InputHelp.readStudyGroup();
        for (StudyGroup group : collectionManager.getCollection().values()) {
            if (group.getId().equals(id)) {
                collectionManager.getCollection().put(group.getName(), newGroup);
                System.out.println("Элемент обновлён.");
                return;
            }
        }
        System.out.println("Элемент с id " + id + " не найден.");
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}