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

//import javafx.scene.image.ImageView;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Brian
 */
public class UnoCardTest {
    
    
    public UnoCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Application.launch(Uno.class, "");
        
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

    /**
     * Test of getValue method, of class UnoCard.
     */
    @Test
    public void testGetValue_Good() {
        System.out.println("getValue Good");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoValue expResult = UnoCard.UnoValue.ONE;
        UnoCard.UnoValue result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getValue method, of class UnoCard.
     */
    @Test
    public void testGetValue_Bad() {
        System.out.println("getValue Bad");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoValue expResult = UnoCard.UnoValue.TWO;
        UnoCard.UnoValue result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getValue method, of class UnoCard.
     */
    @Test
    public void testGetValue_Boundary() {
        System.out.println("getValue Boundary");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoValue expResult = null;
        UnoCard.UnoValue result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPointValue method, of class UnoCard.
     */
    @Test
    public void testGetPointValue_Good() {
        System.out.println("getPointValue Good");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        int expResult = 1;
        int result = instance.getPointValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getPointValue method, of class UnoCard.
     */
    @Test
    public void testGetPointValue_Bad() {
        System.out.println("getPointValue Bad");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        int expResult = 2;
        int result = instance.getPointValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getPointValue method, of class UnoCard.
     */
    @Test
    public void testGetPointValue_Boundary() {
        System.out.println("getPointValue Boundary");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        int expResult = 0;
        int result = instance.getPointValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setValue method, of class UnoCard.
     */
//    @Test
//    public void testSetValue() {
//        System.out.println("setValue");
//        UnoCard.UnoValue value = null;
//        UnoCard instance = new UnoCard();
//        instance.setValue(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void testGetColor_Good() {
        System.out.println("getColor Good");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoColor expResult = UnoCard.UnoColor.YELLOW;
        UnoCard.UnoColor result = instance.getColor();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void testGetColor_Bad() {
        System.out.println("getColor Bad");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoColor expResult = UnoCard.UnoColor.BLUE;
        UnoCard.UnoColor result = instance.getColor();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void testGetColor_Boundary() {
        System.out.println("getColor Boundary");
        UnoCard instance = new UnoCard();
        instance.setValue(UnoCard.UnoValue.ONE);
        instance.setColor(UnoCard.UnoColor.YELLOW);
        UnoCard.UnoColor expResult = null;
        UnoCard.UnoColor result = instance.getColor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setColor method, of class UnoCard.
     */
//    @Test
//    public void testSetColor() {
//        System.out.println("setColor");
//        UnoCard.UnoColor color = null;
//        UnoCard instance = new UnoCard();
//        instance.setColor(color);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setImage method, of class UnoCard.
     */
//    @Test
//    public void testSetImage() {
//        System.out.println("setImage");
//        ImageView cardImage = null;
//        UnoCard instance = new UnoCard();
//        instance.setImage(cardImage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getImage method, of class UnoCard.
     */
//    @Test
//    public void testGetImage() {
//        System.out.println("getImage");
//        UnoCard instance = new UnoCard();
//        ImageView expResult = null;
//        ImageView result = instance.getImage();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getWidth method, of class UnoCard.
     */
//    @Test
//    public void testGetWidth() {
//        System.out.println("getWidth");
//        double expResult = 0.0;
//        double result = UnoCard.getWidth();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getHeight method, of class UnoCard.
     */
//    @Test
//    public void testGetHeight() {
//        System.out.println("getHeight");
//        double expResult = 0.0;
//        double result = UnoCard.getHeight();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getBackImage method, of class UnoCard.
     */
//    @Test
//    public void testGetBackImage() {
//        System.out.println("getBackImage");
//        ImageView expResult = null;
//        ImageView result = UnoCard.getBackImage();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class UnoCard.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        UnoCard instance = new UnoCard();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
