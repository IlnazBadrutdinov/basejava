package ru.javaops.webapp;

import ru.javaops.webapp.storage.ArrayStorage;
import ru.javaops.webapp.storage.Storage;

public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        TestModelAll.mainTest(ARRAY_STORAGE);
    }
}
