package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
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
            } else {
                System.out.println("Resume " + resume.getUuid() + " already exist!");
                System.out.println("----------------------------");
            }
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not exist!");
            System.out.println("----------------------------");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    //реализовали getIndex из абстрактного класса
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}