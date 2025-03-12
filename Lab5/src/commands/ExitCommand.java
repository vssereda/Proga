package commands;


// exit : завершить программу (без сохранения в файл)
public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Завершение программы.");
        System.exit(0);
    }
}