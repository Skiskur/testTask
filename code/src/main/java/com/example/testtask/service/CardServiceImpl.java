package com.example.testtask.service;

import com.example.testtask.dao.CardDAO;
import com.example.testtask.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Override
    @Transactional
    public List<Card> getAllCards() {
        return cardDAO.getAllCards();
    }

    @Override
    @Transactional
    public Card getCardById(int id) {
        return cardDAO.getCardById(id);
    }

    @Override
    @Transactional
    public void saveCard(Card card) {
        cardDAO.addCard(card);
    }

    @Override
    @Transactional
    public void deleteCard(int id) {
        cardDAO.daleteCard(id);
    }

    @Override
    @Transactional
    public List<Card> getCardsOfUser(int id) {
        return cardDAO.getCardsOfUser(id);
    }

    @Override
    @Transactional
    public void addPoints(int id, int points) {
        cardDAO.addPoints(id, points);
    }

    @Override
    @Transactional
    public void subPoints(int id, int points) {
        cardDAO.subPoints(id, points);
    }

}
