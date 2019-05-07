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
        for (int k=0; k<storage.length;k++)
        {
            //если не пустое значение
            if (storage[k] == null)
            {
              //присваиваем ему значение, записываем элемент в хранилище
              storage[k] = r;

              //увеличиваем размер хранилища, т.к. добавили элемент
              size = k +1;
              return;
            }
        }
    }

    Resume get(String uuid) {

       for(int i= 0; i<this.size; i++){
           Resume r = storage[i];

           //если соответствует элемент хранилища входному элементу, возвращаем его
           if(r.uuid.equals(uuid)){
               return r;
           }
       }
        return null;
    }

    void delete(String uuid) {

        int index = 99999;
        int i=0;

        //пока есть элементы
        while (i<this.size)
        {
            Resume r = this.storage[i];
            // прооверка на соответсвие найденному элементу
            if (r.uuid.equals(uuid))
            {
                //сохраняем найденный индекс
                index = i;
                break;
            }
        }

        // сдвигаем элементы хранилища, затирая элемент найденный по индексу
        for (i = index; i < this.size - 1; i++)
        {
             this.storage[i] = this.storage[i + 1];
        }


        this.size--;

        if (index == 99999) { return; }

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
