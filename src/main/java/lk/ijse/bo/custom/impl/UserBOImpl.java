package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.DAOTypes;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.USER);

    @Override
    public boolean save(UserDTO obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.save(obj.toUserDTO(), session);
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
    public boolean delete(UserDTO obj) {
        return true;
    }

    @Override
    public boolean update(UserDTO obj) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.update(obj.toUserDTO(), session);
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
    public List<UserDTO> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();

        List<UserDTO> result = new ArrayList<>();

        try {
            List<User> all = userDAO.getAll(session);
            for (User c : all
            ) {
                result.add(c.toUserDTO());
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
    public UserDTO get(Integer id) {
        return null;
    }

    @Override
    public boolean isExists(Integer id) {
        return false;
    }
}
