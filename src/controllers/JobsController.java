/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoJobManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityJob;
import views.JobsView;
import dao.InterfaceJobManagement;

/**
 *
 * @author amry4
 */
public class JobsController {

    JobsView frame;
    InterfaceJobManagement IntrfcJM;
    List<EntityJob> ListJob;
    EntityJob EJ = new EntityJob();

    public JobsController(JobsView frame) {
        this.frame = frame;
        IntrfcJM = new DaoJobManagement();
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


    public String Save(String id, String title, String minSalary, String maxSalary, boolean isSave) {
        return (IntrfcJM.insertOrUpdate(new EntityJob(id, title, Float.valueOf(minSalary),
                Float.valueOf(maxSalary)), isSave)) ? "sukses" : "failed";

    }

    public String delete(String id) {
         return (IntrfcJM.delete(id)) ? "sukses" : "failed";

    }
}
