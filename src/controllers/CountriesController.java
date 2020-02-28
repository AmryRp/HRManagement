/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCountriesManagement;
import dao.DaoRegionsManagement;
import dao.InterfaceCountriesManagement;
import dao.InterfaceRegionsManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityCountries;
import models.EntityRegion;
import views.CountriesView;

/**
 *
 * @author amry4
 */
public class CountriesController {

    CountriesView CountryView;
    InterfaceCountriesManagement intrcCM;
    List<EntityCountries> ListCountry;
    List<EntityRegion> ListRegion;
    InterfaceRegionsManagement IntrfcRM;
    EntityCountries EL = new EntityCountries();

    public CountriesController() {
    }

    public CountriesController(CountriesView frame) {
        this.CountryView = frame;
        intrcCM = new DaoCountriesManagement();
        ListCountry = intrcCM.getALL();
        IntrfcRM = new DaoRegionsManagement();
        ListRegion = IntrfcRM.getALL();
    }

    public void refresh() {
        CountryView.getjTxtCountryId().setText("");
        CountryView.getjTxtCountryName().setText("");

    }

    public void isiTabel(JTable tabel) {
        ListCountry = intrcCM.getALL();
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();
        Object[] row;
        row = new Object[ListCountry.size()];
        while (tR.getRowCount() < ListCountry.size()) {
            row[0] = ListCountry.get(tR.getRowCount()).getId();
            row[1] = ListCountry.get(tR.getRowCount()).getCountryName();
            row[2] = ListCountry.get(tR.getRowCount()).getRegionId();
            tR.addRow(row);

        }
        CountryView.getjTblCountries().setModel(tR);
    }

    public void isiField(int row) {
        CountryView.getjTxtCountryId().setText(ListCountry.get(row).getId().toString());
        CountryView.getjTxtCountryName().setText(ListCountry.get(row).getCountryName());
        CountryView.getjCmbRegionId().setSelectedItem("Pilih Region");

    }

    public void insert() {
        if (!CountryView.getjTxtCountryId().getText().trim().isEmpty()
                && !CountryView.getjTxtCountryName().getText().trim().isEmpty()) {

            EL.setId(CountryView.getjTxtCountryId().getText());
            EL.setCountryName(CountryView.getjTxtCountryName().getText());
            EL.setRegionId(getValueBox());
            JOptionPane.showMessageDialog(null, "Data telah di input");
        } else {
            JOptionPane.showMessageDialog(null, "isi terlebih dahulu");
        }

        intrcCM.insert(EL);

    }

    public void Update() {
        if (!CountryView.getjTxtCountryId().getText().trim().isEmpty()
                && !CountryView.getjTxtCountryName().getText().trim().isEmpty()) {

            EL.setCountryName(CountryView.getjTxtCountryName().getText());
            EL.setId(CountryView.getjTxtCountryId().getText().trim());
            EL.setRegionId(getValueBox());
            JOptionPane.showMessageDialog(null, "Data telah di Update");
        } else {
            JOptionPane.showMessageDialog(null, "isi terlebih dahulu");
        }

        intrcCM.update(EL);

    }

    public void delete() {
        if (!CountryView.getjTxtCountryId().getText().trim().isEmpty()) {
            String id = CountryView.getjTxtCountryId().getText();
            intrcCM.delete(id);
            JOptionPane.showMessageDialog(null, "Data sudah dihapus");
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di hapus");
        }

    }

    public void Fillcbox(JComboBox Jbox) {
        ListRegion = IntrfcRM.getALL();
        String[] regionName = new String[ListRegion.size()];
        int[] regionId = new int[ListRegion.size()];
        int i = 0;
        while (i < ListRegion.size()) {
            regionName[i] = ListRegion.get(i).getName();
            regionId[i] = ListRegion.get(i).getId();
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(regionName);
        CountryView.getjCmbRegionId().setModel(dtm);

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

    public int getValueBox() {
        String val = CountryView.getjCmbRegionId().getSelectedItem().toString();
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFK();
        String[] region_name = new String[result.size()];
        int[] region_id = new int[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }

        return idx;
    }

    public String getById(String id) {
        
    return (intrcCM.getById(id));
    }

    
}
