/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCountryManagement;
import dao.DaoRegionManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityCountry;
import models.EntityRegion;
import views.*;
import dao.InterfaceCountryManagement;
import dao.InterfaceRegionManagement;

/**
 *
 * @author amry4
 */
public class CountryController {

    CountryInternalView CountryView;
    List<EntityCountry> ListCountry;
    InterfaceCountryManagement IntrfcCM;

    List<EntityRegion> ListRegion;
    InterfaceRegionManagement IntrfcRM;
    
    EntityCountry EC = new EntityCountry();

    public CountryController() {
    }

    public CountryController(CountryInternalView frame) {
        this.CountryView = frame;
        IntrfcCM = new DaoCountryManagement();
        ListCountry = IntrfcCM.getALL();
        IntrfcRM = new DaoRegionManagement();
        ListRegion = IntrfcRM.getALL();
    }

    public String Save(String id, String name, String Region, boolean isSave) {

        return (IntrfcCM.insertOrUpdate(new EntityCountry(id, name, getValueBox(Region)),
                isSave)) ? "sukses" : "failed";

    }

    private ArrayList getValueFK() {
        ListRegion = IntrfcRM.getALL();
        String[] regionName = new String[ListRegion.size()];
        int[] regionId = new int[ListRegion.size()];
        int i = 0;
        while (i < ListRegion.size()) {
            regionName[i] = ListRegion.get(i).getName();
            regionId[i] = ListRegion.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(regionName);
        FK.add(regionId);
        return FK;
    }

    public int getValueBox(String Data) {
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
        return idx;
    }
//
//    public void Update() {
//        if (!CountryView.getjTxtCountryId().getText().trim().isEmpty()
//                && !CountryView.getjTxtCountryName().getText().trim().isEmpty()) {
//
//            EL.setCountryName(CountryView.getjTxtCountryName().getText());
//            EL.setId(CountryView.getjTxtCountryId().getText().trim());
//            EL.setRegionId(getValueBox());
//            JOptionPane.showMessageDialog(null, "Data telah di Update");
//        } else {
//            JOptionPane.showMessageDialog(null, "isi terlebih dahulu");
//        }
//
//
//    }
//
//    public void delete() {
//        if (!CountryView.getjTxtCountryId().getText().trim().isEmpty()) {
//            String id = CountryView.getjTxtCountryId().getText();
//            IntrfcCM.delete(id);
//            JOptionPane.showMessageDialog(null, "Data sudah dihapus");
//        } else {
//            JOptionPane.showMessageDialog(null, "Pilih data yang akan di hapus");
//        }
//
//    }

    public String delete(String id) {

        return (IntrfcCM.delete(id)) ? "sukses" : "failed";

    }

    public String getById(String id) {

        return (new DaoCountryManagement().getById(id));
    }

}
