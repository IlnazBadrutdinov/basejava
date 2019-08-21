/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size + 1, null);
        size = 0; 
    }

    public void update(Resume resume) {
        int index = getIndex(resume.uuid);

        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Resume does not exist!");
            System.out.println("----------------------------");
        }
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Storage crowded!");
            System.out.println("----------------------------");
        } else {
            int index = getIndex(r.uuid);
            if (index == -1) {
                storage[size] = r;
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
        } else {
            System.out.println("Resume does not exist!");
            System.out.println("----------------------------");
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            for (int i = index; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
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
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}