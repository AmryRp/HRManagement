/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDao;
import dao.LocationDao;
import java.util.List;
import model.Country;
import model.Location;
import view.LocationView;
import dao.IGeneric;

/**
 *
 * @author amry4
 */
public class LocationController {

    public LocationController() {
    }

    LocationView LocView;
    IGeneric<Location, Short, String> IntrfcLM;
    List<Location> ListLoc;
    Location EL = new Location();
    List<Country> ListCountry;
    IGeneric<Country, String, String> IntrfcCM;
    Country EC = new Country();

    public LocationController(LocationView frame) {
        this.LocView = frame;
        IntrfcLM = new LocationDao();
        ListLoc = IntrfcLM.getAll();

        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
    }
/**
 * This function is used for save,update or input data on table Location
 * @param Id is String Datatype for locationId
 * @param Address is String Datatype for streerAddress
 * @param ZipCode is String Datatype for postalCode
 * @param City is String Datatype for city
 * @param Province is String Datatype for stateProvince
 * @param idCountry is String Datatype for countryId
 * @return to String to insertOrUpdate with object Location
 */
    public String Save(String Id, String Address, String ZipCode, String City, String Province, String idCountry) {
        IntrfcLM = new LocationDao();
        return (IntrfcLM.insertOrUpdate(new Location(new Short(Id), Address, ZipCode, City, Province, new Country(idCountry)))) ? "sukses" : "failed";

    }
/**
 * delete function is used for deleting data from table 
 * @param Id is string datatype converted to short for deleting data
 * @return to String to delete from object location
 */
    public String delete(String Id) {
        IntrfcLM = new LocationDao();
        return (IntrfcLM.delete(new Short(Id))) ? "sukses" : "failed";
    }

    /**
     * this function used for search a data from table
     *
     * @param Name is String Datatype
     * @return to List Location
     */
    public List<Location> search(String Name) {
        IntrfcLM = new LocationDao();
        return IntrfcLM.search(Name);
    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(Short id) {
        IntrfcLM = new LocationDao();
        return (IntrfcLM.getById(id) != null);
    }
}
