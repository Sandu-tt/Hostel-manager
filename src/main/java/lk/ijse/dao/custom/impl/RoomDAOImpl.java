package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Room;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {


    @Override
    public List<Room> getAll(Session session) throws SQLException, ClassNotFoundException {
        return session.createQuery("FROM Room").list();
    }

    @Override
    public void save(Room dto, Session session) throws SQLException, ClassNotFoundException {
        session.save(dto);
    }

    @Override
    public void update(Room dto, Session session) throws SQLException, ClassNotFoundException {
        session.update(dto);
    }

    @Override
    public Room search(String s, Session session) throws SQLException, ClassNotFoundException {
        return session.get(Room.class, s);
    }

    @Override
    public void delete(Room s, Session session) throws SQLException, ClassNotFoundException {
        session.delete(s);
    }

}
