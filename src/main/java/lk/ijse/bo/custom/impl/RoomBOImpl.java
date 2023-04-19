package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.DAOTypes;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.entity.Room;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ROOM);

    @Override
    public boolean save(RoomDTO obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.save(obj.toRoom(), session);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(RoomDTO obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.delete(obj.toRoom(), session);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(RoomDTO obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.update(obj.toRoom(), session);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public String getLastId() throws NoResultException {
        return null;
    }

    @Override
    public List<RoomDTO> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        List<RoomDTO> result = new ArrayList<>();

        try {
            List<Room> all = roomDAO.getAll(session);
            for (Room c : all
            ) {
                result.add(c.toRoomDTO());
            }
            return result;

        } catch (NullPointerException e) {
            e.printStackTrace();

            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public RoomDTO get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Room room = roomDAO.search(id, session);
            transaction.commit();
            session.close();
            return room.toRoomDTO();
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    @Override
    public boolean isExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        boolean b = false;

        try {
            transaction = session.beginTransaction();
            Room search = roomDAO.search(id, session);
            b = search != null;
            transaction.commit();
        } catch (HibernateException | SQLException | ClassNotFoundException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return b;
    }
}
