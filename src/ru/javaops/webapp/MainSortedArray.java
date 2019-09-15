package ru.javaops.webapp;

import ru.javaops.webapp.storage.SortedArrayStorage;
import ru.javaops.webapp.storage.Storage;

import java.io.IOException;


/**
 * Interactive test for ru.javaops.webapp.storage.ArrayStorage implementation
 * (just run, no need to understand)
 */

public class MainSortedArray {

    private final static Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) throws IOException {
        TestMainModel.mainTest(ARRAY_STORAGE);
    }
}