package com.kodilla;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class Cards {
    private ArrayList<Card> cardsList = new ArrayList<>();
    private FlowPane cards = new FlowPane(Orientation.VERTICAL);
    private boolean croupierCards;

    public Cards(boolean croupierCards) {
        this.croupierCards = croupierCards;
    }

    public void addCard(Card card) {
        cardsList.add(card);
        cards.getChildren().add(card.getCardImageView());
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
        int valueOfCards = 0;
        for (Card card: cardsList) {
            valueOfCards =+ card.getCardValue();
        }
        return valueOfCards;
    }
}
