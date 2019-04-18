/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import javafx.application.Application;
import static junit.framework.Assert.assertEquals;
import org.junit.*;
import org.junit.Test;

//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class UnoGameTest {
    
    public UnoGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String [] args = {"test"};
        Application.launch(Uno.class, args);
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of initialize method, of class UnoGame.
//     */
//    @Test
//    public void testInitialize() {
//        System.out.println("initialize");
//        List<UnoPlayer> players = null;
//        UnoGame instance = null;
//        instance.initialize(players);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of setup method, of class UnoGame.
//     */
//    @Test
//    public void testSetup() throws Exception {
//        System.out.println("setup");
//        UnoGame instance = null;
//        instance.setup();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of play method, of class UnoGame.
//     */
//    @Test
//    public void testPlay() {
//        System.out.println("play");
//        UnoGame instance = null;
//        instance.play();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of drawCard method, of class UnoGame.
//     */
//    @Test
//    public void testDrawCard() throws Exception {
//        System.out.println("drawCard");
//        UnoGame instance = null;
//        instance.drawCard();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getCurrentPlayer method, of class UnoGame.
//     */
//    @Test
//    public void testGetCurrentPlayer() {
//        System.out.println("getCurrentPlayer");
//        UnoGame instance = null;
//        UnoPlayer expResult = null;
//        UnoPlayer result = instance.getCurrentPlayer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getDiscardPile method, of class UnoGame.
//     */
//    @Test
//    public void testGetDiscardPile() {
//        System.out.println("getDiscardPile");
//        UnoGame instance = null;
//        Discard expResult = null;
//        Discard result = instance.getDiscardPile();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of hasDiscarded method, of class UnoGame.
//     */
//    @Test
//    public void testHasDiscarded() {
//        System.out.println("hasDiscarded");
//        UnoGame instance = null;
//        boolean expResult = false;
//        boolean result = instance.hasDiscarded();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of setHasDiscarded method, of class UnoGame.
//     */
//    @Test
//    public void testSetHasDiscarded() {
//        System.out.println("setHasDiscarded");
//        UnoGame instance = null;
//        instance.setHasDiscarded();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of clearHasDiscarded method, of class UnoGame.
//     */
//    @Test
//    public void testClearHasDiscarded() {
//        System.out.println("clearHasDiscarded");
//        UnoGame instance = null;
//        instance.clearHasDiscarded();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of setHasDrawn method, of class UnoGame.
//     */
//    @Test
//    public void testSetHasDrawn() {
//        System.out.println("setHasDrawn");
//        UnoGame instance = null;
//        instance.setHasDrawn();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of clearHasDrawn method, of class UnoGame.
//     */
//    @Test
//    public void testClearHasDrawn() {
//        System.out.println("clearHasDrawn");
//        UnoGame instance = null;
//        instance.clearHasDrawn();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of hasDrawn method, of class UnoGame.
//     */
//    @Test
//    public void testHasDrawn() {
//        System.out.println("hasDrawn");
//        UnoGame instance = null;
//        boolean expResult = false;
//        boolean result = instance.hasDrawn();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of isCardPlayable method, of class UnoGame.
     */
    @Test
    public void testIsCardPlayable_Good() {
        System.out.println("isCardPlayable Good");
        UnoCard card = new UnoCard();
        card.setValue(UnoCard.UnoValue.FIVE);
        card.setColor(UnoCard.UnoColor.BLUE);
        
        UnoCard topCard = new UnoCard();
        topCard.setValue(UnoCard.UnoValue.FIVE);
        topCard.setColor(UnoCard.UnoColor.GREEN);
        
        UnoGame instance = new UnoGame("The Uno Game");
        instance.getDiscardPile().addCard(topCard);

        boolean allowWildFour = false;
        
        boolean expResult = true;
        boolean result = instance.isCardPlayable(card, allowWildFour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isCardPlayable method, of class UnoGame.
     */
    @Test
    public void testIsCardPlayable_Bad() {
        System.out.println("isCardPlayable Bad");
        UnoCard card = new UnoCard();
        card.setValue(UnoCard.UnoValue.EIGHT);
        card.setColor(UnoCard.UnoColor.BLUE);
        
        UnoCard topCard = new UnoCard();
        topCard.setValue(UnoCard.UnoValue.FIVE);
        topCard.setColor(UnoCard.UnoColor.GREEN);
        
        UnoGame instance = new UnoGame("The Uno Game");
        instance.getDiscardPile().addCard(topCard);

        boolean allowWildFour = false;
        
        boolean expResult = false;
        boolean result = instance.isCardPlayable(card, allowWildFour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isCardPlayable method, of class UnoGame.
     */
    @Test
    public void testIsCardPlayable_Boundary() {
        System.out.println("isCardPlayable Boundary");
        UnoCard card = new UnoCard();
        card.setValue(UnoCard.UnoValue.WILDFOUR);
        card.setColor(UnoCard.UnoColor.BLUE);
        
        UnoCard topCard = new UnoCard();
        topCard.setValue(UnoCard.UnoValue.FIVE);
        topCard.setColor(UnoCard.UnoColor.GREEN);
        
        UnoGame instance = new UnoGame("The Uno Game");
        instance.getDiscardPile().addCard(topCard);

        boolean allowWildFour = true;
        
        boolean expResult = true;
        boolean result = instance.isCardPlayable(card, allowWildFour);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of declareWinner method, of class UnoGame.
//     */
//    @Test
//    public void testDeclareWinner() {
//        System.out.println("declareWinner");
//        UnoGame instance = null;
//        instance.declareWinner();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
