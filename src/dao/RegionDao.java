/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import model.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.*;
import static tool.HibernateUtil.getSessionFactory;

/**
 *
 * @author amry4
 */
public class RegionDao implements IGeneric<Region> {

//    //SessionFactory sf;
//    private Session session;
//    private Transaction trs;
    private SessionFactory sf;

    public RegionDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }
/**
     * function insertOrUpdate used for save and update , by : bootcamp34
     *
     * @param R is a country object from model.Region
     * @return boolean true or false;
     */
    @Override
    public boolean insertOrUpdate(Region R) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(R);
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
     * This function used for search by name from object model.Region. by :
     * bootcamp34
     *
     * @param Name is a string datatype that used for store name input
     * @return to List<model.Region>
     */
    @Override
    public List<Region> search(String Name) {
        Session session = sf.openSession();
        List<Region> Rsearch = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            String hql = "FROM Region where regionName like :keyword";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + Name + "%");
//            q.setParameter("keyword", R);
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
     * this function used for get Id values/object list from table region
     *
     * @param Id is bigDecimal datatype
     * @return to object Region from model.Region
     */
      @Override
    public Region getById(Serializable id) {
        Session session = sf.openSession();
        Region rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Region) session.get(Region.class, id);
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

/**
 * this function is for get all table data using query(hql) from Region, 
 * that mean get data from table Region by : bootcamp34
 * @return to list<object> , object = Region from model.Region; 
 */
    @Override
    public List<Region> getAll() {
       Session session = sf.openSession();
        List<Region> Region = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            Region = session.createQuery("From Region").list();
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
 * this function for deleting table data with id
 * by : bootcamp34
 * @param id is a data type BigDecimal that referencing Decimal on table
 * @return to boolean true or false
 */
    @Override
    public boolean delete(Serializable id) {
       Session ss = sf.openSession();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            Region reg = (Region) ss.get(Region.class, id);
            ss.delete(reg);
            trc.commit();
            return trc != null;
        } catch (Exception e) {
            e.printStackTrace();
            return trc == null;
        } finally {
            ss.close();
        } 
    }

}
