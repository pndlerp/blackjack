package com.example.blackjack;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class BlackJackController {
    @FXML private VBox menu, mainStage;
    @FXML private HBox dealerCardsBox, playerCardsBox;
    @FXML private Button stand, hit;
    @FXML private Text playerScore, dealerScore;
    private Table table;


    @FXML
    protected void onStartButtonClick() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));


        playerCardsBox.setSpacing(15);
        dealerCardsBox.setSpacing(15);
        menu.setVisible(false);
        table = new Table();
        table.startNewGame();
        pause.setOnFinished(event -> {
                    table.hitDealer();
                    UpdateUI();
                    onHitClick();
                });
        pause.play();

        onHitClick();

        stand.setDisable(false);
        hit.setDisable(false);

        mainStage.setVisible(true);

    }

    @FXML
    protected void onHitClick() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
        hit.setDisable(true);
        pause.setOnFinished(event -> {
            table.hitPlayer();
            UpdateUI();
            hit.setDisable(false);
            if (!table.ifCanContinue()) {
                onStandClick();
            }
        });
        pause.play();

    }

    @FXML
    protected void onStandClick() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.75));
        stand.setDisable(true);
        hit.setDisable(true);
        pause.setOnFinished(event -> {
        table.getDealer().addHiddenCardToList();
        UpdateUI();
        });
        pause.play();
        pause.setOnFinished(event -> {
        UpdateUI();

                    if (table.getDealer().getPoints() < 17) {
                        table.hitDealer();
                        UpdateUI();
                        pause.play();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Game result");
                        switch (table.checkWinCondition()) {
                            case DEALER_WIN -> alert.setHeaderText("You lost.");
                            case PLAYER_WIN -> alert.setHeaderText("You won!");
                            case DRAW -> alert.setHeaderText("Draw.");
                        }
                        alert.setContentText("Press OK to start a new game");
                        Platform.runLater(() -> {
                            alert.showAndWait();
                            onStartButtonClick();
                        });
                    }
                });
        pause.play();



    }

    @FXML
    protected void endScreen(){

    }

    @FXML
    protected void UpdateUI()  {
        dealerCardsBox.getChildren().clear();

        List<Card> cards = table.getDealer().getCards();

        dealerScore.setText("Dealer Score: " + String.valueOf(table.getDealer().getPoints()));

        CardsUI(cards, dealerCardsBox);

        playerCardsBox.getChildren().clear();

        List<Card> cards1 = table.getPlayer().getCards();

        playerScore.setText("Player Score: " +String.valueOf(table.getPlayer().getPoints()));

        CardsUI(cards1, playerCardsBox);
    }

    private void CardsUI(List<Card> cards1, HBox playerCardsBox){
        try {
        for (Card c : cards1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
            Parent cardVisual = loader.load();
            CardController controller = loader.getController();
            controller.setCardData(c);
            playerCardsBox.getChildren().add(cardVisual);
//            Text cardText = new Text(c.toString());
//            cardText.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-font-size: 16;");
//            playerCardsBox.getChildren().add(cardText);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
