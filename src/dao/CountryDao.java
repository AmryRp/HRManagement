/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import model.Country;
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
public class CountryDao implements ICountryDao {

//    //SessionFactory sf;
//    private Session session;
//    private Transaction trs;
    private SessionFactory sf;

    public CountryDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean delete(Country c) {
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

    @Override
    public String getById(Country R) {
        Session session = sf.openSession();

        Country rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Country) session.get(Country.class, R.getCountryId());
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
            return "";
        } else {
            return rg.getCountryName();
        }
    }

}
