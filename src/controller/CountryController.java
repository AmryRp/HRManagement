/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDao;
import dao.RegionDao;
import java.util.List;
import model.Country;
import model.Region;
import java.math.BigDecimal;
import view.CountryView;
import dao.IGeneric;

/**
 *
 * @author amry4
 */
public class CountryController {

    CountryView CountryView;
    List< Country> ListCountry;
    IGeneric<Country> IntrfcCM;
    List< Region> ListRegion;
    IGeneric<Region> IntrfcRM;

    Country EC = new Country();
    Region ER = new Region();

    public CountryController() {
    }

    public CountryController(CountryView frame) {
        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
        IntrfcRM = new RegionDao();
        ListRegion = IntrfcRM.getAll();
    }

    /**
     * This function is used for save,update or input data on table Country
     * @param id is String Datatype for countryId
     * @param name is String Datatype for countryName
     * @param regionId is String Datatype for regionId
     * @return to String to insertOrUpdate with object Country
     */
    public String Save(String id, String name, String regionId) {
        IntrfcCM = new CountryDao();
        IntrfcRM = new RegionDao();

        return (IntrfcCM.insertOrUpdate(new Country(id, name, new Region(new BigDecimal(regionId))))) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype
     * @return to String to delete from object Country
     */
    public String delete(String id) {
        IntrfcCM = new CountryDao();
        return (IntrfcCM.delete(id)) ? "sukses" : "failed";

    }

    /**
     * this function used for search a data from table
     *
     * @param Name is String Datatype
     * @return to List Country
     */
    public List<Country> search(String Name) {
        IntrfcCM = new CountryDao();
        return IntrfcCM.search(Name);
    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is String Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcCM = new CountryDao();
        return (IntrfcCM.getById(id) != null);
    }
}
