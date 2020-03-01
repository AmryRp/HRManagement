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
import java.util.ArrayList;

/**
 *
 * @author amry4
 */
public class LocationController {

    public LocationController() {
    }

    LocationView LocView;
    InterfaceLocationManagement IntrfcLM;
    List<EntityLocation> ListLoc;
    EntityLocation EL = new EntityLocation();
    List<EntityCountry> ListCountry;
    InterfaceCountryManagement IntrfcCM;

    public LocationController(LocationView frame) {
        this.LocView = frame;
        IntrfcLM = new DaoLocationManagement();
        ListLoc = IntrfcLM.getALL();

        IntrfcCM = new DaoCountryManagement();
        ListCountry = IntrfcCM.getALL();
    }

    public String Save(String Id, String Address, String ZipCode, String City, String Province, String idCountry, boolean isSave) {

        return (IntrfcLM.insertOrUpdate(new EntityLocation(Integer.parseInt(Id), Address, ZipCode, City, Province, getValueBox(idCountry)),
                isSave)) ? "sukses" : "failed";

    }

    public String delete(String Id) {
        return (IntrfcLM.delete(Integer.parseInt(Id))) ? "sukses" : "failed";
    }

    private ArrayList getValueFK() {
        ListCountry = IntrfcCM.getALL();
        ArrayList FK = new ArrayList<String>();
        String[] countryname = new String[ListCountry.size()];
        int[] countryId = new int[ListCountry.size()];
        int i = 0;
        while (i < ListCountry.size()) {
            countryname[i] = ListCountry.get(i).getCountryName();
            countryId[i] = ListCountry.get(i).getRegionId();
            i++;
        }
        FK.add(countryname);
        FK.add(countryId);
        return FK;
    }

    public String getValueBox(String Data) {
        String val = Data;
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFK();
        String[] region_name = new String[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }

        return val;
    }
}
