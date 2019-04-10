/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Brian
 */
public class Uno extends Application {
    
    UnoGame game = new UnoGame("The Uno Game");
    
    BorderPane rootPane = new BorderPane();
    Pane gamePane = new Pane();
    GridPane setupPane = new GridPane();
    HBox setupButtonPane = new HBox();
    HBox gameButtonPane = new HBox();
    
    ArrayList<ImageView> displayedHand = new ArrayList();
    
    final int WINDOW_HEIGHT = 600;
    final int WINDOW_WIDTH = 800;
    
    final int HAND_CARD_OFFSET = 60;
    
    ArrayList<Label> lblPlayerNames = new ArrayList();
    ArrayList<TextField> txtPlayerNames = new ArrayList();
    
    ArrayList<UnoPlayer> playerList = new ArrayList();
    
    Button btnStartGame = new Button("Start");
    Button btnDrawCard = new Button("Draw Card");
    Button btnEndTurn = new Button("End Turn");
    
    Rectangle deselectBox = new Rectangle(0, WINDOW_HEIGHT / 2, WINDOW_WIDTH, WINDOW_HEIGHT / 2);
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        deselectBox.setFill(Color.RED);

        for (int i = 0; i < UnoGame.MAX_PLAYERS; i++) {
            lblPlayerNames.add(new Label("Player " + (i + 1) + " Name:"));
            txtPlayerNames.add(new TextField());
            
            setupPane.add(lblPlayerNames.get(i), 0, i);
            setupPane.add(txtPlayerNames.get(i), 1, i);
        }
        
        btnStartGame.setOnAction(new StartGame());
        deselectBox.setOnMouseEntered(new SelectCard(-1));
        
        setupButtonPane.getChildren().add(btnStartGame);
        
        rootPane.setBottom(setupButtonPane);
        rootPane.setCenter(setupPane);
        
        
        
        Scene scene = new Scene(rootPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        primaryStage.setTitle("UNO!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public class StartGame implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try { 
                for (int i = 0; i < UnoGame.MAX_PLAYERS; i++) {
                    if (!txtPlayerNames.get(i).getText().trim().isEmpty() && txtPlayerNames.get(i).getText() != null) {
                        UnoPlayer newPlayer = new UnoPlayer(txtPlayerNames.get(i).getText().trim());
                        playerList.add(newPlayer);
                    }
                }
                
                if (playerList.size() < 2) {
                    playerList.clear();
                    throw new Exception("Not enough players!");
                } else if (playerList.size() > UnoGame.MAX_PLAYERS) {
                    playerList.clear();
                    throw new Exception("Too many players! This should not even happen!");
                }
                
                game.initialize(playerList);
                
                
                btnEndTurn.setOnAction(new EndTurn());
                
                gameButtonPane.getChildren().add(btnDrawCard);
                gameButtonPane.getChildren().add(btnEndTurn);
                
                
                
                rootPane.setCenter(gamePane);
                rootPane.setBottom(gameButtonPane);
                

                game.setup();
                
                displayCards();
                
                
            } catch (Exception ex) {
                Alert dlgGenericError = new Alert(AlertType.ERROR);
                dlgGenericError.setContentText(ex.toString());
                dlgGenericError.show();
            }
        }
    }
    
    public class EndTurn implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            game.play();
            displayCards();
        }
        
    }
    
    public class SelectCard implements EventHandler<MouseEvent> {

        private int selected = -1;
        
        public SelectCard(int selected) {
            this.selected = selected;
        }
        
        @Override
        public void handle(MouseEvent event) {
            if (selected < 0) {
                game.getCurrentPlayer().showCards().clearSelected();
                System.out.println("Select cleared");
            } else {
                game.getCurrentPlayer().showCards().setSelected(selected);
                System.out.println("Card selected");
            }

            displayCards();
        }    
    }
    
    public class DiscardCard implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (!game.hasDiscarded() && event.getButton() == MouseButton.PRIMARY && game.getCurrentPlayer().showCards().getSelected() != -1) {
                
                UnoCard discardCard = (UnoCard) game.getCurrentPlayer().showCards().giveCard(game.getCurrentPlayer().showCards().getSelected());
                
                if (discardCard.getValue() == UnoCard.UnoValue.WILD
                        || discardCard.getValue() == UnoCard.UnoValue.WILDFOUR) {
                    Alert dlgChooseColor = new Alert(AlertType.CONFIRMATION);
                    ButtonType dlgBtnRed = new ButtonType("Red");
                    ButtonType dlgBtnGreen = new ButtonType("Green");
                    ButtonType dlgBtnBlue = new ButtonType("Blue");
                    ButtonType dlgBtnYellow = new ButtonType("Yello");
                    dlgChooseColor.getButtonTypes().addAll(dlgBtnRed, dlgBtnGreen, dlgBtnBlue, dlgBtnYellow);
                    dlgChooseColor.setTitle("Choose Color");
                    dlgChooseColor.setHeaderText("Choose the color for your wild card.");

                    Optional<ButtonType> choice = dlgChooseColor.showAndWait();
                    
                    if (choice.get() == dlgBtnRed) {
                        discardCard.setColor(UnoCard.UnoColor.RED);
                    } else if (choice.get() == dlgBtnGreen) {
                        discardCard.setColor(UnoCard.UnoColor.GREEN);
                    } else if (choice.get() == dlgBtnBlue) {
                        discardCard.setColor(UnoCard.UnoColor.BLUE);
                    } else {
                        discardCard.setColor(UnoCard.UnoColor.YELLOW);
                    }

                }
                
                game.getDiscardPile().addCard(discardCard);
                game.setHasDiscarded();
                
            } else if (game.hasDiscarded() && event.getButton() == MouseButton.PRIMARY) {
                try {
                    game.getCurrentPlayer().addCard(game.getDiscardPile().giveCard(game.getDiscardPile().getLastCard()));
                    game.clearHasDiscarded();
                } catch (Exception ex) {
                    Alert dlgAlert = new Alert(AlertType.ERROR);
                    dlgAlert.setContentText(ex.toString());
                }
            }
            
            game.getCurrentPlayer().showCards().setSelected(-1);
            
            displayCards();
        }
    }
    
    public void displayCards() {
        
        displayedHand.clear();
        gamePane.getChildren().clear();
        gamePane.getChildren().add(deselectBox);
        
        boolean canUseWildFour = true;
        
        for (int i = 0; i < game.getCurrentPlayer().showCards().getSize(); i++) {
            UnoCard card = (UnoCard) game.getCurrentPlayer().showCards().getCard(i);
            if (game.isCardPlayable(card, false)) {
                canUseWildFour = false;
            }
            
        }
        
        double handWidth = UnoCard.getWidth();
        
        for (int i = 1; i < game.getCurrentPlayer().showCards().getSize(); i++) {
            handWidth += HAND_CARD_OFFSET;
        }
        
        double cardXPos = (WINDOW_WIDTH - handWidth) / 2;
        
        for (int i = 0; i < game.getCurrentPlayer().showCards().getSize(); i++) {
            UnoCard card = (UnoCard) game.getCurrentPlayer().showCards().getCard(i);
            displayedHand.add(card.getImage());
            displayedHand.get(i).setX(cardXPos);
            if (game.getCurrentPlayer().showCards().getSelected() == i) {
                displayedHand.get(i).setY(WINDOW_HEIGHT - (UnoCard.getHeight() + (HAND_CARD_OFFSET + 20)));
            } else {
                displayedHand.get(i).setY(WINDOW_HEIGHT - (UnoCard.getHeight() + (HAND_CARD_OFFSET - 40)));
            }
            if (game.isCardPlayable(card, canUseWildFour)) {
                displayedHand.get(i).setOnMouseEntered(new SelectCard(i));
                displayedHand.get(i).setOnMouseClicked(new DiscardCard());
                displayedHand.get(i).setEffect(null);
            } else {
                displayedHand.get(i).setOnMouseEntered(null);
                displayedHand.get(i).setOnMouseClicked(null);
                ColorAdjust cardDim = new ColorAdjust();
                cardDim.setBrightness(-0.6);
                cardDim.setSaturation(0.1);
                displayedHand.get(i).setEffect(cardDim);
            }

            gamePane.getChildren().add(displayedHand.get(i));
            
            cardXPos += HAND_CARD_OFFSET;
        }
        
        UnoCard discardCard = (UnoCard) game.getDiscardPile().getLastCard();
        discardCard.getImage().setX((WINDOW_WIDTH - UnoCard.getWidth()) / 2);
        discardCard.getImage().setY(40);
        discardCard.getImage().setOnMouseEntered(null);
        discardCard.getImage().setOnMouseClicked(new DiscardCard());
        gamePane.getChildren().add(discardCard.getImage());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
