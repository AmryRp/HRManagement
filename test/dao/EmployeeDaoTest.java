/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class EmployeeDaoTest {
    
    public EmployeeDaoTest() {
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
     * Test of delete method, of class EmployeeDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = null;
        EmployeeDao instance = new EmployeeDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class EmployeeDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Employee Emp = null;
        EmployeeDao instance = new EmployeeDao();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate(Emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class EmployeeDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        EmployeeDao instance = new EmployeeDao();
        List<Employee> expResult = null;
        List<Employee> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class EmployeeDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String Name = "";
        EmployeeDao instance = new EmployeeDao();
        List<Employee> expResult = null;
        List<Employee> result = instance.search(Name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class EmployeeDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Integer Id = null;
        EmployeeDao instance = new EmployeeDao();
        Employee expResult = null;
        Employee result = instance.getById(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
