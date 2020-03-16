/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import dao.IDao;
import java.util.List;
import model.Job;
import dao.IDao;

/**
 *
 * @author amry4
 */
public class JobController {



    IDao<Job> IntrfcJM;
    List<Job> ListJob;
    Job EJ = new Job();

    public JobController() {
     
        IntrfcJM = new GeneralDao();
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
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(new Job(id, title, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)),"","","",true,false) != null) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype converted to short for deleting data
     * @return to String to delete from object Job
     */
    public String delete(String id) {
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(new Job(),"","",id,true,true) != null) ? "sukses" : "failed";

    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(EJ,"jobId",id,"",false,false) != null);
    }
}
