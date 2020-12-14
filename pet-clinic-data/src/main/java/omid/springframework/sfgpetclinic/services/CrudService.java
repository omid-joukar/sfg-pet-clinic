package omid.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
    Set<T> findAll();

    T finfById(ID id);

    T save(T t);

    void delet(T object);

    void deleteById(ID id);

}
