/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DepartmentDao implements IDepartmentDao {
    private SessionFactory sf;

    public DepartmentDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean delete(Department c) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.delete(c);
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
                session.close();
            }
        }
        return departments;
    }

    @Override
    public List<Department> search(String c) {
        Session session = sf.openSession();
        List<Department> Dtsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Department where departmentName =:keyword";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + c + "%");
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
    public Department getById(int R) {
        Session session = sf.openSession();
        Department DT = new Department();
        Department rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Department) session.get(Department.class, R);
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
