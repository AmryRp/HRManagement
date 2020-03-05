/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IJobDao;
import dao.JobDao;
import java.util.List;
import model.Job;
import view.JobView;

/**
 *
 * @author amry4
 */
public class JobController {
     public JobController() {
       
    }

    JobView frame;
    IJobDao IntrfcJM;
    List<Job> ListJob;
    Job EJ = new Job();

    public JobController(JobView frame) {
        this.frame = frame;
        IntrfcJM = new JobDao();
        ListJob = IntrfcJM.getAll();
    }

    public String save(String id, String title, String minSalary, String maxSalary) {
       IntrfcJM = new JobDao();
        return (IntrfcJM.insertOrUpdate(new Job(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)))) ? "sukses" : "failed";

    }

    public String delete(String id) {
          IntrfcJM = new JobDao();
        return (IntrfcJM.delete(new Job(id))) ? "sukses" : "failed";

    }
     public List<Job> search(String Name) {
        IntrfcJM = new JobDao();
        return IntrfcJM.search(new Job(Name));
    }

    public boolean confirm(int id) {
        IntrfcJM = new JobDao();
       return(IntrfcJM.getById(id) != null); 
    }
}
