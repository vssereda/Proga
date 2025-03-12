package commands;

import utils.CollectionManager;

// Clear : очистить коллекцию

public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
        System.out.println("Коллекция очищена.");
    }
}