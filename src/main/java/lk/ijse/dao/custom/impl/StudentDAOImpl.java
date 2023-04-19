package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> getAll(Session session) throws SQLException, ClassNotFoundException {
        return session.createQuery("FROM Student").list();

    }

    @Override
    public void save(Student dto, Session session) throws SQLException, ClassNotFoundException {
        session.save(dto);
    }

    @Override
    public void update(Student dto, Session session) throws SQLException, ClassNotFoundException {
        session.update(dto);
    }

    @Override
    public Student search(String s, Session session) throws SQLException, ClassNotFoundException {
        return session.get(Student.class, s);
    }

    @Override
    public void delete(Student s, Session session) throws SQLException, ClassNotFoundException {
        session.delete(s);
    }


}
