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

    public void refresh() {
        LocView.getTxtCity().setText("");
        LocView.getTxtLocationId().setText("");
        LocView.getTxtZipCode().setText("");
        LocView.getTxtStreetAddress().setText("");
        LocView.getTxtProvince().setText("");
    }

    public void isiTabel(JTable tabel) {
        ListLoc = IntrfcLM.getALL();
        DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();

        Object[] row;
        row = new Object[ListLoc.size()];
        while (dtm.getRowCount() < ListLoc.size()) {
            row[0] = ListLoc.get(dtm.getRowCount()).getId();
            row[1] = ListLoc.get(dtm.getRowCount()).getAddress();
            row[2] = ListLoc.get(dtm.getRowCount()).getZipCode();
            row[3] = ListLoc.get(dtm.getRowCount()).getCity();
            row[4] = ListLoc.get(dtm.getRowCount()).getProvince();
            row[5] = ListLoc.get(dtm.getRowCount()).getIdCountry();
            dtm.addRow(row);

        }
        LocView.getTblViewLocation().setModel(dtm);

    }

    public void isiField(int row) {
        LocView.getTxtLocationId().setText(ListLoc.get(row).getId().toString());
        LocView.getTxtCity().setText(ListLoc.get(row).getCity());
        LocView.getTxtProvince().setText(ListLoc.get(row).getProvince());
        LocView.getTxtStreetAddress().setText(ListLoc.get(row).getAddress());
        LocView.getTxtZipCode().setText(ListLoc.get(row).getZipCode());
        LocView.getCmbCountryId().setSelectedItem(ListLoc.get(row).getIdCountry());

    }

    public int[] Fillcbox(JComboBox Jbox) {

        ListCountry = IntrfcCM.getALL();
        String[] countryname = new String[ListCountry.size()];
        int[] countryId = new int[ListCountry.size()];
        int i = 0;
        while (i < ListCountry.size()) {
            countryname[i] = ListCountry.get(i).getCountryName();
            countryId[i] = ListCountry.get(i).getRegionId();
            i++;
        }
        DefaultComboBoxModel tR = new DefaultComboBoxModel(countryname);
        LocView.getCmbCountryId().setModel(tR);
        return countryId;
    }

    public String getValueBox() {
        String val = LocView.getCmbCountryId().getSelectedItem().toString();
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

        return val;
    }

    public void insert() {
        if (isEmptyfield()) {
            EL.setId(Integer.parseInt(LocView.getTxtLocationId().getText()));
            EL.setAdrress(LocView.getTxtStreetAddress().getText());
            EL.setCity(LocView.getTxtCity().getText());
            EL.setProvince(LocView.getTxtProvince().getText());
            EL.setZipCode(LocView.getTxtZipCode().getText());
            EL.setIdCountry(getValueBox());
            JOptionPane.showMessageDialog(null, "Data telah di input");
        } else {
            JOptionPane.showMessageDialog(null, "isi terlebih dahulu");
        }

        IntrfcLM.insert(EL);

    }

    public boolean isEmptyfield() {
        if (!LocView.getTxtLocationId().getText().isEmpty()
                && !LocView.getTxtZipCode().getText().isEmpty()
                && !LocView.getTxtCity().getText().isEmpty()
                && !LocView.getTxtProvince().getText().isEmpty()
                && !LocView.getTxtStreetAddress().getText().isEmpty()
                && LocView.getCmbCountryId().getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private ArrayList getValueFK() {
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

}
