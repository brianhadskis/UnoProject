/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class UnoGame extends Game {

    public final static int MAX_PLAYERS = 4;
    
    private Deck deck = new Deck(0);
    private Discard discard = new Discard(0);
    
    private boolean playState = true;
    private boolean gameState = true;
    private boolean hasDiscarded = false;
    
    private ArrayList<UnoPlayer> players = new ArrayList();

    private int nextPlayerMod = 1;      // normally 1, 2 for skip turn - added to currentPlayer to determine next player
    private int currentPlayer = -1;      // player currently taking their turn
                                    // note: when displayed on , use + 1
                                    // nextPlayerMod can be negative depending on reverse turn order
    private boolean reverseTurn = false;
    
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
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).addCard(deck.dealCard());
            }
        }
        discard.addCard(deck.dealCard());
        
        play();
    }
    
    @Override
    public void play() {
        
        currentPlayer = getNextPlayer();
        clearHasDiscarded();
        
    }
    
    private int getNextPlayer() {
        
        
        int nextPlayer = currentPlayer + nextPlayerMod;
        
        if (nextPlayer < 0) {
            nextPlayer += players.size();
        } else if (nextPlayer >= players.size()) {
            nextPlayer -= players.size();
        }
        
        return nextPlayer;
    }
    
    public UnoPlayer getCurrentPlayer() {
        return players.get(currentPlayer);
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
    
    

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
