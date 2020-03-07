/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegionDao;
import java.util.List;
import model.Region;
import dao.*;
import java.math.BigDecimal;
import model.RegionGeneric;
import view.RegionView;

/**
 *class regioncontroller using for parsing input from view
 * @author amry4
 */
public class RegionController {
    /** 
     * empty parameter constructor for regionController 
     */
    public RegionController() {
    }
    RegionGeneric<Object> regionGeneric;
    RegionView regView;
    List<Region> ListRegion;
    Region Er = new Region();
    IGeneric<Region, BigDecimal, String> IntrfcRM;
    List<Region> ListReg;
    RegionGeneric<BigDecimal> rg = new RegionGeneric<>();
    RegionGeneric<String> rg1 = new RegionGeneric<>();
/**
 * Constructor for regionController that has frame parameter from RegionView
 * @param frame is view.RegionView 
 */
    public RegionController(RegionView frame) {
        IntrfcRM = new RegionDao();
        ListReg = IntrfcRM.getAll();

    }

    /**
     * This function is used for save or input data on table region
     *
     * @param id is String data type for insert data into regionId
     * @param name is String data type for insert data into regionName
     * @return to model.region using insertOrUpdate from IRegionDao List<Region>
     */
    public String Save(String id, String name) {
        IntrfcRM = new RegionDao();
        rg.setT(new BigDecimal(id));
        rg1.setT(name);
        return (IntrfcRM.insertOrUpdate(new Region(rg.getT(), rg1.getT()))) ? "sukses" : "failed";

    }
    /**
     * this function is used for delete data on table region
     * 
     * @param id is String data type for delete data by regionId
     * @return to model.region using delete function from IRegionDao List<Region>
     */
    public String delete(String id) {
        IntrfcRM = new RegionDao();
        return (IntrfcRM.delete(new BigDecimal(id))) ? "sukses" : "failed";

    }

    public List<Region> search(String Name) {
        IntrfcRM = new RegionDao();
        return IntrfcRM.search(Name);
    }

    public boolean confirm(BigDecimal id) {
        IntrfcRM = new RegionDao();
        return (IntrfcRM.getById(id) != null);
    }
}
