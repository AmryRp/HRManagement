/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * class RegionGeneric used for store generic datatype 
 * @author amry4
 * @param <T> to definition a type that used for
 */
public class RegionGeneric<T> {

    private T t;

    /**
     * Empty parameter constructor for RegionGeneric
     */
    public RegionGeneric() {
    }
    /**
     * function for get value from T on RegionGeneric
     *
     * @return t is T data type
     */
    public T getT() {
        return t;
    }

    /**
     *function to set value to T on RegionGeneric
     * @param t is T data type
     */
    public void setT(T t) {
        this.t = t;
    }
}
