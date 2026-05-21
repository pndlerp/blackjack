package com.example.blackjack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class BlackJackController {
    @FXML
    private VBox menu, mainStage;
    @FXML
    private Text DealerCard1, DealerCard2, DealerCard3, PlayerCard1, PlayerCard2, PlayerCard3;
    @FXML
    private HBox dealerCardsBox, playerCardsBox;
    @FXML
    private Button stand;
    private Table table;


    @FXML
    protected void onStartButtonClick() {

        playerCardsBox.setSpacing(15);
        dealerCardsBox.setSpacing(15);
        menu.setVisible(false);
        table = new Table();
        table.startNewGame();
        UpdateUI();

        mainStage.setVisible(true);

    }

    @FXML
    protected void onHitClick() {
        table.hitPlayer();
        UpdateUI();
        if(!table.ifCanContinue()){
            onStandClick();
        }

    }

    @FXML
    protected void onStandClick() {
        stand.setDisable(true);
        table.getDealer().addHiddenCardToList();
        UpdateUI();
        while(table.getDealer().getPoints() < 17) {
            table.hitDealer();
            UpdateUI();
        }
        System.out.println(table.checkWinCondition());


    }

    @FXML
    protected void UpdateUI()  {
        dealerCardsBox.getChildren().clear();

        List<Card> cards = table.getDealer().getCards();

        CardsUI(cards, dealerCardsBox);

        playerCardsBox.getChildren().clear();

        List<Card> cards1 = table.getPlayer().getCards();

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
