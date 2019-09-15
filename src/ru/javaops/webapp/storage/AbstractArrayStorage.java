package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected Resume[] storage = new Resume[10_000];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public abstract void update(Resume resume);

    public abstract void save(Resume resume);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }

        System.out.println("Resume " + uuid + " not exist!");
        System.out.println("----------------------------");
        return null;
    }

    public abstract void delete(String uuid);

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
    //абстрактный метод getIndex - его нужно реализовать в классах потомках
    protected abstract int getIndex(String uuid);



}