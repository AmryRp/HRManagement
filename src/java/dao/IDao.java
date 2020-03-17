/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;

/**
 * this interface used for generic type to all dao
 *
 * @author bootcamp34
 * @param <T> is data type for entity model
 */
public interface IDao<T> {
/**
     * this function used for save update delete and getting data from table include search, get all
     * data, also get by Id. By: Bootcamp34
     *
     * @param entity is object datatype
     * @param field is String datatype
     * @param keyword is String datatype
     * @param id is Serializable datatype that can be used by any datatype
     * @param isGet is boolean datatype 
     * @param isData is boolean datatype 
     * @return to list
     */
    public List<T> manageData(T entity, String field, String keyword,Serializable id,boolean isGet ,boolean isData);

}