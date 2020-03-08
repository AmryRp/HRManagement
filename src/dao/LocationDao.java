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
public class LocationDao implements IGeneric<Location, Short, String> {

    private SessionFactory sf;

    public LocationDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }
/**
 * this function for deleting table data with id
 * by : bootcamp34
 * @param id is a data type short that referencing decimal on table
 * @return to boolean true or false
 */
    @Override
    public boolean delete(Short id) {
        Session ss = sf.openSession();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            Location Lc = (Location) ss.get(Location.class, id);
            ss.delete(Lc);
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
 * this function for saving data on table from user input 
 * used for save and update
 * by : bootcamp34
 * @param loc is a data type from model.location  
 * @return to boolean true or false 
 */
    @Override
    public boolean insertOrUpdate(Location loc) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(loc);
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
 * this function is for get all table data using query(hql) from location, 
 * that mean get data from table location by : bootcamp34
 * @return to list<object> , object = location from model.location; 
 */
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
/**
 * this function for searching table data that using keyword : name 
 * by : bootcamp34
 * @param name
 * @return 
 */
    @Override
    public List<Location> search(String name) {
        Session session = sf.openSession();
        List<Location> Rsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Location where city =:keyword";
            Query q = session.createQuery(hql);
            q.setParameter("keyword", name);
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
 * @param id is a data type for short that referencing decimal from 
 * model.location table
 * @return to location entity model
 */
    @Override
    public Location getById(Short id) {
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
