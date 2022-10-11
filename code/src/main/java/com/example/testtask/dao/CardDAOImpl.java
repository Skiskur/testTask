package com.example.testtask.dao;

import com.example.testtask.entity.Card;
import com.example.testtask.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Card> getAllCards() {
        Session session = entityManager.unwrap(Session.class);

        Query<Card> query = session.createQuery("from Card", Card.class);
        List<Card> results = query.getResultList();
        return results;
    }

    @Override
    public Card getCardById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Card.class, id);
    }

    @Override
    public void addCard(Card card) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(card);
    }

    @Override
    public void daleteCard(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("delete from Card where id=:cardId");
        query.setParameter("cardId", id);
        query.executeUpdate();
    }

    @Override
    public List<Card> getCardsOfUser(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Card> query = session.createQuery("from Card where id=:cardId");
        query.setParameter("cardId", id);

        return query.getResultList();
    }

    @Override
    public void addPoints(int id, int points) {
        Session session = entityManager.unwrap(Session.class);
        Card card = session.get(Card.class, id);
        card.addPoints(points);
        session.saveOrUpdate(card);

    }

    @Override
    public void subPoints(int id, int points) {
        Session session = entityManager.unwrap(Session.class);
        Card card = session.get(Card.class, id);
        card.subPoints(points);
        session.saveOrUpdate(card);
    }
}
