/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class GeneralDao<T> implements IDao<T> {

    public GeneralDao() {
        this.sf = HibernateUtil.getSessionFactory();

    }

    private SessionFactory sf;

    /**
     * this function used for save update delete and getting data from table
     * include search, get all data, also get by Id. By: Bootcamp34
     *
     * @param entity is object datatype
     * @param field is String datatype
     * @param keyword is String datatype
     * @param id is Serializable datatype that can be used by any datatype
     * @param isGet is boolean datatype
     * @param isData is boolean datatype
     * @return to list
     */
    @Override
    public List<T> manageData(T entity, String field, String keyword, Serializable id, boolean isGet, boolean isData) {
        Session ss = sf.openSession();
        List<T> model = new ArrayList<>();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            if (isGet) {
                T data = (T) ss.get(entity.getClass(), id);
                if (isData) {
                    ss.delete(data);
                } else {
                    ss.saveOrUpdate(entity);
                }
                trc.commit();
                return model;
            } else {
                String hql = (isData) ? "FROM " + entity.getClass().getSimpleName() + " where Upper(" + field + ") like :keyword order by "+field+" ASC"
                        : "FROM " + entity.getClass().getSimpleName() + " where " + field + " = :keyword";
                Query q = ss.createQuery(hql);
                q = (isData) ? q.setString("keyword", "%" + keyword.toUpperCase() + "%") : q.setString("keyword", keyword);
                model = q.list();
                if (model.isEmpty()) {
                    return null;
                }
                trc.commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        finally {
//            ss.close();
//        }
        return model;
    }
//    /**
//     *
//     * @param entity
//     * @param id
//     * @return
//     */
//    @Override
//    public T getById(T entity, Serializable id) {
//        Session session = sf.openSession();
//        T model = null;
//        Transaction trc = null;
//        try {
//            trc = session.beginTransaction();
//            model = (T) session.get(entity.getClass(), id);
//            trc.commit();
//            System.out.println(model);
//            return model;
//        } catch (Exception e) {
//            if (trc != null) {
//                trc.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            if (trc == null) {
//                session.close();
//            }
//        }
//        return model;
//    }

    /**
     * this function used for save, update or delete on table
     *
     * @param entity is object datatype (model.entity name)
     * @param id is Serializable datatype
     * @param isDelete is boolean datatype
     * @return to boolean true or false
     */
//    @Override
//    public boolean saveOrDelete(T entity, Serializable id, boolean isDelete) {
//        Session ss = sf.openSession();
//        Transaction trc = null;
//        try {
//            trc = ss.beginTransaction();
//            T model = (T) ss.get(entity.getClass(), id);
//            if (isDelete) {
//                ss.delete(model);
//            } else {
//                ss.saveOrUpdate(entity);
//            }
//            trc.commit();
//            return trc != null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return trc == null;
//        } finally {
//            ss.close();
//        }
//    }
}
