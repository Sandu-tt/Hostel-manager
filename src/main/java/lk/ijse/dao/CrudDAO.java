package lk.ijse.dao;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO {
    List<T> getAll(Session session) throws SQLException, ClassNotFoundException;

    void save(T dto, Session session) throws SQLException, ClassNotFoundException;

    void update(T dto, Session session) throws SQLException, ClassNotFoundException;

    T search(ID id, Session session) throws SQLException, ClassNotFoundException;

    void delete(T obj, Session session) throws SQLException, ClassNotFoundException;
}
