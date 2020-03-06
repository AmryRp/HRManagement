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
public class EmployeeDao implements IEmployeeDao {

    private SessionFactory sf;

    public EmployeeDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Employee emp = (Employee) session.get(Employee.class, id);
            session.delete(emp);
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
     * @param Emp is a Department object from model.department
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

    @Override
    public List<Employee> search(Employee key) {
        Session session = sf.openSession();
        List<Employee> Dtsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Employee where lastName =:keyword OR firstName =:keyword ";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + key + "%");
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

    @Override
    public Employee getById(int Id) {
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

    @Override
    public List<Employee> getManager() {
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
}
