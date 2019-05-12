/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size; // раззмер хранилища

    void clear() {
        // перебираем все хранилице и обнуляем поэлементно
          for (int i = 0; i < this.size; i++) {
             this.storage[i] = null; }
    }

    void save(Resume r) {
        // проходим по всему хранилищу
        for (int k=0; k<storage.length;k++){
            //если не пустое значение
            if (storage[k] == null){
              //присваиваем ему значение, записываем элемент в хранилище
              storage[k] = r;
              //увеличиваем размер хранилища, т.к. добавили элемент
              size++;
              return;
            }
        }
    }

    Resume get(String uuid) {
       for(int i= 0; i<size; i++){
           //если соответствует элемент хранилища входному элементу, возвращаем его
           if(this.storage[i].uuid.equals(uuid)){
               return this.storage[i];
           }
       }
        return null;
    }

    void delete(String uuid) {
        //не могу присвоить 0, так как индексация в массиве начинается с 0. И в этом случае будет не всегда корректно выполняться последнее условие
        int index = -1;
        int i=0;

        //пока есть элементы
        while (i<this.size) {
            // прооверка на соответсвие найденному элементу
            if (this.storage[i].uuid.equals(uuid)) {
                //сохраняем найденный индекс
                index = i;
                // сдвигаем элементы хранилища, затирая элемент найденный по индексу
                for (int j = index; j < size - 1; i++) {
                    this.storage[j] = this.storage[j + 1];
                }
                this.size--;
                break;
            }
            i++;
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[this.size];
        // проходим по хранилищу и возвращаем элементы
        for (int i = 0; i < this.size; i++) {
            result[i] = this.storage[i];
        }
        return result;

    }

    int size() {
       return this.size;
    }
}
