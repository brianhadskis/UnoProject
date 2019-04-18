/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uno;

import javafx.scene.image.ImageView;

/**
 *
 * @author Brian
 */
public class UnoCard extends Card {
    
    private String cardName = new String();
    
    private ImageView cardImage = new ImageView();
    private static ImageView cardBack;
    
    public UnoCard() {
        this.cardBack = new ImageView("images/CARD_BACK.jpg");
    }
    
    public static enum UnoValue {
        ZERO("Zero"),
        ONE("One"),
        TWO("Two"),
        THREE("Three"),
        FOUR("Four"),
        FIVE("Five"),
        SIX("Six"),
        SEVEN("Seven"),
        EIGHT("Eight"),
        NINE("Nine"),
        SKIP("Skip a Turn"),
        REVERSE("Reverse Turns"),
        DRAW("Draw Two"),
        WILD("Wild Card"),
        WILDFOUR("Wild Card - Draw Four"),
        SHIELD("Shield Card");
        private String valueName;
        private UnoValue(String v) {
            this.valueName = v;
        }
    }
    
    public static enum UnoColor {
        RED("Red "),
        YELLOW("Yellow "),
        GREEN("Green "),
        BLUE("Blue ");
        private String colorName;
        private UnoColor(String c) {
            this.colorName = c;
        }
    }
    
    private UnoValue value;
    private UnoColor color;
    //private int pointValue;
    
    public UnoValue getValue() {
        return this.value;
    }
    
    public int getPointValue() {
        
        if (this.value.ordinal() >= 0 && this.value.ordinal() < 10) {
            return this.value.ordinal();
        } else if (this.value.ordinal() >= 10 && this.value.ordinal() < 13) {
            return 20;
        } else {
            return 50;
        }
        
    }
    
    public void setValue(UnoValue value) {
        this.value = value;
    }
    
    public UnoColor getColor() {
        return this.color;
    }
    
    public void setColor(UnoColor color) {
        this.color = color;
    }
    
    public void setImage(ImageView cardImage) {
        this.cardImage = cardImage;
    }
    
    public ImageView getImage() {
        return this.cardImage;
    }
    
    public static double getWidth() {
        return cardBack.getImage().getWidth();
    }
    
    public static double getHeight() {
        return cardBack.getImage().getHeight();
    }
    
    public static ImageView getBackImage() {
        return cardBack;
    }
    
    @Override
    public String toString() {
        if (this.value != UnoValue.WILD && this.value != UnoValue.WILDFOUR && this.value != UnoValue.SHIELD) {
            cardName = color.colorName + value.valueName;
        } else {
            cardName = value.valueName;
        }
        return cardName;
    }


}
