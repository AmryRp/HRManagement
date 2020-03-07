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
 * @author bootcamp34
 * @param <T> is data type for entity model
 * @param <Id> is data type for id 
 * @param <Name> is data type for name(keyword)
 */
public interface IGeneric<T, Id extends Serializable,Name extends Serializable>{
    
    public boolean insertOrUpdate(T Entity);

    public boolean delete(Id id);

    public List<T> getAll();

    public List<T> search(Name name);

    public T getById(Id Id);
}
