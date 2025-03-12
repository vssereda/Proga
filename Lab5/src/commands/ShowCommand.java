package commands;

import utils.CollectionManager;
import models.StudyGroup;

// show : вывести в стандартный поток вывода все элементы коллекции
// в строковом представлении

public class ShowCommand implements Command {
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        for (String key : collectionManager.getCollection().keySet()) {
            StudyGroup group = collectionManager.getCollection().get(key);
            System.out.println("Ключ: " + key + ", Элемент: " + group);
        }
    }
}