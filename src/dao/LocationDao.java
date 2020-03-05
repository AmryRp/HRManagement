/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class LocationDao implements ILocationDao {

    private SessionFactory sf;

    public LocationDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean delete(Location l) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.delete(l);
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
    public boolean insertOrUpdate(Location l) {
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
    public List<Location> getAll() {
        Session session = sf.openSession();
        List<Location> Region = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Region = session.createQuery("From Location").list();
            trc.commit();
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
        return Region;
    }

    @Override
    public List<Location> Search(Location l) {
        Session session = sf.openSession();
        List<Location> Rsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Location where city =:keyword";
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
    public Location getById(int id) {
        Session session = sf.openSession();

        Location rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Location) session.get(Location.class, id);
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
