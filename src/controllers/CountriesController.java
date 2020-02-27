/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoCountriesManagement;
import dao.InterfaceCountriesManagement;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityCountries;
import views.CountriesView;

/**
 *
 * @author amry4
 */
public class CountriesController {

    CountriesView frame;
    InterfaceCountriesManagement intrcCM;
    List<EntityCountries> lb;
    EntityCountries EL = new EntityCountries();

    public CountriesController(CountriesView frame) {
        this.frame = frame;
        intrcCM = new DaoCountriesManagement();
        lb = intrcCM.getALL();

    }

    public void refresh() {
        frame.getjTxtCountryId().setText("");
        frame.getjTxtCountryName().setText("");

    }
    public void isiTabel(JTable tabel) {
        lb = intrcCM.getALL();
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();

        Object[] row;
        row = new Object[lb.size()];
        while (tR.getRowCount() < lb.size()) {
            row[0] = lb.get(tR.getRowCount()).getId();
            row[1] = lb.get(tR.getRowCount()).getCountryName();
             row[2] = lb.get(tR.getRowCount()).getRegionId();
            tR.addRow(row);

        }
        frame.getjTblCountries().setModel(tR);
    }
    public void insert()
    {
    
    }
}
