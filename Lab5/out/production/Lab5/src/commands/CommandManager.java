package commands;

import utils.CollectionManager;
import utils.FileManager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final String filename;


    public CommandManager(CollectionManager collectionManager, FileManager fileManager, String filename) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.filename = filename;

        // Регистрация всех команд
        registerCommands();
    }

    //Регистрирует все доступные команды

    private void registerCommands() {
        registerCommand(new HelpCommand(commands));
        registerCommand(new InfoCommand(collectionManager));
        registerCommand(new ShowCommand(collectionManager));
        registerCommand(new InsertCommand(collectionManager));
        registerCommand(new UpdateCommand(collectionManager));
        registerCommand(new RemoveKeyCommand(collectionManager));
        registerCommand(new ClearCommand(collectionManager));
        registerCommand(new SaveCommand(collectionManager, fileManager, filename));
        registerCommand(new ExecuteScriptCommand());
        registerCommand(new ExitCommand());
        registerCommand(new RemoveGreaterCommand(collectionManager));
        registerCommand(new ReplaceIfGreaterCommand(collectionManager));
        registerCommand(new ReplaceIfLowerCommand(collectionManager));
        registerCommand(new FilterLessThanSemestErenumCommand(collectionManager));
        registerCommand(new FilterGreaterThanStudentsCountCommand(collectionManager));
        registerCommand(new PrintFieldDescendingFormOfEducationCommand(collectionManager));
    }

    //Регистрирует отдельную команду

    private void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    // Выполняет команду

    public void executeCommand(String commandName, String[] args) {
        Command cmd = commands.get(commandName);
        if (cmd != null) {
            cmd.execute(args);
        } else {
            System.out.println("Команда '" + commandName + "' не найдена. Введите 'help' для списка команд.");
        }
    }

    // Возвращает зарегистрированные команды
    public Map<String, Command> getCommands() {
        return commands;
    }
}