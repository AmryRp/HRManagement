/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoJobGradeManagement;
import dao.InterfaceJobGradeManagement;
import java.util.List;
import models.EntityJobGrade;
import views.JobGradeView;

/**
 *
 * @author amry4
 */
public class JobGradeController {
        JobGradeView JGview;
        InterfaceJobGradeManagement ijgm;
        List<EntityJobGrade> listJG;

    public JobGradeController(JobGradeView JGview) {
        this.JGview = JGview;
        ijgm = new DaoJobGradeManagement();
        listJG = ijgm.getALL();
    }

    public JobGradeController() {
    }
    
    public String Save(String id, String firstName, String lastName, boolean isSave) {

        return (ijgm.insertOrUpdate(new EntityJobGrade(id, Integer.parseInt(firstName),Integer.parseInt(lastName)),
                isSave)) ? "sukses" : "failed";
    }

    public String delete(String id) {
        return (ijgm.delete(id)) ? "sukses" : "failed";

    }

}
