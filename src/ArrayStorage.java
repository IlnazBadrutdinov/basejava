/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    int search(String uuid, int j) {

        if (size == storage.length && j == 1) {
            System.out.println("Storage crowded!");
            System.out.println("----------------------------");
            return 0;
        } else {
            int counter = -1;
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    counter = i;
                    break;
                }
            }
            if (counter == -1 && j != 1) {
                System.out.println("Resume does not exist!");
                System.out.println("----------------------------");
            } else if (counter != -1 && j == 1) {
                System.out.println("Resume already exist!");
                System.out.println("----------------------------");
            }
            return counter;
        }
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void update(Resume resume) {
        int j = search(resume.uuid, 0);
        if (j != -1) {
            storage[j] = resume;
        }
    }


    void save(Resume r) {
        //boolean variable = Arrays.asList(storage).contains(r.uuid); - почему всегда false?
        int j = search(r.uuid, 1);
        if (j == -1) {
            storage[size] = r;
            size++;
        }

    }

    Resume get(String uuid) {
        int j = search(uuid, 0);
        if (j != -1) {
            return storage[j];
        }
        return null;
    }

    void delete(String uuid) {
        int j = search(uuid, 0);
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
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;

    }

    int size() {
        return size;
    }
}