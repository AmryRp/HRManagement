/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCountryManagement;
import dao.DaoLocationManagement;
import java.util.List;
import models.EntityCountry;
import models.EntityLocation;
import views.LocationView;
import dao.InterfaceCountryManagement;
import dao.InterfaceLocationManagement;

/**
 *
 * @author amry4
 */
public class LocationController {

    LocationView LocView;
    InterfaceLocationManagement IntrfcLM;
    List<EntityLocation> ListLoc;
    List<EntityCountry> ListCountry;
    InterfaceCountryManagement IntrfcCM;
    EntityLocation EL = new EntityLocation();

    public LocationController(LocationView frame) {
        this.LocView = frame;
        IntrfcLM = new DaoLocationManagement();
        IntrfcCM = new DaoCountryManagement();
        ListLoc = IntrfcLM.getALL();
    }

    public String Save(String Id, String Address, String ZipCode, String City, String Province, String idCountry, boolean isSave) {

        return (IntrfcLM.insertOrUpdate(new EntityLocation(Integer.parseInt(Id), Address, ZipCode, City, Province, idCountry),
                isSave)) ? "sukses" : "failed";

    }

    public String delete(String Id) {
        return (IntrfcLM.delete(Integer.parseInt(Id))) ? "sukses" : "failed";
    }

}
