/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Location;
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
public class LocationControllerTest {
    
    public LocationControllerTest() {
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
     * Test of Save method, of class LocationController.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        String Id = "";
        String Address = "";
        String ZipCode = "";
        String City = "";
        String Province = "";
        String idCountry = "";
        LocationController instance = new LocationController();
        String expResult = "";
        String result = instance.Save(Id, Address, ZipCode, City, Province, idCountry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LocationController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String Id = "";
        LocationController instance = new LocationController();
        String expResult = "";
        String result = instance.delete(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class LocationController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        LocationController instance = new LocationController();
        List<Location> expResult = null;
        List<Location> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class LocationController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        Short id = null;
        LocationController instance = new LocationController();
        boolean expResult = false;
        boolean result = instance.confirm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
