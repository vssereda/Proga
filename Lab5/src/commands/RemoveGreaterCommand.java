package commands;

import utils.CollectionManager;
import utils.InputHelper;
import models.StudyGroup;

// remove_greater {element} : удалить из коллекции все элементы,
// превышающие заданный

public class RemoveGreaterCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveGreaterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        StudyGroup group = InputHelper.readStudyGroup();
        collectionManager.getCollection().entrySet().removeIf(entry -> entry.getValue().compareTo(group) > 0);
        System.out.println("Элементы удалены.");
    }
}