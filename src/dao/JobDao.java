/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Job;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class JobDao implements IGeneric<Job, String, String> {

    private SessionFactory sf;

    public JobDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }
/**
 * this function for deleting table data with id
 * by : bootcamp34
 * @param id is a data type String that referencing Number on table
 * @return to boolean true or false
 */
    @Override
    public boolean delete(String id) {
        Session ss = sf.openSession();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            Job jb = (Job) ss.get(Job.class, id);
            ss.delete(jb);
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
     * this function(insertOrUpdate) used for save and update .
     * by : bootcamp34
     *
     * @param jb is a Job object from model.Job
     * @return boolean true or false;
     */
    @Override
    public boolean insertOrUpdate(Job jb) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(jb);
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
 * this function is for get all table data using query(hql) from Job, 
 * that mean get data from table Job. 
 * by : bootcamp34
 * 
 * @return to list<object> , object = Job from model.Job; 
 */
    @Override
    public List<Job> getAll() {
        Session session = sf.openSession();
        List<Job> Region = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Region = session.createQuery("From Job").list();
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
        return Region;
    }
/**
 * this function for searching table data that using keyword : name 
 * by : bootcamp34
 * @param Name is a String data type for search keyword
 * @return to list<Job> 
 */
    @Override
    public List<Job> search(String Name) {
        Session session = sf.openSession();
        List<Job> Rsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Job where jobTittle =:keyword";
            Query q = session.createQuery(hql);
            q.setParameter("keyword", Name);
            Rsearch = q.list();
            trc.commit();
        } catch (Exception e) {
            if (trc != null) {
                trc.rollback();
            }
            e.printStackTrace();
        }

        return Rsearch;
    }
/**
 * this function is used for get data row from table using 
 * parameter id or unique identity by : bootcamp34
 * @param id is a data type for String that referencing Char from 
 * model.Job table
 * @return to Job entity model
 */
    @Override
    public Job getById(String id) {
        Session session = sf.openSession();

        Job rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Job) session.get(Job.class, id);
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
