/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.*;

/**
 *
 * @author amry4
 */
public class CountryDao implements IGeneric<Country, String, String> {

//    //SessionFactory sf;
//    private Session session;
//    private Transaction trs;
    private SessionFactory sf;

    public CountryDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    /**
     * this function used to delete object from model.country using id and name.
     *
     * @param id is a country object from model.country
     * @return boolean true or false
     */
    @Override
    public boolean delete(String id) {
        Session ss = sf.openSession();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            Country C = (Country) ss.get(Country.class, id);
            ss.delete(C);
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
     * function insertOrUpdate used for save and update , by : bootcamp34
     *
     * @param c is a country object from model.country
     * @return boolean true or false;
     */
    @Override
    public boolean insertOrUpdate(Country c) {
        Session session = sf.openSession();
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            session.saveOrUpdate(c);
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
     * this function used for getting all object from model.
     *
     * @return to list<Model.Country>
     */
    @Override
    public List<Country> getAll() {
        Session session = sf.openSession();
        List<Country> country = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            country = session.createQuery("From Country").list();
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
        return country;
    }

    /**
     * This function used for search by name from object model.country.
     *
     * @param c is a string datatype that used for store name input
     * @return to List<model.country>
     */
    @Override
    public List<Country> search(String c) {
        Session session = sf.openSession();
        List<Country> Rsearch = null;
        Transaction trc = null;
        try {

            trc = session.beginTransaction();
            String hql = "FROM Country where countryName =:keyword";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + c + "%");
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
     * this function used for get object by id using object country
     *
     * @param C is an object Country
     * @return to string datatype for getting regionName
     */
    @Override
    public Country getById(String C) {
        Session session = sf.openSession();

        Country rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Country) session.get(Country.class, C);
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
        if (rg == null) {
            return rg;
        } else {
            return rg;
        }
    }

}
