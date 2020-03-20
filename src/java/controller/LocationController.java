/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import java.util.List;
import model.Country;
import model.Location;

import dao.IDao;

/**
 *
 * @author amry4
 */
public class LocationController {

  


    IDao<Location> IntrfcLM;
    List<Location> ListLoc;
    Location EL = new Location();
    List<Country> ListCountry;
    IDao<Country> IntrfcCM;
    Country EC = new Country();

    public LocationController() {
       
        IntrfcLM = new GeneralDao();
        IntrfcCM = new GeneralDao();
       
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
        IntrfcLM = new GeneralDao();
        return (IntrfcLM.manageData(new Location(new Short(Id), Address, ZipCode, City, Province, new Country(idCountry)),"","",new Short("0"),true,false) != null) ? "sukses" : "failed";

    }
/**
 * delete function is used for deleting data from table 
 * @param id is string datatype converted to short for deleting data
 * @return to String to delete from object location
 */
    public String delete(String id) {
        IntrfcLM = new GeneralDao();
        return (IntrfcLM.manageData(new Location(),"","",new Short(id),true,true) != null) ? "sukses" : "failed";
    }

   

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcLM = new GeneralDao();
        return (IntrfcLM.manageData(new Location(new Short(id)),"locationId",id,"",false,false) != null);
    }
}
