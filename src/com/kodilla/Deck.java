package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private String[] color = new String[] {"clubs","diamonds","hearts","spades"};
    private String[] figures = new String[] {"J","Q","K","A"};

    public Deck() {
        for (String c : color) {
            for(int i = 2; i <= 10; i++) {
                cards.add(new Card(c,Integer.toString(i)));
            }
            for (String f : figures) {
                cards.add(new Card(c,f));
            }
        }
    }
}
