/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployeeDao;
import dao.IGeneric;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.Department;
import model.Employee;
import model.Job;
import view.EmployeeView;

/**
 *
 * @author amry4
 */
public class EmployeeController {

    public EmployeeController() {

    }

    EmployeeView frame;
    IGeneric<Employee, Integer, String> IntrfcJM;
    List<Employee> ListJob;
    Employee EJ = new Employee();

    public EmployeeController(EmployeeView frame) {
        this.frame = frame;
        IntrfcJM = new EmployeeDao();
        ListJob = IntrfcJM.getAll();
    }

    /**
     * This function is used for save,update or input data on table Employee 
     * by:bootcamp34
     * @param employeeId is String Datatype for employeeId
     * @param firstName is String Datatype for firstName
     * @param lastName is String Datatype for lastName
     * @param email is String Datatype for email
     * @param phoneNumber is String Datatype for phoneNumber
     * @param hireDate is String Datatype for hireDate
     * @param salary is String Datatype for salary
     * @param commission is String Datatype for commission
     * @param departmentId is String Datatype for departmentId
     * @param managerId is String Datatype for managerId
     * @param jobId is String Datatype for jobId
     * @return to String to insertOrUpdate with object Employee
     */
    public String save(String employeeId, String firstName, String lastName, String email, String phoneNumber,
            String hireDate, String salary, String commission, String departmentId, String managerId, String jobId) {
        IntrfcJM = new EmployeeDao();
        return (IntrfcJM.insertOrUpdate(new Employee(Integer.parseInt(employeeId), firstName, lastName, email,
                phoneNumber, new Date(hireDate), new BigDecimal(salary), new BigDecimal(commission), new Department(new Short(departmentId)), new Employee(managerId), new Job(jobId)))) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table 
     * by: bootcamp34
     *
     * @param Id is string datatype converted to Integer for deleting data
     * @return to String to delete from object Employee
     */
    public String delete(String id) {
        IntrfcJM = new EmployeeDao();
        return (IntrfcJM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

    /**
     * this function used for search a data from table
     *
     * @param Name is String Datatype
     * @return to List Employee
     */
    public List<Employee> search(String Name) {
        IntrfcJM = new EmployeeDao();
        return IntrfcJM.search(Name);
    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is int Datatype
     * @return to boolean true or false
     */
    public boolean confirm(int id) {
        IntrfcJM = new EmployeeDao();
        return (IntrfcJM.getById(id) != null);
    }
}
