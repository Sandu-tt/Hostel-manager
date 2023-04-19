package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;


public interface ReservationDAO extends CrudDAO<Reservation, String> {
    Query getReservation(Session session);
}
