package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.projection.UnpaidDetails;
import org.hibernate.Session;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<UnpaidDetails> getAllUnpaid(Session session) {
        return session.createQuery("SELECT new lk.ijse.projection.UnpaidDetails(S.stID, S.name,  S.contact, R.id, R.toPaid) FROM Student AS S INNER JOIN Reservation R ON R.student = S.stID WHERE R.status = 'unpaid'").list();
    }
}
