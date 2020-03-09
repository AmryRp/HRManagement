/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class LocationDaoTest {
    
    public LocationDaoTest() {
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
     * Test of delete method, of class LocationDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Short id = null;
        LocationDao instance = new LocationDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class LocationDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Location loc = null;
        LocationDao instance = new LocationDao();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate(loc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class LocationDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        LocationDao instance = new LocationDao();
        List<Location> expResult = null;
        List<Location> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class LocationDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "";
        LocationDao instance = new LocationDao();
        List<Location> expResult = null;
        List<Location> result = instance.search(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class LocationDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Short id = null;
        LocationDao instance = new LocationDao();
        Location expResult = null;
        Location result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
