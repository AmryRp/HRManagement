/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Job;
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
public class JobDaoTest {
    
    public JobDaoTest() {
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
     * Test of delete method, of class JobDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        JobDao instance = new JobDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class JobDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Job jb = null;
        JobDao instance = new JobDao();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate(jb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class JobDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        JobDao instance = new JobDao();
        List<Job> expResult = null;
        List<Job> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class JobDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        JobDao instance = new JobDao();
        List<Job> expResult = null;
        List<Job> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class JobDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        String id = "";
        JobDao instance = new JobDao();
        Job expResult = null;
        Job result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
