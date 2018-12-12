package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Blackjack extends Application {
    private Board board = new Board();
    private Deck deck = new Deck(1);
    private Cards cardsCroupier = new Cards(true);
    private Cards cardsPlayer = new Cards(false);
    private Font font = new Font("Arial", 14);
    private Color fontColor = Color.web("#FFF");
    private Label croupierLabel = new Label();
    private Label playerLabel = new Label();
    private Label resultLabel = new Label();
    private Button buttonHit = new Button();
    private Button buttonStand = new Button();
    private Button buttonNewDeal = new Button();

    public static void main(String[] args) {
        launch(args);
    }

    public void hitAction() {
        cardsPlayer.addCard(deck.getAndRemoveCard());
    }

    public void standAction() {
        if (cardsPlayer.getValueOfCards() > cardsCroupier.getValueOfCards()) {
            resultLabel.setText("Gracz wygrał");
        } else if (cardsPlayer.getValueOfCards() < cardsCroupier.getValueOfCards()) {
            resultLabel.setText("Krupier wygrał");
        } else {
            resultLabel.setText("Remis");
        }
    }

    public void newDealAction() {
        deck.resetDeck(1);
        cardsCroupier.resetCards();
        cardsPlayer.resetCards();
        setCardsCroupier();
        setCardsPlayer();
    }

    public void setCardsCroupier() {
        boolean takeCard = true;
        while (takeCard) {
            cardsCroupier.addCard(deck.getAndRemoveCard());
            if (cardsCroupier.getValueOfCards() > 18) {
                takeCard = false;
            }
        }
    }

    public void setCardsPlayer() {
        cardsPlayer.addCard(deck.getAndRemoveCard());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        croupierLabel.setText("Karty krupiera");
        croupierLabel.setFont(font);
        croupierLabel.setTextFill(fontColor);
        playerLabel.setText("Karty gracza");
        playerLabel.setFont(font);
        playerLabel.setTextFill(fontColor);
        resultLabel.setFont(font);
        resultLabel.setTextFill(fontColor);
        buttonHit.setText("Hit");
        buttonHit.setOnAction(event -> hitAction());
        buttonStand.setText("Stand");
        buttonStand.setOnAction(event -> standAction());
        buttonNewDeal.setText("New deal");
        buttonNewDeal.setOnAction(event -> newDealAction());

        setCardsCroupier();
        setCardsPlayer();


        int columnStart = 37;
        int rowStart = 0;

        board.getGrid().add(cardsCroupier.getCards(), columnStart, rowStart);
        board.getGrid().add(croupierLabel, columnStart,rowStart + 4, columnStart + 6, rowStart + 4);
        board.getGrid().add(cardsPlayer.getCards(), columnStart, rowStart + 25);
        board.getGrid().add(playerLabel, columnStart,rowStart + 21, columnStart + 6, rowStart + 21);
        board.getGrid().add(buttonHit,columnStart,rowStart + 23, columnStart + 3, rowStart + 23);
        board.getGrid().add(buttonStand,columnStart + 5,rowStart + 23, columnStart + 8, rowStart + 23);
        board.getGrid().add(buttonNewDeal,columnStart + 12,rowStart + 23, columnStart + 15, rowStart + 23);
        board.getGrid().add(resultLabel, columnStart,rowStart + 25, columnStart + 6, rowStart + 25);

        Scene scene = new Scene(board.getGrid(), 1600, 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
