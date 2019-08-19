/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    int size = 0;

    public int search(String uuid) {
        int counter = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                counter = i;
                break;
            }

        }
        return counter;
    }

    public int notification(String uuid) {
        int counter = search(uuid);
        if (counter == -1) {
            System.out.println("Resume does not exist!");
            System.out.println("----------------------------");
        }
        return counter;
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume resume) {
        int j = notification(resume.uuid);
        if (j != -1) {
            storage[j] = resume;
        }
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Storage crowded!");
            System.out.println("----------------------------");
        } else {
            int j = search(r.uuid);
            if (j == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Resume already exist!");
                System.out.println("----------------------------");
            }
        }
    }

    public Resume get(String uuid) {
        int j = notification(uuid);
        if (j != -1) {
            return storage[j];
        }
        return null;
    }

    public void delete(String uuid) {
        int j = notification(uuid);
        if (j != -1) {
            for (int i = j; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size);
        return result;

    }

    public int size() {
        return size;
    }
}