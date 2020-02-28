/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoJobsManagement;
import dao.InterfaceJobsManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityJob;
import views.JobsView;

/**
 *
 * @author amry4
 */
public class JobsController {

    JobsView frame;
    InterfaceJobsManagement IntrfcJM;
    List<EntityJob> ListJob;
    EntityJob EJ = new EntityJob();

    public JobsController(JobsView frame) {
        this.frame = frame;
        IntrfcJM = new DaoJobsManagement();
        ListJob = IntrfcJM.getALL();
    }

    public void reset() {
        frame.getjTxtJobId().setText("");
        frame.getjTxtJobTitle().setText("");
        frame.getjTxtMaxSal().setText("");
        frame.getjTxtMinSal().setText("");

    }

    public void isiTabel(JTable tabel) {
        ListJob = IntrfcJM.getALL();
        DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();

        Object[] row;
        row = new Object[ListJob.size()];
        while (dtm.getRowCount() < ListJob.size()) {
            row[0] = ListJob.get(dtm.getRowCount()).getId();
            row[1] = ListJob.get(dtm.getRowCount()).getTitle();
            dtm.addRow(row);

        }

        frame.getjTblJob().setModel(dtm);

    }

    public void isiField(int row) {
        frame.getjTxtJobId().setText(ListJob.get(row).getId().toString());
        frame.getjTxtJobTitle().setText(ListJob.get(row).getTitle());
        frame.getjTxtMinSal().setText(String.valueOf(ListJob.get(row).getMinSalary()));
        frame.getjTxtMaxSal().setText(String.valueOf(ListJob.get(row).getMaxSalary()));

    }

    public void clear(JTable tabel) {
        DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    public void refresh() {
        reset();
        clear(frame.getjTblJob());
        isiTabel(frame.getjTblJob());
    }

    public boolean IsEmptyField() {
        if (!frame.getjTxtJobId().getText().trim().isEmpty()
                && !frame.getjTxtJobTitle().getText().trim().isEmpty()
                && !frame.getjTxtMaxSal().getText().trim().isEmpty()
                && !frame.getjTxtMinSal().getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void insert() {
        if (IsEmptyField()) {
            EJ.setId(frame.getjTxtJobId().getText());
            EJ.setTitle(frame.getjTxtJobTitle().getText().trim());
            EJ.setMinSalary(Float.valueOf(frame.getjTxtMinSal().getText().trim()));
            EJ.setMaxSalary(Float.valueOf(frame.getjTxtMaxSal().getText().trim()));
            JOptionPane.showMessageDialog(frame, "Data telah di input");
        } else {
            JOptionPane.showMessageDialog(frame, "isi terlebih dahulu");
        }

        IntrfcJM.insert(EJ);

    }

    public void update() {
        if (IsEmptyField()) {
            EJ.setTitle(frame.getjTxtJobTitle().getText().trim());
            EJ.setMinSalary(Float.valueOf(frame.getjTxtMinSal().getText().trim()));
            EJ.setMaxSalary(Float.valueOf(frame.getjTxtMaxSal().getText().trim()));
            EJ.setId(frame.getjTxtJobId().getText());
            JOptionPane.showMessageDialog(frame, "Data telah di update");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di update");
        }
        IntrfcJM.update(EJ);
    }

    public void delete() {
        if (IsEmptyField()) {
            String id= frame.getjTxtJobId().getText();
            IntrfcJM.delete(id);
            JOptionPane.showMessageDialog(frame, "Data sudah dihapus");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }

    }
}
