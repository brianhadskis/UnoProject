/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author Brian
 */
public class Deck extends GroupOfCards {
    
    private ArrayList<Card> cards = new ArrayList();
    
    public Deck(int givenSize) {
        super(givenSize);
        initializeDeck();
    }
    
    private void initializeDeck() {
        
        for (UnoCard.UnoColor c : UnoCard.UnoColor.values()) {
                for (UnoCard.UnoValue v : UnoCard.UnoValue.values()) {
                    UnoCard uCard = new UnoCard();
                    uCard.setColor(c);
                    uCard.setValue(v);
                    if (v != UnoCard.UnoValue.WILD && v != UnoCard.UnoValue.WILDFOUR && v != UnoCard.UnoValue.SHIELD) {
                        ImageView cardImage = new ImageView("images/" + c + "_" + v + ".jpg");
                        uCard.setImage(cardImage);
                    } else {
                        ImageView cardImage = new ImageView("images/" + v + ".jpg");
                        uCard.setImage(cardImage);
                    }
                    this.cards.add(uCard);
                }
        }
        for (UnoCard.UnoColor c : UnoCard.UnoColor.values()) {
                for (UnoCard.UnoValue v : UnoCard.UnoValue.values()) {
                    if (v != UnoCard.UnoValue.ZERO && v != UnoCard.UnoValue.WILD && v != UnoCard.UnoValue.WILDFOUR && v != UnoCard.UnoValue.SHIELD) {
                        UnoCard uCard = new UnoCard();
                        uCard.setColor(c);
                        uCard.setValue(v);
                        if (v != UnoCard.UnoValue.WILD && v != UnoCard.UnoValue.WILDFOUR && v != UnoCard.UnoValue.SHIELD) {
                            ImageView cardImage = new ImageView("images/" + c + "_" + v + ".jpg");
                            uCard.setImage(cardImage);
                        } else {
                            ImageView cardImage = new ImageView("images/" + v + ".jpg");
                            uCard.setImage(cardImage);
                        }
                        this.cards.add(uCard);
                    }
                }
        }
        
        super.setCards(this.cards);

        
//        for (int i = 0; i < 4; i++) {
//            UnoCard uCard = new UnoCard();
//            uCard.setColor(UnoCard.Color.BLACK);
//            uCard.setValue(UnoCard.Value.ZERO);
//            cards.add(uCard);
//        }
//        
//        for (int i = 0; i < 4; i++) {
//            UnoCard uCard = new UnoCard();
//            uCard.setColor(UnoCard.Color.BLACK);
//            uCard.setValue(UnoCard.Value.DRAW);
//            cards.add(uCard);
//        }
    }
    
}
