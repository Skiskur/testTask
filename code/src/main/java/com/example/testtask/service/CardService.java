package com.example.testtask.service;

import com.example.testtask.entity.Card;

import java.util.List;

public interface CardService {
    public List<Card> getAllCards();

    public Card getCardById(int id);

    public void saveCard(Card card);

    public void deleteCard(int id);

    List<Card> getCardsOfUser(int id);

    void addPoints(int id, int points);

    void subPoints(int id, int points);
}
