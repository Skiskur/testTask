package com.example.testtask.dao;

import com.example.testtask.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User", User.class);
        List<User> results = query.getResultList();
        return results;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("delete from User where id=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }


}
