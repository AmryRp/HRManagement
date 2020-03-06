/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDao;
import dao.RegionDao;
import java.util.ArrayList;
import java.util.List;
import model.Country;
import model.Region;
import java.math.BigDecimal;
import view.CountryView;
import dao.IRegionDao;
import dao.ICountryDao;

/**
 *
 * @author amry4
 */
public class CountryController {

    CountryView CountryView;
    List< Country> ListCountry;
    ICountryDao IntrfcCM;

    List< Region> ListRegion;
    IRegionDao IntrfcRM;

    Country EC = new Country();
    Region ER = new Region();

    public CountryController() {
    }

    public CountryController(CountryView frame) {
        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
        IntrfcRM = new RegionDao();
        ListRegion = IntrfcRM.getAll(ER);
    }

    public String Save(String id, String name, String regionId) {
        IntrfcCM = new CountryDao();
        IntrfcRM = new RegionDao();

        return (IntrfcCM.insertOrUpdate(new Country(id, name, new Region(new BigDecimal(regionId))))) ? "sukses" : "failed";

    }

    public String delete(String id) {
        IntrfcCM = new CountryDao();
        return (IntrfcCM.delete(new Country(id))) ? "sukses" : "failed";

    }

    public List<Country> search(String Name) {
        IntrfcCM = new CountryDao();
        return IntrfcCM.search(Name);
    }

}
