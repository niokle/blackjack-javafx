package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Blackjack extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Board board = new Board();


        Card card1 = new Card("hearts", "A");
        Card card2 = new Card("clubs", "K");
        Card card3 = new Card("hearts", "10");
        Card card4 = new Card("clubs", "5");

        Cards cardsCroupier = new Cards(true);
        Cards cardsPlayer = new Cards(false);

        cardsCroupier.addCard(card1);
        cardsCroupier.addCard(card2);

        cardsPlayer.addCard(card3);
        cardsPlayer.addCard(card4);

        board.getGrid().add(cardsCroupier.getCards(), 9, 0);
        board.getGrid().add(cardsPlayer.getCards(), 9,6);

        Scene scene = new Scene(board.getGrid(), 1600, 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
