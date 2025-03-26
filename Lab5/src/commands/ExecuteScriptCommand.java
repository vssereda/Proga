package commands;

import java.io.File;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: execute_script file_name");
            return;
        }
        String fileName = args[1];
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                System.out.println("Выполняется команда: " + command);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении скрипта: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла";
    }
}