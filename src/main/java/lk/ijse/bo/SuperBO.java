package lk.ijse.bo;

import lk.ijse.dto.SuperDTO;

import javax.persistence.NoResultException;
import java.util.List;

public interface SuperBO<T extends SuperDTO, Integer> {

    boolean save(T obj);

    boolean delete(T obj);

    boolean update(T obj);

    String getLastId() throws NoResultException;

    List<T> getAll();

    T get(Integer id);

    boolean isExists(Integer id);
}
