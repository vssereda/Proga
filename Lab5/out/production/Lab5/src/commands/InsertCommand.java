package commands;

import models.StudyGroup;
import utils.CollectionManager;
import utils.InputHelp;

// добавить новый элемент с заданным ключом

public class InsertCommand implements Command {
    private final CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Корректное использование: insert <key> {element}");
            return;
        }

        String key = args[1];
        if (collectionManager.getCollection().containsKey(key)) {
            System.out.println("Элемент с ключом '" + key + "' уже существует");
            return;
        }

        try {
            StudyGroup group = InputHelp.readStudyGroup();
            collectionManager.add(key, group);
            System.out.println("Элемент успешно добавлен с ключом '" + key + "'");
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении элемента: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}