import commands.*;
import utils.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    private static CollectionManager collectionManager;
    private static FileManager fileManager;
    private static String filename;

    public static void main(String[] args) {
        // Установка обработчика Ctrl+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (running) {
                System.out.println("\nПолучен сигнал завершения (Ctrl+C). Завершение программы...");
                saveBeforeExit();
            }
        }));

        // Получаем имя файла из переменной окружения
        filename = System.getenv("COLLECTION_FILE");
        if (filename == null || filename.isEmpty()) {
            System.err.println("Не задана переменная окружения COLLECTION_FILE");
            System.exit(1);
        }

        // Инициализация менеджеров
        fileManager = new FileManager();
        collectionManager = new CollectionManager(fileManager);

        // Загрузка коллекции
        try {
            collectionManager.loadCollection(filename);
            System.out.println("Коллекция успешно загружена из файла " + filename);
            System.out.println("Текущее состояние коллекции: " + collectionManager.getCollection().size() + " элементов");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке коллекции: " + e.getMessage());
            System.exit(1);
        }

        // Инициализация менеджера команд
        CommandManager commandManager = new CommandManager(collectionManager, fileManager, filename);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа запущена. Введите 'help' для списка команд.");
        System.out.println("Для выхода введите 'exit' или нажмите Ctrl+C");

        // Основной цикл обработки команд
        while (running) {
            try {
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    continue;
                }

                // Разбиваем ввод на команду и аргументы
                String[] parts = input.split(" ", 2);
                String commandName = parts[0];
                String[] commandArgs = parts.length > 1 ? parts[1].split(" ") : new String[0];

                // Обработка команды выхода
                if ("exit".equalsIgnoreCase(commandName)) {
                    running = false;
                    System.out.println("Завершение программы...");
                    saveBeforeExit();
                    break;
                }

                // Выполнение команды
                commandManager.executeCommand(commandName, commandArgs);

                // Отладочный вывод состояния коллекции
                System.out.println("[DEBUG] Элементов в коллекции: " +
                        collectionManager.getCollection().size());
            } catch (Exception e) {
                System.err.println("Ошибка при выполнении команды: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void saveBeforeExit() {
        try {
            System.out.println("Сохранение коллекции...");
            fileManager.saveToFile(collectionManager.getCollection(), filename);
            System.out.println("Коллекция успешно сохранена в файл " + filename);
            System.out.println("Сохранено элементов: " + collectionManager.getCollection().size());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении коллекции: " + e.getMessage());
        }
    }
}