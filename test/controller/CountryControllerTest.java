/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Country;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amry4
 */
public class CountryControllerTest {
    
    public CountryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of Save method, of class CountryController.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        String id = "";
        String name = "";
        String regionId = "";
        CountryController instance = new CountryController();
        String expResult = "";
        String result = instance.Save(id, name, regionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CountryController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        CountryController instance = new CountryController();
        String expResult = "";
        String result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class CountryController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        CountryController instance = new CountryController();
        List<Country> expResult = null;
        List<Country> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class CountryController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        String id = "";
        CountryController instance = new CountryController();
        boolean expResult = false;
        boolean result = instance.confirm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
