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

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            storageFormat();
        } else {
            System.out.println("Resume " + resume.getUuid() + " not exist!");
            System.out.println("----------------------------");
        }
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage overflow!");
            System.out.println("----------------------------");
        } else {
            if (getIndex(resume.getUuid()) < 0) {
                storage[size] = resume;
                size++;
                storageFormat();
            } else {
                System.out.println("Resume " + resume.getUuid() + " already exist!");
                System.out.println("----------------------------");
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }

        System.out.println("Resume " + uuid + " not exist!");
        System.out.println("----------------------------");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            storageFormat();
        } else {
            System.out.println("Resume " + uuid + " not exist!");
            System.out.println("----------------------------");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
    //абстрактный метод getIndex - его нужно реализовать в классах потомках
    protected abstract int getIndex(String uuid);

    protected abstract void storageFormat();



}