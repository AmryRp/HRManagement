/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoJobHistoryManagement;
import dao.InterfaceJobHistoryManagement;
import java.util.List;
import models.EntityJobHistory;
import views.JobHistoryView;

/**
 *
 * @author amry4
 */
public class JobHistoryController {
    
    JobHistoryView jhview;

    public JobHistoryController(JobHistoryView jhview) {
        this.jhview = jhview;
        ijhm =  new DaoJobHistoryManagement();
        ListEJH = ijhm.getALL();
        
    }
    List<EntityJobHistory> ListEJH;
    InterfaceJobHistoryManagement ijhm;

    public JobHistoryController() {
        
    }
}
