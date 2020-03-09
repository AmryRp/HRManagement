/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Employee;
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
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
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
     * Test of save method, of class EmployeeController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String employeeId = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        String phoneNumber = "";
        String hireDate = "";
        String salary = "";
        String commission = "";
        String departmentId = "";
        String managerId = "";
        String jobId = "";
        EmployeeController instance = new EmployeeController();
        String expResult = "";
        String result = instance.save(employeeId, firstName, lastName, email, phoneNumber, hireDate, salary, commission, departmentId, managerId, jobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EmployeeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        EmployeeController instance = new EmployeeController();
        String expResult = "";
        String result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class EmployeeController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
        List<Employee> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class EmployeeController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        int id = 0;
        EmployeeController instance = new EmployeeController();
        boolean expResult = false;
        boolean result = instance.confirm(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
