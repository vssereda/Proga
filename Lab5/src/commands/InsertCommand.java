package commands;

import utils.CollectionManager;
import utils.InputHelper;
import models.StudyGroup;

// insert null {element} : добавить новый элемент с заданным
// ключом

public class InsertCommand implements Command {
    private CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: insert null {element}");
            return;
        }
        String key = args[1];
        StudyGroup group = InputHelper.readStudyGroup();
        collectionManager.add(key, group);
        System.out.println("Элемент добавлен.");
    }
}