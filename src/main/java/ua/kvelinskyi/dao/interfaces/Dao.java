package ua.kvelinskyi.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface Dao <T, PK > {

    public void update(T transientObject);

    public void delete(T persistentObject);

    public List<T> getAll();

    public PK create(T newInstance);

    public T read(PK id);


}
