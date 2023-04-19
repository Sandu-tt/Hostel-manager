package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getAll(Session session) {
        return session.createQuery("FROM User").list();

    }

    @Override
    public void save(User entity, Session session) throws SQLException, ClassNotFoundException {
        session.save(entity);
    }

    @Override
    public void update(User dto, Session session) throws SQLException, ClassNotFoundException {
        session.update(dto);

    }

    @Override
    public User search(String s, Session session) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(User s, Session session) throws SQLException, ClassNotFoundException {

    }


}
