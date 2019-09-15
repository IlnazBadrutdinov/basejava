package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            storage = quickSort(storage, 0, size-1);
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
                storage = quickSort(storage, 0, size-1);
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
            storage = quickSort(storage, 0, size-1);
        } else {
            System.out.println("Resume " + uuid + " not exist!");
            System.out.println("----------------------------");
        }
    }

    //реализовали getIndex. Использует бинарный поиск.
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    private static Resume[] quickSort(Resume[] resume, int low, int high) {
        if (low >= high) {
            return resume;
        }
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Resume border = resume[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (resume[i].compareTo(border) < 0){
                i++;
            }
            while (resume[j].compareTo(border) > 0) {
                j--;
            }
            if (i <= j) {//меняем местами
                Resume temp = resume[i];
                resume[i] = resume[j];
                resume[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(resume, low, j);
        }
        if (high > i) {
            quickSort(resume, i, high);
        }
        return resume;
    }
}
