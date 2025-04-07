package commands;

import utils.CollectionManager;
import utils.InputHelp;
import models.StudyGroup;

// заменить значение по ключу, если новое значение меньше старого

public class ReplaceIfLowerCommand implements Command {
    private CollectionManager collectionManager;

    public ReplaceIfLowerCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Корректное использование: replace_if_lowe null {element}");
            return;
        }
        String key = args[1];
        StudyGroup newGroup = InputHelp.readStudyGroup();
        StudyGroup oldGroup = collectionManager.getCollection().get(key);
        if (oldGroup != null && newGroup.compareTo(oldGroup) < 0) {
            collectionManager.add(key, newGroup);
            System.out.println("Элемент заменён.");
        } else {
            System.out.println("Элемент не заменён.");
        }
    }

    @Override
    public String getName() {
        return "replace_if_lowe";
    }

    @Override
    public String getDescription() {
        return "заменить значение по ключу, если новое значение меньше старого";
    }
}