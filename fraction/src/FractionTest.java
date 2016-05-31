package Fraction;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anwar
 */
public class FractionTest {
    
    public FractionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UtilsJUnit4Test: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UtilsJUnit4Test: @tearDownClass method");
    }
    
    @Before
    public void setUpAgain() {
        System.out.println("* UtilsJUnit4Test: @setUp method");
    }
    
    @After
    public void tearDown() {
        System.out.println("* UtilsJUnit4Test: @tearDown method");
    }
    /**
     * Test of toString method, of class Fraction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Fraction instance = new Fraction(2,10);
        String expResult = "1/5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of evaluate method, of class Fraction.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        Fraction instance = new Fraction(5,10);
        double expResult = 0.5;
        double result = instance.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of add method, of class Fraction.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Fraction f2 = new Fraction(2,7);
        Fraction instance = new Fraction(1,5);
        Fraction expResult = new Fraction(17,35);
        Fraction result = instance.add(f2);
        assertEquals(expResult, result);
    }

    /**
     * Test of sub method, of class Fraction.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Fraction f2 = new Fraction(1,5);
        Fraction instance = new Fraction(4,10);
        Fraction expResult = new Fraction(1,5);;
        Fraction result = instance.sub(f2);
        assertEquals(expResult, result);
    }

    /**
     * Test of mul method, of class Fraction.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        Fraction f2 = new Fraction(3,5);
        Fraction instance = new Fraction(2,3);
        Fraction expResult = new Fraction(6,15);
        Fraction result = instance.mul(f2);
        assertEquals(expResult, result);
    }

    /**
     * Test of div method, of class Fraction.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Fraction f2 = new Fraction(2,5);
        Fraction instance = new Fraction(3,7);
        Fraction expResult = new Fraction(15,14);
        Fraction result = instance.div(f2);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class Fraction.
     */
   /* @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = null;
        Fraction.main(argv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}