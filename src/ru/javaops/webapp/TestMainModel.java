package ru.javaops.webapp;

import ru.javaops.webapp.model.Resume;
import ru.javaops.webapp.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Interactive test for ru.javaops.webapp.storage.ArrayStorage implementation
 * (just run, no need to understand)
 */

public class TestMainModel {

    public static void mainTest(Storage ARRAY_STORAGE) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | save uuid | update uuid | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            String uuid = null;
            if (params.length == 2) {
                uuid = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll(ARRAY_STORAGE);
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    r = new Resume();
                    r.setUuid(uuid);
                    ARRAY_STORAGE.save(r);
                    printAll(ARRAY_STORAGE);
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(uuid);
                    printAll(ARRAY_STORAGE);
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(uuid));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll(ARRAY_STORAGE);
                    break;
                case "update":
                    r = new Resume();
                    r.setUuid(uuid);
                    ARRAY_STORAGE.update(r);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    private static void printAll(Storage ARRAY_STORAGE) {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println(ARRAY_STORAGE.size());
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}