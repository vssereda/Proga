import models.*;
import commands.*;
import utils.CollectionManager;
import utils.FileManager;
import utils.InputHelper;

import java.io.IOException;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        // Получаем имя файла из переменной окружения
        String fileName = System.getenv("COLLECTION_FILE");
        if (fileName == null) {
            System.out.println("Ошибка: переменная окружения COLLECTION_FILE не установлена.");
            return;
        }

        // Инициализация менеджеров
        FileManager fileManager = new FileManager(fileName);
        CollectionManager collectionManager = new CollectionManager();

        // Загрузка коллекции из файла
        try {
            Hashtable<String, StudyGroup> collection = fileManager.readFromFile();
            if (collection != null) {
                collectionManager.getCollection().putAll(collection);
                System.out.println("Коллекция успешно загружена из файла.");
            } else {
                System.out.println("Файл пуст или содержит некорректные данные.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Основной цикл программы
        while (true) {
            String input = InputHelper.readString("Введите команду: ");
            String[] parts = input.split(" ");
            String commandName = parts[0];

            switch (commandName) {
                case "help":
                    new HelpCommand().execute(parts);
                    break;
                case "info":
                    new InfoCommand(collectionManager).execute(parts);
                    break;
                case "show":
                    new ShowCommand(collectionManager).execute(parts);
                    break;
                case "insert":
                    new InsertCommand(collectionManager).execute(parts);
                    break;
                case "update":
                    new UpdateCommand(collectionManager).execute(parts);
                    break;
                case "remove_key":
                    new RemoveKeyCommand(collectionManager).execute(parts);
                    break;
                case "clear":
                    new ClearCommand(collectionManager).execute(parts);
                    break;
                case "save":
                    new SaveCommand(collectionManager, fileManager).execute(parts);
                    break;
                case "execute_script":
                    new ExecuteScriptCommand().execute(parts);
                    break;
                case "exit":
                    new ExitCommand().execute(parts);
                    break;
                case "remove_greater":
                    new RemoveGreaterCommand(collectionManager).execute(parts);
                    break;
                case "replace_if_greater":
                    new ReplaceIfGreaterCommand(collectionManager).execute(parts);
                    break;
                case "replace_if_lowe":
                    new ReplaceIfLowerCommand(collectionManager).execute(parts);
                    break;
                case "filter_less_than_semester_enum":
                    new FilterLessThanSemestErenumCommand(collectionManager).execute(parts);
                    break;
                case "filter_greater_than_students_count":
                    new FilterGreaterThanStudentsCountCommand(collectionManager).execute(parts);
                    break;
                case "print_field_descending_form_of_education":
                    new PrintFieldDescendingFormOfEducationCommand(collectionManager).execute(parts);
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите 'help' для справки.");
            }
        }
    }
}