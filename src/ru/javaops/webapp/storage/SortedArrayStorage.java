package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertIndex(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }
}
