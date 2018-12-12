package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private String cardColor;
    private String cardRank;
    private int cardValue;
    private Image cardImage;
    private ImageView cardImageView;

    public Card(String cardColor, String cardRank) {
        double cardImageViewNewHeight;
        double cardImageViewNewWidth;

        this.cardColor = cardColor;
        this.cardRank = cardRank;

        if (cardRank == "J" || cardRank == "Q" || cardRank == "K") {
            cardValue = 10;
        } else if (cardRank == "A") {
            cardValue = 11;
        } else {
            cardValue = Integer.parseInt(cardRank);
        }

        cardImage = new Image("file:resources/cards/" + cardColor + cardRank + ".png");
        cardImageView = new ImageView(cardImage);
        cardImageView.setFitHeight(80);
        cardImageView.setFitWidth(60);
    }

    public String getCardColor() {
        return cardColor;
    }

    public String getCardRank() {
        return cardRank;
    }

    public int getCardValue() {
        return cardValue;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public ImageView getCardImageView() {
        return cardImageView;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}
