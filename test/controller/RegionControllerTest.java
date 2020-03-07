/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.util.List;
import model.Region;
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
public class RegionControllerTest {
    
    public RegionControllerTest() {
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
     * Test of Save method, of class RegionController.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        String id = "10";
        String name = "lll";
        RegionController instance = new RegionController();
        String expResult = "sukses";
        String result = instance.Save(id, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RegionController.
     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        String id = "";
//        RegionController instance = new RegionController();
//        String expResult = "";
//        String result = instance.delete(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of search method, of class RegionController.
     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        String Name = "";
//        RegionController instance = new RegionController();
//        List<Region> expResult = null;
//        List<Region> result = instance.search(Name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of confirm method, of class RegionController.
//     */
//    @Test
//    public void testConfirm() {
//        System.out.println("confirm");
//        BigDecimal id = null;
//        RegionController instance = new RegionController();
//        boolean expResult = false;
//        boolean result = instance.confirm(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
