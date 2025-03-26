package utils;

import models.StudyGroup;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Hashtable;

// Менеджер для работы с файлами коллекции

public class FileManager {
    private final Gson gson;

    public FileManager() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    //Загружает коллекцию из файла
    //IOException если произошла ошибка ввода-вывода

    public Hashtable<String, StudyGroup> loadFromFile(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type type = new TypeToken<Hashtable<String, StudyGroup>>() {
            }.getType();
            Hashtable<String, StudyGroup> loaded = gson.fromJson(reader, type);
            return loaded != null ? loaded : new Hashtable<>();
        } catch (JsonParseException e) {
            throw new IOException("Ошибка парсинга JSON: " + e.getMessage());
        }
    }

    //Сохраняет коллекцию в файл
    //IOException если произошла ошибка ввода-вывода

    public void saveToFile(Hashtable<String, StudyGroup> collection, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(collection, writer);
        }
    }
}