/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class CountryDaoTest {
    
    public CountryDaoTest() {
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
     * Test of delete method, of class CountryDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        CountryDao instance = new CountryDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class CountryDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Country c = null;
        CountryDao instance = new CountryDao();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class CountryDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        CountryDao instance = new CountryDao();
        List<Country> expResult = null;
        List<Country> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class CountryDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        CountryDao instance = new CountryDao();
        List<Country> expResult = null;
        List<Country> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class CountryDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String Id = "";
        CountryDao instance = new CountryDao();
        Country expResult = null;
        Country result = instance.getById(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
