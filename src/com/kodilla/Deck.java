package com.kodilla;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private String[] color = new String[] {"clubs","diamonds","hearts","spades"};
    private String[] figures = new String[] {"J","Q","K","A"};

    public Deck(int numberOfDecks) {
        resetDeck(numberOfDecks);
    }

    public void resetDeck(int numberOfDecks) {
        cards.clear();
        for (int deck = 1; deck <= numberOfDecks; deck++) {
            for (String c : color) {
                for (int i = 2; i <= 10; i++) {
                    cards.add(new Card(c, Integer.toString(i)));
                }
                for (String f : figures) {
                    cards.add(new Card(c, f));
                }
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        List<Card> shuffledCards = new ArrayList<>();
        int index;
        Random random = new Random();
        while (cards.size() > 0) {
            if (cards.size() == 1) {
                shuffledCards.add(cards.get(0));
                cards.remove(0);
            } else {
                index = random.nextInt(cards.size());
                shuffledCards.add(cards.get(index));
                cards.remove(index);
            }
        }
        cards = shuffledCards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getAndRemoveCard() {
        Card card;
        if (cards.size() == 0) {
            card = null;
        } else {
            card = cards.get(0);
            cards.remove(0);
        }
        return card;
    }
}
