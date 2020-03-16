/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Country;
import model.Region;
import java.math.BigDecimal;

import dao.GeneralDao;
import dao.IDao;

/**
 *
 * @author amry4
 */
public class CountryController {

    List< Country> ListCountry;
    IDao<Country> IntrfcCM;
    List< Region> ListRegion;
    IDao<Region> IntrfcRM;

    Country EC = new Country();
    Region ER = new Region();


    public CountryController() {
        IntrfcCM = new GeneralDao();
        IntrfcRM = new GeneralDao();
    }

    /**
     * This function is used for save,update or input data on table Country
     * @param id is String Datatype for countryId
     * @param name is String Datatype for countryName
     * @param regionId is String Datatype for regionId
     * @return to String to insertOrUpdate with object Country
     */
    public String Save(String id, String name, String regionId) {
        IntrfcCM = new GeneralDao();
        IntrfcRM = new GeneralDao();

        return (IntrfcCM.manageData(new Country(id, name, new Region(new BigDecimal(regionId))),"","","",true,false) != null) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype
     * @return to String to delete from object Country
     */
    public String delete(String id) {
        IntrfcCM = new GeneralDao();
        return (IntrfcCM.manageData(EC,"","",id,true,true) != null) ? "sukses" : "failed";

    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is String Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcCM = new GeneralDao();
        return (IntrfcCM.manageData(EC, "countryId",id,"",false,false) != null);
    }
}
