package commands;

import utils.CollectionManager;

// удалить элемент из коллекции по его ключу

public class RemoveKeyCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Корректное использование: remove_key null");
            return;
        }
        String key = args[1];
        collectionManager.remove(key);
        System.out.println("Элемент удалён.");
    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }
}