/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class EmployeeDao implements IGeneric<Employee, Integer, String> {

    private SessionFactory sf;

    public EmployeeDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }
/**
 * this function for deleting table data with id
 * by : bootcamp34
 * @param id is a data type Integer that referencing Number on table
 * @return to boolean true or false
 */
    @Override
    public boolean delete(Integer id) {
        Session ss = sf.openSession();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            Employee emp = (Employee) ss.get(Employee.class, id);
            ss.delete(emp);
            trc.commit();
            return trc != null;
        } catch (Exception e) {
            e.printStackTrace();
            return trc == null;
        } finally {
            ss.close();
        }
    }

    /**
     * this function(insertOrUpdate) used for save and update , by : bootcamp34
     *
     * @param Emp is a Employee object from model.Employee
     * @return boolean true or false;
     */
    @Override
    public boolean insertOrUpdate(Employee Emp) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(Emp);
            trc.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();

        }

    }
/**
 * this function is for get all table data using query(hql) from Employee, 
 * that mean get data from table Employee .
 * by : bootcamp34
 * @return to list<object> , object = Employee from model.location; 
 */
    @Override
    public List<Employee> getAll() {
        Session session = sf.openSession();
        List<Employee> Emp = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Emp = session.createQuery("FROM Employee").list();
            trc.commit();
        } catch (Exception e) {
            if (trc != null) {
                trc.rollback();
            }
            e.printStackTrace();
        } finally {
            if (trc == null) {
                //System.out.println("closed");
                session.close();
            }
        }
        return Emp;
    }
/**
 * this function for searching table data that using keyword : name 
 * by : bootcamp34
 * @param Name
 * @return to list<model.Employee> 
 */
    @Override
    public List<Employee> search(String Name) {
        Session session = sf.openSession();
        List<Employee> Dtsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Employee where lastName =:keyword OR firstName =:keyword ";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + Name + "%");
            Dtsearch = q.list();
            trc.commit();
        } catch (Exception e) {
            if (trc != null) {
                trc.rollback();
            }
            e.printStackTrace();
        }

        return Dtsearch;
    }
/**
 * this function is used for get data row from table using 
 * parameter id or unique identity by : bootcamp34
 * @param Id is a data type for Integer that referencing Number from 
 * model.location table
 * @return to Employee entity model
 */
    @Override
    public Employee getById(Integer Id) {
        Session session = sf.openSession();

        Employee rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Employee) session.get(Employee.class, Id);
            trc.commit();
            System.out.println(rg);
        } catch (Exception e) {
            if (trc != null) {
                trc.rollback();
            }
            e.printStackTrace();
        } finally {
            if (trc == null) {

                session.close();
            }
        }
        if (rg == null) {
            return null;
        } else {
            return rg;
        }
    }

   
}
