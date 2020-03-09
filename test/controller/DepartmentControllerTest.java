/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Department;
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
public class DepartmentControllerTest {
    
    public DepartmentControllerTest() {
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
     * Test of save method, of class DepartmentController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String Id = "";
        String Name = "";
        String managerId = "";
        String locationId = "";
        DepartmentController instance = new DepartmentController();
        String expResult = "";
        String result = instance.save(Id, Name, managerId, locationId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DepartmentController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        DepartmentController instance = new DepartmentController();
        String expResult = "";
        String result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class DepartmentController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        DepartmentController instance = new DepartmentController();
        List<Department> expResult = null;
        List<Department> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class DepartmentController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        Short id = null;
        DepartmentController instance = new DepartmentController();
        boolean expResult = false;
        boolean result = instance.confirm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
