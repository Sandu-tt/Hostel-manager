package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.projection.UnpaidDetails;
import org.hibernate.Session;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<UnpaidDetails> getAllUnpaid(Session session);

}
