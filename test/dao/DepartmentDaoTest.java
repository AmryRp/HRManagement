/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DepartmentDaoTest {
    
    public DepartmentDaoTest() {
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
     * Test of delete method, of class DepartmentDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Short id = null;
        DepartmentDao instance = new DepartmentDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class DepartmentDao.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Department Dt = null;
        DepartmentDao instance = new DepartmentDao();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate(Dt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DepartmentDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DepartmentDao instance = new DepartmentDao();
        List<Department> expResult = null;
        List<Department> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class DepartmentDao.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "";
        DepartmentDao instance = new DepartmentDao();
        List<Department> expResult = null;
        List<Department> result = instance.search(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class DepartmentDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Short id = null;
        DepartmentDao instance = new DepartmentDao();
        Department expResult = null;
        Department result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
