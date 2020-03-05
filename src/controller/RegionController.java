/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegionDao;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Region;
import dao.*;
import java.math.BigDecimal;
import view.RegionView;

/**
 *
 * @author amry4
 */
public class RegionController {

    public RegionController() {
    }

    RegionView regView;
    List<Region> ListRegion;
    Region Er = new Region();
    IRegionDao IntrfcRM;
    List<Region> ListReg;

    public RegionController(RegionView frame) {
        IntrfcRM = new RegionDao();
        ListReg = IntrfcRM.getAll(Er);
    }

    public String Save(String id, String name) {
        IntrfcRM = new RegionDao();
        return (IntrfcRM.insertOrUpdate(new Region(new BigDecimal(id), name))) ? "sukses" : "failed";

    }

    public String delete(String id) {
        IntrfcRM = new RegionDao();
        return (IntrfcRM.delete(new Region(new BigDecimal(id)))) ? "sukses" : "failed";

    }

    public List<Region> search(String Name) {
        IntrfcRM = new RegionDao();
        return IntrfcRM.search(Name);
    }

    public boolean confirm(BigDecimal id) {
        IntrfcRM = new RegionDao();
       return(IntrfcRM.getById(id) != null); 
    }
}
