package commands;

// help : вывести справку по доступным командам

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Доступные команды:");
        System.out.println("help - вывести справку по командам");
        System.out.println("info - вывести информацию о коллекции");
        System.out.println("show - вывести все элементы коллекции");
        System.out.println("insert null {element} - добавить новый элемент с заданным ключом");
        System.out.println("update id {element} - обновить элемент по id");
        System.out.println("remove_key null - удалить элемент по ключу");
        System.out.println("clear - очистить коллекцию");
        System.out.println("save - сохранить коллекцию в файл");
        System.out.println("execute_script file_name - выполнить скрипт из файла");
        System.out.println("exit - завершить программу");
        System.out.println("remove_greater {element} - удалить элементы, превышающие заданный");
        System.out.println("replace_if_greater null {element} - заменить значение по ключу, если новое значение больше старого");
        System.out.println("replace_if_lowe null {element} - заменить значение по ключу, если новое значение меньше старого");
        System.out.println("filter_less_than_semester_enum semesterEnum - вывести элементы, у которых semesterEnum меньше заданного");
        System.out.println("filter_greater_than_students_count studentsCount - вывести элементы, у которых studentsCount больше заданного");
        System.out.println("print_field_descending_form_of_education - вывести значения formOfEducation в порядке убывания");
    }
}