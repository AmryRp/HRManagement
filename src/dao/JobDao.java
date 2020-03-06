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
public class JobDao implements IJobDao{
    private SessionFactory sf;

    public JobDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }


   @Override
    public boolean delete(Job j) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.delete(j);
            trc.commit();
            return trc != null;
        } catch (Exception e) {
            e.printStackTrace();
            return trc == null;
        } finally {
            session.close();
        }
    }

   
    @Override
    public boolean insertOrUpdate(Job l) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(l);
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
        return Region;}
    @Override
    public List<Job> search(Job l) {
        Session session = sf.openSession();
        List<Job> Rsearch = null;
        Transaction trc = null;
        try {
            
            trc = session.beginTransaction();
            String hql = "FROM Job where jobTittle =:keyword";
            Query q = session.createQuery(hql);
            q.setParameter("keyword", l);
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
        }}
}
