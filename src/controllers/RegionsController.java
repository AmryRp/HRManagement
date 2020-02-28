/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoRegionsManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityRegion;
import views.RegionView;
import dao.InterfaceRegionsManagement;

/**
 *
 * @author amry4
 */
public class RegionsController {

    RegionView frame;
    InterfaceRegionsManagement IntrfcRM;
    List<EntityRegion> ListRegion;
    EntityRegion Er = new EntityRegion();

    public RegionsController(RegionView frame) {
        this.frame = frame;
        IntrfcRM = new DaoRegionsManagement();
        ListRegion = IntrfcRM.getALL();
    }

    public void reset() {
        frame.getTxtId().setText("");
        frame.getTxtName().setText("");
        frame.getTxtSearch().setText("");

    }

    public void isiTabel(JTable tabel) {
        ListRegion = IntrfcRM.getALL();
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();

        Object[] row;
        row = new Object[ListRegion.size()];
        while (tR.getRowCount() < ListRegion.size()) {
            row[0] = ListRegion.get(tR.getRowCount()).getId();
            row[1] = ListRegion.get(tR.getRowCount()).getName();
            tR.addRow(row);

        }

        frame.getTblView().setModel(tR);

    }

    public void isiField(int row) {
        frame.getTxtId().setText(ListRegion.get(row).getId().toString());
        frame.getTxtName().setText(ListRegion.get(row).getName());
    }

    public void clear(JTable tabel) {
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();
        while (tR.getRowCount() > 0) {
            tR.removeRow(0);
        }
    }

    public void refresh() {
        reset();
        clear(frame.getTblView());
        isiTabel(frame.getTblView());
    }

    public void insert() {
        if (!frame.getTxtId().getText().trim().isEmpty()
                && !frame.getTxtName().getText().trim().isEmpty()) {
            String Name = frame.getTxtName().getText();
            int ID = Integer.parseInt(frame.getTxtId().getText().trim());
            Er.setName(Name);
            Er.setId(ID);
            JOptionPane.showMessageDialog(frame, "Data telah di input");
        } else {
            JOptionPane.showMessageDialog(frame, "isi terlebih dahulu");
        }

        IntrfcRM.insert(Er);

    }

    public void update() {
        if (!frame.getTxtId().getText().trim().isEmpty() && !frame.getTxtName().getText().trim().isEmpty()) {
            String Name = frame.getTxtName().getText();
            int ID = Integer.parseInt(frame.getTxtId().getText().trim());
            Er.setName(Name);
            Er.setId(ID);
            JOptionPane.showMessageDialog(frame, "Data telah di update");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di update");
        }
        IntrfcRM.update(Er);
    }

    public void delete() {
        if (!frame.getTxtId().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtId().getText());
            IntrfcRM.delete(id);
            JOptionPane.showMessageDialog(frame, "Data sudah dihapus");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }

    }

    public void searchRegion(JTable tabel) {
        ListRegion = IntrfcRM.getCariRegions(frame.getTxtSearch().getText().trim());
        DefaultTableModel tR = (DefaultTableModel) tabel.getModel();

        Object[] row;
        row = new Object[ListRegion.size()];
        while (tR.getRowCount() < ListRegion.size()) {
            row[0] = ListRegion.get(tR.getRowCount()).getId();
            row[1] = ListRegion.get(tR.getRowCount()).getName();
            tR.addRow(row);

        }
        frame.getTblView().setModel(tR);
    }

    public void searchname() {
        if (!frame.getTxtSearch().getText().trim().isEmpty()) {
            IntrfcRM.getCariRegions(frame.getTxtSearch().getText());
            searchRegion(frame.getTblView());
        } else {
            JOptionPane.showMessageDialog(frame, "Inputkan data yang akan dicari");
        }
    }

}
