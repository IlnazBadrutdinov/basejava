package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertIndex(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteIndex(int index) {
        storage[index] = storage[size - 1];
    }
}