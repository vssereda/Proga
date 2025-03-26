package commands;

import utils.CollectionManager;
import utils.InputHelp;
import models.StudyGroup;

// удалить из коллекции все элементы, превышающие заданный

public class RemoveGreaterCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveGreaterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        StudyGroup group = InputHelp.readStudyGroup();
        collectionManager.getCollection().entrySet().removeIf(entry -> entry.getValue().compareTo(group) > 0);
        System.out.println("Элементы удалены.");
    }

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}