package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Resume does not exist!");
            System.out.println("----------------------------");
        }
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage crowded!");
            System.out.println("----------------------------");
        } else {
            int index = getIndex(resume.getUuid());
            if (index == -1) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("Resume already exist!");
                System.out.println("----------------------------");
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }

        System.out.println("Resume does not exist!");
        System.out.println("----------------------------");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume does not exist!");
            System.out.println("----------------------------");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}