/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class DepartmentDao implements IGeneric<Department> {
    private SessionFactory sf;

    public DepartmentDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }
/**
 * this function for deleting table data with id
 * by : bootcamp34
 * @param id is a data type short that referencing decimal on table
 * @return to boolean true or false
 */
    @Override
    public boolean delete(Serializable id) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Department dpt = (Department) session.get(Department.class, id);
            session.delete(dpt);
            trc.commit();
            return trc != null;
        } catch (Exception e) {
            e.printStackTrace();
            return trc == null;
        } finally {
            session.close();
        }
    }

    /**
     * function insertOrUpdate used for save and update , by : bootcamp34
     *
     * @param Dt is a Department object from model.department
     * @return boolean true or false;
     */
    @Override
    public boolean insertOrUpdate(Department Dt) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(Dt);
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
 * this function is for get all table data using query(hql) from Department, 
 * that mean get data from table Department by : bootcamp34
 * @return to list<object> , object = Department from model.Department; 
 */
    @Override
    public List<Department> getAll() {
        Session session = sf.openSession();
        List<Department> departments = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            departments = session.createQuery("FROM Department").list();
            trc.commit();
        } catch (Exception e) {
            if (trc != null) {
                trc.rollback();
            }
            e.printStackTrace();
        } finally {
            if (trc == null) {
                //System.out.println("closed");
               // session.close();
            }
        }
        return departments;
    }
/**
 * this function for searching table data that using keyword : name 
 * by : bootcamp34
 * @param name is a String data type for search keyword
 * @return 
 */
    @Override
    public List<Department> search(String name) {
        Session session = sf.openSession();
        List<Department> Dtsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Department where departmentName =:keyword";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + name + "%");
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
 * @param id is a data type for short that referencing decimal from 
 * model.Department table
 * @return to Department entity model
 */
    @Override
    public Department getById(Serializable id) {
        Session session = sf.openSession();
        Department DT = new Department();
        Department rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Department) session.get(Department.class, id);
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
