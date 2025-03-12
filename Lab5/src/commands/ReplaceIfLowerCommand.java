package commands;

import utils.CollectionManager;
import utils.InputHelper;
import models.StudyGroup;

// replace_if_lowe null {element} : заменить значение по ключу,
// если новое значение меньше старого

public class ReplaceIfLowerCommand implements Command {
    private CollectionManager collectionManager;

    public ReplaceIfLowerCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: replace_if_lowe null {element}");
            return;
        }
        String key = args[1];
        StudyGroup newGroup = InputHelper.readStudyGroup();
        StudyGroup oldGroup = collectionManager.getCollection().get(key);
        if (oldGroup != null && newGroup.compareTo(oldGroup) < 0) {
            collectionManager.add(key, newGroup);
            System.out.println("Элемент заменён.");
        } else {
            System.out.println("Элемент не заменён.");
        }
    }
}