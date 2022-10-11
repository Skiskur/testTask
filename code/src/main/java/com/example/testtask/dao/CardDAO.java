package com.example.testtask.dao;

import com.example.testtask.entity.Card;

import java.util.List;

public interface CardDAO {
    public List<Card> getAllCards();

    public Card getCardById(int id);

    public void addCard(Card card);

    public void daleteCard(int id);

    List<Card> getCardsOfUser(int id);

    void addPoints(int id, int points);

    void subPoints(int id, int points);
}
