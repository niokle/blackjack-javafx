package com.kodilla;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class Cards {
    private ArrayList<Card> cardsList = new ArrayList<>();
    private FlowPane cards = new FlowPane(Orientation.VERTICAL);
    private boolean croupierCards;
    private int valueOfCards;

    public Cards(boolean croupierCards) {
        this.croupierCards = croupierCards;
    }

    public void addCard(Card card) {
        cardsList.add(card);
        cards.getChildren().add(card.getCardImageView());
        valueOfCards += card.getCardValue();
    }

    public ArrayList<Card> getCardsList() {
        return cardsList;
    }

    public FlowPane getCards() {
        return cards;
    }

    public boolean isCroupierCards() {
        return croupierCards;
    }

    public int getValueOfCards() {
        return valueOfCards;
    }

    public void resetCards() {
        cardsList.clear();
        cards.getChildren().clear();
        valueOfCards = 0;
    }
}
