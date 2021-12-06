package ru.javaops.webapp;

import ru.javaops.webapp.model.Resume;
import ru.javaops.webapp.storage.Storage;

public class TestModelAll {

    public static void mainTest(Storage ARRAY_STORAGE) {

        Resume r1 = new Resume("uuid3");
        Resume r2 = new Resume("uuid1");
        Resume r3 = new Resume("uuid2");
        Resume r4 = new Resume("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("After update(r4)");
        ARRAY_STORAGE.update(r4);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll(ARRAY_STORAGE);

        System.out.println("After delete()");
        ARRAY_STORAGE.delete(r2.getUuid());
        printAll(ARRAY_STORAGE);

        System.out.println("After clear()");
        ARRAY_STORAGE.clear();
        printAll(ARRAY_STORAGE);

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll(Storage ARRAY_STORAGE) {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
