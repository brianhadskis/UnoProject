/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author Brian
 */
public class UnoGame extends Game {

    public final static int MAX_PLAYERS = 4;
    
    private Deck deck = new Deck(0);
    private Discard discard = new Discard(0);
    
//    private boolean skipTurn = false;
    private boolean reverseTurn = false;
    private boolean firstTurn = true;
    private boolean hasDiscarded = false;
    private boolean hasDrawn = false;
    
    private ArrayList<UnoPlayer> players = new ArrayList();

    private int nextPlayerMod = 1;      // normally 1, 2 for skip turn - added to currentPlayer to determine next player
    private int currentPlayer = 0;      // player currently taking their turn
                                    // note: when displayed on screen, use + 1
    
    //private Scanner k = new Scanner(System.in);
    
    public UnoGame(String givenName) {
        super(givenName);
    }

    public void initialize(List<UnoPlayer> players) {
        this.players = (ArrayList<UnoPlayer>) players;
    }
    
    public void setup() throws Exception {
//        this.playState = true;
//        this.gameState = true;
        
        
        deck.shuffle();
        System.out.println("Shuffle done");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).addCard(deck.dealCard());
            }
        }
        System.out.println("Dealing done");
        discard.addCard(deck.dealCard());
        System.out.println("discard pile done");
        
        play();
        System.out.println("play() done");
    }
    
    
    @Override
    public void play() {
        
        UnoCard discardTopCard = (UnoCard) discard.getLastCard();
        if (discardTopCard.getValue() == UnoCard.UnoValue.REVERSE) {
            this.reverseTurn = !this.reverseTurn;
        }
        if (firstTurn) {
            currentPlayer = 0;
        } else {
            getCurrentPlayer().setSkipTurn(false);
            getCurrentPlayer().setForcedDraw(0);
            currentPlayer = getNextPlayer();
        }
        System.out.println("Next player selected");
        if (discardTopCard.getValue() == UnoCard.UnoValue.SKIP) {
//            this.skipTurn = true;
            getCurrentPlayer().setSkipTurn(true);
        } 
        
        if (discardTopCard.getValue() == UnoCard.UnoValue.DRAW) {
//            this.forceDraw = true;
            getCurrentPlayer().setForcedDraw(2);
        } else if (discardTopCard.getValue() == UnoCard.UnoValue.WILDFOUR) {
            getCurrentPlayer().setForcedDraw(4);
        }
        
        firstTurn = false;
        clearHasDrawn();
        clearHasDiscarded();
        
    }
    
//    public boolean playerMustDraw() {
//        return this.forceDraw;
//    }
    
    public void forceDraw() {
        UnoCard discardTopCard = (UnoCard) discard.getLastCard();
        
        int forceNum = getCurrentPlayer().getForcedDraw();
        if (forceNum < 0) {
            forceNum = forceNum * -1;
        }
        
        for (int i = 0; i < forceNum; i++) {
            try {
                drawCard();
            } catch (Exception ex) {
                // Need this here as parent play method does not throw exception.
                Alert dlgGenericError = new Alert(Alert.AlertType.ERROR);
                dlgGenericError.setContentText(ex.toString());
                dlgGenericError.show();
            }
        }
        
        
        getCurrentPlayer().setForcedDraw(0);
    }
    
    public void drawCard() throws Exception {
        if (deck.getSize() == 0) {
            UnoCard currentDiscard = (UnoCard) discard.getLastCard();
            deck.setCards(discard.showCards());
            discard.addCard(deck.giveCard(currentDiscard));
            deck.shuffle();
        }
        getCurrentPlayer().addCard(deck.dealCard());
    }
    
    private int getNextPlayer() {
        
        int nextPlayer;
        
        if (reverseTurn == true) {
            nextPlayer = (currentPlayer + (nextPlayerMod * -1));
        } else {
            nextPlayer = currentPlayer + nextPlayerMod;
        }
        
        if (nextPlayer < 0) {
            nextPlayer += players.size();
        } else if (nextPlayer >= players.size()) {
            nextPlayer -= players.size();
        }
        
        return nextPlayer;
    }
    
    public UnoPlayer getShieldTarget() {
        int previousPlayer;
        
        if (reverseTurn == true) {
            previousPlayer = (currentPlayer + nextPlayerMod);
        } else {
            previousPlayer = currentPlayer + (nextPlayerMod * -1);
        }
        
        if (previousPlayer < 0) {
            previousPlayer += players.size();
        } else if (previousPlayer >= players.size()) {
            previousPlayer -= players.size();
        }
        
        return players.get(previousPlayer);
    }
    
    public UnoPlayer getCurrentPlayer() {
        return players.get(currentPlayer);
    }
    
    public ArrayList<UnoPlayer> getUnoPlayers() {
        return players;
    }
    
    public Discard getDiscardPile() {
        
        return discard;
    }
    
    public boolean hasDiscarded() {
        return this.hasDiscarded;
    }
    
    public void setHasDiscarded() {
        this.hasDiscarded = true;
    }
    
    public void clearHasDiscarded() {
        this.hasDiscarded = false;
    }
    
    public void setHasDrawn() {
        this.hasDrawn = true;
    }
    
    public void clearHasDrawn() {
        this.hasDrawn = false;
    }
    
    public boolean hasDrawn() {
        
        return this.hasDrawn;
    }
    
    public boolean isFirstTurn() {
        return this.firstTurn;
    }
    
//    public boolean skipThisTurn() {
//        return this.skipTurn;
//    }
    
    public boolean isCardPlayable(UnoCard card, boolean allowWildFour) {
        
        UnoCard discardCard = (UnoCard) getDiscardPile().getLastCard();
        
        if (hasDiscarded || hasDrawn) {
            return false;
        } else if (firstTurn && (discardCard.getValue() == UnoCard.UnoValue.WILD
                || discardCard.getValue() == UnoCard.UnoValue.WILDFOUR
                || discardCard.getValue() == UnoCard.UnoValue.SHIELD)) {
            return true;
        } else if (players.get(currentPlayer).getSkipTurn() == true && card.getValue() == UnoCard.UnoValue.SHIELD) {
            return true;
        } else if (players.get(currentPlayer).getSkipTurn() == true) {
            return false;
        } else if (card.getValue() == UnoCard.UnoValue.WILDFOUR && allowWildFour) {
            return true;
        } else if (card.getValue() == UnoCard.UnoValue.WILD || card.getValue() == UnoCard.UnoValue.SHIELD) {
            return true;
        } else if (card.getValue() != UnoCard.UnoValue.WILD
                && card.getValue() != UnoCard.UnoValue.WILDFOUR
                && (card.getValue() == discardCard.getValue()
                || card.getColor() == discardCard.getColor())) {
            return true;
        }
        
        return false;
    }
    
    

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
