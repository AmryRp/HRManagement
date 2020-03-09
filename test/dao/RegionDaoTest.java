/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
public class RegionDaoTest {
    
    public RegionDaoTest() {
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
     * Test of insertOrUpdate method, of class RegionDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Region R = new Region(new BigDecimal("99"), "kkk");
        RegionDao instance = new RegionDao();
        boolean expResult = true;
        boolean result = instance.insertOrUpdate(R);
        assertEquals(expResult, result);
        System.out.println();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
    }

    /**
     * Test of search method, of class RegionDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String R = "Am";
        RegionDao instance = new RegionDao();
         List<Region> itemsToAdd = new ArrayList<>();
        itemsToAdd.add(new Region(new BigDecimal("2")));
        System.out.println(itemsToAdd);
        List<Region> expResult =  itemsToAdd;
        List<Region> result = instance.search(R);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class RegionDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        BigDecimal Id = new BigDecimal("2");
        RegionDao instance = new RegionDao();
        String expResult = "Americas";
        String result = instance.getById(Id).getRegionName();
        System.out.println(result);
        assertEquals(expResult, result);
        

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class RegionDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        RegionDao instance = new RegionDao();
        List<Region> expResult = null;
        List<Region> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of delete method, of class RegionDao.
     */

        @Test
    public void testDelete() {
        System.out.println("delete");
        BigDecimal id = new BigDecimal("99");
        RegionDao instance = new RegionDao();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
