package com.example.testtask.controller;

import com.example.testtask.entity.Card;
import com.example.testtask.entity.User;
import com.example.testtask.service.CardService;
import com.example.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> result = userService.getAllUsers();
        return result;
    }

//    @PostMapping("/users/{user_id}/addCard")
//    public void addUserToCard(@PathVariable int ,Card card) {
//        cardService.addCardToUser(card);
//    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/users/{id}/cards")
    public List<Card> getUserCards(@PathVariable int id) {
        return cardService.getCardsOfUser(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    @GetMapping("/cards")
    public List<Card> getAllCards() {
        List<Card> result = cardService.getAllCards();
        return result;
    }

    @PostMapping("/cards/{id}/addPoints={points}")
    public void addPoints(@PathVariable int id, @PathVariable int points) {
        cardService.addPoints(id, points);
    }

    @PostMapping("/cards/{id}/subPoints={points}")
    public void subPoints(@PathVariable int id, @PathVariable int points) {
        cardService.subPoints(id, points);
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable int id) {
        return cardService.getCardById(id);
    }

    @PostMapping("/cards")
    public void addCard(@RequestBody Card Card) {
        cardService.saveCard(Card);
    }

    @DeleteMapping("cards/{id}")
    public void deleteCard(@PathVariable int id) {
        cardService.deleteCard(id);
    }


}
