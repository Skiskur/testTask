package com.example.testtask.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Card> cards;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void addNewCard(Card card) {
        if(this.cards == null) {
            cards = new ArrayList<>();
        }
        cards.add(card);
        card.setOwner(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
