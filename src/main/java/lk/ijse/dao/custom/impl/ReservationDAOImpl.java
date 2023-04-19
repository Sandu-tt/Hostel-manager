package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {


    @Override
    public List<Reservation> getAll(Session session) throws SQLException, ClassNotFoundException {
        return session.createQuery("FROM Reservation").list();
    }

    @Override
    public void save(Reservation dto, Session session) throws SQLException, ClassNotFoundException {
        session.save(dto);

    }

    @Override
    public void update(Reservation dto, Session session) throws SQLException, ClassNotFoundException {
        session.update(dto);

    }

    @Override
    public Reservation search(String s, Session session) throws SQLException, ClassNotFoundException {
        return session.get(Reservation.class, s);
    }

    @Override
    public void delete(Reservation s, Session session) throws SQLException, ClassNotFoundException {
        session.delete(s);

    }

    @Override
    public Query getReservation(Session session) {
        return session.createQuery("FROM Reservation ORDER BY id DESC");
    }
}
