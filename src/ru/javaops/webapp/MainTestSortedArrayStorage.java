package ru.javaops.webapp;

import ru.javaops.webapp.storage.SortedArrayStorage;
import ru.javaops.webapp.storage.Storage;

public class MainTestSortedArrayStorage {
    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        TestModelAll.mainTest(ARRAY_STORAGE);
    }
}
