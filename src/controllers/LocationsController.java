/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCountriesManagement;
import dao.DaoLocationsManagement;
import dao.InterfaceCountriesManagement;
import dao.InterfaceLocationsManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityCountries;
import models.EntityLocation;
import views.LocationsView;

/**
 *
 * @author amry4
 */
public class LocationsController {

    LocationsView LocView;
    InterfaceLocationsManagement IntrfcLM;
    List<EntityLocation> ListLoc;
    List<EntityCountries> ListCountry;
    InterfaceCountriesManagement IntrfcCM;
    EntityLocation EL = new EntityLocation();

    public LocationsController(LocationsView frame) {
        this.LocView = frame;
        IntrfcLM = new DaoLocationsManagement();
        IntrfcCM = new DaoCountriesManagement();
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
