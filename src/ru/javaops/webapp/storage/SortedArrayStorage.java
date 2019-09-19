package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertIndex(Resume resume, int index) {
        index = -index-1;
        for (int j = size; index < j; j--) {
            storage[j] = storage[j-1];
        }
        storage[index] = resume;
        size++;
    }

    @Override
    protected void deleteIndex(int index) {
        for (int j = index; j < size - 1; j++) {
            storage[j] = storage[j + 1];
        }
        size--;
    }
}
