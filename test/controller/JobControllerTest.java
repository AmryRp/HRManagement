/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class JobControllerTest {
    
    public JobControllerTest() {
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
     * Test of save method, of class JobController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String id = "";
        String title = "";
        String minSalary = "";
        String maxSalary = "";
        JobController instance = new JobController();
        String expResult = "";
        String result = instance.save(id, title, minSalary, maxSalary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class JobController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        JobController instance = new JobController();
        String expResult = "";
        String result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class JobController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        JobController instance = new JobController();
        List<Job> expResult = null;
        List<Job> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class JobController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        String id = "";
        JobController instance = new JobController();
        boolean expResult = false;
        boolean result = instance.confirm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
