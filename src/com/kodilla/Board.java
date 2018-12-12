package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Board {
    private Image imageback = new Image("file:resources/table.png");
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);
    private GridPane grid = new GridPane();

    public Board() {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(80, 60, 80, 60));
        for (int i = 0; i < 80; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(10));
            grid.getRowConstraints().add(new RowConstraints(10));
        }
        grid.setBackground(background);
    }

    public GridPane getGrid() {
        return grid;
    }
}
