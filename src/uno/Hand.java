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
public class Hand extends GroupOfCards {
    
    private int selectedCard = -1;
    
    public Hand(int givenSize) {
        super(givenSize);
    }
    
    public int getSelected() {
        return this.selectedCard;
    }
    
    public void setSelected(int selectedCard) {
        this.selectedCard = selectedCard;
    }
    
}
