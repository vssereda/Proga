package commands;

import utils.CollectionManager;

// info : вывести в стандартный поток вывода информацию о коллекции
// (тип, дата инициализации, количество элементов и т.д.)

public class InfoCommand implements Command {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Тип коллекции: " + collectionManager.getCollection().getClass().getName());
        System.out.println("Дата инициализации: " + collectionManager.getInitDate());
        System.out.println("Количество элементов: " + collectionManager.getCollection().size());
    }
}