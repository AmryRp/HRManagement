/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoRegionManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityRegion;
import views.RegionView;
import dao.InterfaceRegionManagement;
import views.RegInternalForm;

/**
 *
 * @author amry4
 */
public class RegionController {

    public RegionController() {
    }

    RegionView frame;
    RegInternalForm frame2;
    InterfaceRegionManagement IntrfcRM;
    List<EntityRegion> ListRegion;
    EntityRegion Er = new EntityRegion();

    public RegionController(RegionView frame) {
        this.frame = frame;
        IntrfcRM = new DaoRegionManagement();
        ListRegion = IntrfcRM.getALL();
    }
    public RegionController(RegInternalForm frame) {
        this.frame2 = frame;
        IntrfcRM = new DaoRegionManagement();
        ListRegion = IntrfcRM.getALL();
    }
    public void clear(JTable tabel) {
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();
        while (tR.getRowCount() > 0) {
            tR.removeRow(0);
        }
    }

    public String Save(String id, String name, boolean isSave) {

        return (IntrfcRM.insertOrUpdate(new EntityRegion(Integer.parseInt(id), name), isSave)) ? "sukses" : "failed";

    }

    public String delete(String id) {

        return (IntrfcRM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

}
