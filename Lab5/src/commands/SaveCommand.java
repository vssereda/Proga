package commands;

import utils.CollectionManager;
import utils.FileManager;

// save : сохранить коллекцию в файл

public class SaveCommand implements Command {
    private CollectionManager collectionManager;
    private FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            fileManager.saveToFile(collectionManager.getCollection());
            System.out.println("Коллекция сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}