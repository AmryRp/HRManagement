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
import dao.ILocationDao;
import dao.ICountryDao;

/**
 *
 * @author amry4
 */
public class LocationController {

    public LocationController() {
    }

    LocationView LocView;
    ILocationDao IntrfcLM;
    List<Location> ListLoc;
    Location EL = new Location();
    List<Country> ListCountry;
    ICountryDao IntrfcCM;
    Country EC = new Country();

    public LocationController(LocationView frame) {
        this.LocView = frame;
        IntrfcLM = new LocationDao();
        ListLoc = IntrfcLM.getAll();

        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
    }

    public String Save(String Id, String Address, String ZipCode, String City, String Province, String idCountry) {
        IntrfcLM = new LocationDao();
        return (IntrfcLM.insertOrUpdate(new Location(new Short(Id), Address, ZipCode, City, Province, new Country(idCountry)))) ? "sukses" : "failed";

    }

    public String delete(String Id) {
         IntrfcLM = new LocationDao();
        return (IntrfcLM.delete(new Location(new Short(Id)))) ? "sukses" : "failed";
    }

}
