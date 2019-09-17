package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    //реализовали getIndex. Использует бинарный поиск.
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void storageFormat() {
        quickSort(storage,0,size-1);
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
