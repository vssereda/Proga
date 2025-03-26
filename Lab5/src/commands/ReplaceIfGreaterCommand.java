package commands;

import utils.CollectionManager;
import utils.InputHelp;
import models.StudyGroup;

// заменить значение по ключу, если новое значение больше старого

public class ReplaceIfGreaterCommand implements Command {
    private CollectionManager collectionManager;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: replace_if_greater null {element}");
            return;
        }
        String key = args[1];
        StudyGroup newGroup = InputHelp.readStudyGroup();
        StudyGroup oldGroup = collectionManager.getCollection().get(key);
        if (oldGroup != null && newGroup.compareTo(oldGroup) > 0) {
            collectionManager.add(key, newGroup);
            System.out.println("Элемент заменён.");
        } else {
            System.out.println("Элемент не заменён.");
        }
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "заменить значение по ключу, если новое значение больше старого";
    }
}