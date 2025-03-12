package utils;

import models.StudyGroup;
import java.time.LocalDateTime;
import java.util.Hashtable;

public class CollectionManager {
    private Hashtable<String, StudyGroup> collection = new Hashtable<>();
    private LocalDateTime initDate;

    public CollectionManager() {
        this.initDate = LocalDateTime.now();
    }

    public void add(String key, StudyGroup group) {
        collection.put(key, group);
    }

    public void remove(String key) {
        collection.remove(key);
    }

    public void clear() {
        collection.clear();
    }

    public Hashtable<String, StudyGroup> getCollection() {
        return collection;
    }

    public LocalDateTime getInitDate() {
        return initDate;
    }
}