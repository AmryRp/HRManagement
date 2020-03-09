/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IGeneric;
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
    IGeneric<Job> IntrfcJM;
    List<Job> ListJob;
    Job EJ = new Job();

    public JobController(JobView frame) {
        this.frame = frame;
        IntrfcJM = new JobDao();
        ListJob = IntrfcJM.getAll();
    }

    /**
     * This function is used for save,update or input data on table Job
     *
     * @param id is String Datatype for jobId
     * @param title is String Datatype for jobTitle
     * @param minSalary is String Datatype for minSalary
     * @param maxSalary is String Datatype for maxSalary
     * @return to String to insertOrUpate to object Job
     */
    public String save(String id, String title, String minSalary, String maxSalary) {
        IntrfcJM = new JobDao();
        return (IntrfcJM.insertOrUpdate(new Job(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)))) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype converted to short for deleting data
     * @return to String to delete from object Job
     */
    public String delete(String id) {
        IntrfcJM = new JobDao();
        return (IntrfcJM.delete(id)) ? "sukses" : "failed";

    }

    /**
     * this function used for search a data from table
     *
     * @param Name is String Datatype
     * @return to List Job
     */
    public List<Job> search(String Name) {
        IntrfcJM = new JobDao();
        return IntrfcJM.search(Name);
    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcJM = new JobDao();
        return (IntrfcJM.getById(id) != null);
    }
}
