/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

/**
 *
 * @author Brian
 */
public class UnoPlayer extends Player {

    private Hand hand = new Hand(0);
    private int score = 0;
    private boolean skipTurn = false;
    private int forcedDraw = 0;
    
    
    public UnoPlayer(String name) {
        super(name);
    }
    
    public void addCard(Card card) {
        hand.addCard(card);
    }
    
    public Card dealCard() throws Exception {
        return hand.dealCard();
    }
    
    public Hand showCards() {
        return hand;
    }
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void addScore(int score) {
        this.score += score;
    }
    
    public boolean getSkipTurn() {
        return this.skipTurn;
    }
    
    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }
    
    public int getForcedDraw() {
        return this.forcedDraw;
    }
    
    public void setForcedDraw(int forcedDraw) {
        if (this.forcedDraw < 0 && forcedDraw > 0) {
            this.forcedDraw -= forcedDraw;
        } else {
            this.forcedDraw = forcedDraw;
        }
    }

}
