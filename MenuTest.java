

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MenuTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MenuTest
{
    /**
     * Default constructor for test class MenuTest
     */
    public MenuTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
//     @Before
//     public void setUp()
//     {
//     }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
//     @After
//     public void tearDown()
//     {
//     }
    /**
     * Tests to check if it gets user input correctly.
     */
    @Test
    public void Input_Test()
    {
        Menu menu1 = new Menu();
        assertEquals(1, menu1.returnInput());
    }
}

