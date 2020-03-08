/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class RegionDao implements IGeneric<Region, BigDecimal, String> {

//    //SessionFactory sf;
//    private Session session;
//    private Transaction trs;
    private SessionFactory sf;

    public RegionDao() {
        this.sf = HibernateUtil.getSessionFactory();
    }

//    @Override
//    public boolean delete(int r) {
//        Session session = sf.openSession();
//        Transaction trc = null;
//        try {
//            trc = session.beginTransaction();
//            session.delete(r);
//            trc.commit();
//            return trc != null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return trc == null;
//        } finally {
//            session.close();
//        }
//    }
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

//    @Override
//    public List<Region> getAll(Region R) {
//        Session session = sf.openSession();
//        List<Region> Region = null;
//        Transaction trc = null;
//        try {
//            trc = session.beginTransaction();
//            Region = session.createQuery("From Region").list();
//            trc.commit();
//        } catch (Exception e) {
//            if (trc != null) {
//                trc.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            if (trc == null) {
//                //System.out.println("closed");
//                session.close();
//            }
//        }
//        return Region;
//    }
    @Override
    public List<Region> search(String R) {
        Session session = sf.openSession();
        List<Region> Rsearch = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            String hql = "FROM Region where regionName like :keyword";
            Query q = session.createQuery(hql);
            q.setString("keyword", "%" + R + "%");
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
     * this function used for get Id values from table
     *
     * @param Id is bigDecimal datatype
     * @return
     */
      @Override
    public Region getById(BigDecimal Id) {
        Session session = sf.openSession();
        Region rg = null;
        Transaction trc = null;
        try {
            trc = session.beginTransaction();
            rg = (Region) session.get(Region.class, Id);
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

    @Override
    public boolean delete(BigDecimal id) {
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
