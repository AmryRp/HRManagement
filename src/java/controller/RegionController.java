/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Region;
import dao.*;
import java.math.BigDecimal;


/**
 * class regioncontroller using for parsing input from view
 *
 * @author amry4
 */
public class RegionController {

    /**
     * empty parameter constructor for regionController
     */
    public RegionController() {
    }
   
    List<Region> ListRegion;
    Region Er = new Region();
    IDao<Region> IntrfcRM;
    List<Region> ListReg;
  

    /**
     * Constructor for regionController that has frame parameter from RegionView
     *
     * @param frame is view.RegionView
     */
   

    /**
     * This function is used for save or input data on table region
     *
     * @param id is String data type for insert data into regionId
     * @param name is String data type for insert data into regionName
     * @return to model.region using insertOrUpdate from IRegionDao List Region
     */
    public String Save(String id, String name) {
         IntrfcRM = new GeneralDao();
        return (IntrfcRM.manageData(new Region(new BigDecimal(id), name),"","",new BigDecimal(0),true,false) != null) ? "sukses" : "failed";

    }

    /**
     * this function is used for delete data on table region
     *
     * @param id is String data type for delete data by regionId
     * @return to model.region using delete function from IRegionDao
     * List Region
     */
    public String delete(String id) {
        IntrfcRM = new GeneralDao();
        return (IntrfcRM.manageData(new Region(),"","",new BigDecimal(id),true,true) != null) ? "sukses" : "failed";

    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is BigDecimal Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcRM = new GeneralDao();
        return (IntrfcRM.manageData(new Region(),"regionId",id,"",false,false) != null);
    }
}
