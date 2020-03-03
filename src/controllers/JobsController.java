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
import views.JobInternalView;
import dao.InterfaceJobManagement;

/**
 *
 * @author amry4
 */
public class JobsController {

    public JobsController() {
       
    }

    JobInternalView frame;
    InterfaceJobManagement IntrfcJM;
    List<EntityJob> ListJob;
    EntityJob EJ = new EntityJob();

    public JobsController(JobInternalView frame) {
        this.frame = frame;
        IntrfcJM = new DaoJobManagement();
        ListJob = IntrfcJM.getALL();
    }

    public String Save(String id, String title, String minSalary, String maxSalary, boolean isSave) {
       IntrfcJM = new DaoJobManagement();
        return (IntrfcJM.insertOrUpdate(new EntityJob(id, title, Float.valueOf(minSalary),
                Float.valueOf(maxSalary)), isSave)) ? "sukses" : "failed";

    }

    public String delete(String id) {
          IntrfcJM = new DaoJobManagement();
        return (IntrfcJM.delete(id)) ? "sukses" : "failed";

    }
    public String getById(String id) {

        return (new DaoJobManagement().getById(id));
    }
}
