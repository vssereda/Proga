package commands;

import utils.CollectionManager;

// remove_key null : удалить элемент из коллекции по его ключу

public class RemoveKeyCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: remove_key null");
            return;
        }
        String key = args[1];
        collectionManager.remove(key);
        System.out.println("Элемент удалён.");
    }
}