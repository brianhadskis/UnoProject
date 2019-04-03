/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package uno;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards = new ArrayList();
    private int maxSize;//the maximum size of the grouping, 0 for no max
    
    public GroupOfCards(int givenSize)
    {
        maxSize = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public Card getCard(int index) {
        return this.cards.get(index);
    }
    
    public boolean hasCard(Card card) {
        return this.cards.contains(card); 
    }
    
    public Card giveCard(Card card) throws Exception {
        if (this.cards.contains(card)) {
            this.cards.remove(card);
            return card;
        }
        else {
            throw new Exception();
        }
    }
    
    public Card giveCard(int cardIndex) {
        Card card = this.cards.get(cardIndex);
        this.cards.remove(cardIndex);
        
        return card;
        
    }
    
    public Card dealCard() throws Exception {
        if (this.cards.size() > 0) {
            Card uCard = this.cards.get(0);
            //this.cards.remove(0);
            this.cards.remove(0);
            return uCard;
        }
        else {
            throw new Exception("No cards in group");
        }
    }
    
    public Card getFirstCard() {
        return cards.get(0);
    }
    
    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setMaxSize(int givenSize) {
        maxSize = givenSize;
    }
    
    public int getSize() {
        return cards.size();
    }
    
}//end class
