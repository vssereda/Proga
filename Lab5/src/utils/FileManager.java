package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.StudyGroup;
import java.io.*;
import java.util.Hashtable;

public class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public Hashtable<String, StudyGroup> readFromFile() throws IOException {
        Gson gson = new Gson();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
            return gson.fromJson(reader, new TypeToken<Hashtable<String, StudyGroup>>() {}.getType());
        }
    }

    public void saveToConsole(Hashtable<String, StudyGroup> collection) {
        Gson gson = new Gson();
        String json = gson.toJson(collection);
        System.out.println("Вывод коллекции в консоль:");
        System.out.println(json);
    }
}