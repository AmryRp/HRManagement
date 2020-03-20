/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Department;
import model.Employee;
import model.Job;
import dao.GeneralDao;
import dao.IDao;

/**
 *
 * @author amry4
 */
public class EmployeeController {




    IDao<Employee> IntrfcJM;
    List<Employee> ListJob;
    Employee EJ = new Employee();

    public EmployeeController() {

        IntrfcJM = new GeneralDao();

    }

    /**
     * This function is used for save,update or input data on table Employee
     * by:bootcamp34
     *
     * @param employeeId is String Datatype for employeeId
     * @param firstName is String Datatype for firstName
     * @param lastName is String Datatype for lastName
     * @param email is String Datatype for email
     * @param phoneNumber is String Datatype for phoneNumber
     * @param date is String Datatype for hireDate
     * @param salary is String Datatype for salary
     * @param commission is String Datatype for commission
     * @param departmentId is String Datatype for departmentId
     * @param managerId is String Datatype for managerId
     * @param jobId is String Datatype for jobId
     * @return to String to insertOrUpdate with object Employee
     * @throws java.text.ParseException throws parsing exception use try catch
     */
    public String save(String employeeId, String firstName, String lastName, String email, String phoneNumber,
            String date, String jobId, String salary, String commission, String managerId, String departmentId) throws ParseException {
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(new Employee(new Integer(employeeId), firstName, lastName, email,
                phoneNumber, toDate(date), (new Job(jobId)), new BigDecimal(salary),
                new BigDecimal(commission), (new Employee(new Integer(managerId))),
                (new Department(new Short(departmentId)))), "", "", 0, true, false) != null) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table by: bootcamp34
     *
     * @param id is string datatype converted to Integer for deleting data
     * @return to String to delete from object Employee
     */
    public String delete(String id) {
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(new Employee(), "", "", new Integer(id), true, true) != null) ? "sukses" : "failed";

    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is int Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IntrfcJM = new GeneralDao();
        return (IntrfcJM.manageData(new Employee(), "employeeId", id, "", false, false) != null);
    }

    /**
     * this function used for convert string to date
     *
     * @param date is string datatype
     * @return to sqlDate (Date datatype)
     * @throws ParseException it throw parsing
     */
    public Date toDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        java.util.Date Dates = sdf.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(Dates.getTime());
        return sqlDate;
    }
}
