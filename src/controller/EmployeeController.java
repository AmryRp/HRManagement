/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IEmployeeDao;
import dao.EmployeeDao;
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
    IEmployeeDao IntrfcJM;
    List<Employee> ListJob;
    Employee EJ = new Employee();

    public EmployeeController(EmployeeView frame) {
        this.frame = frame;
        IntrfcJM = new EmployeeDao();
        ListJob = IntrfcJM.getAll();
    }

    public String save(String employeeId, String firstName, String lastName, String email, String phoneNumber, 
            Date hireDate, String salary, String departmentId, String managerId, String jobId) {
       IntrfcJM = new EmployeeDao();
        return (IntrfcJM.insertOrUpdate(new Employee(Integer.parseInt(employeeId), firstName,lastName,email,
                phoneNumber,hireDate,new BigDecimal(salary),new Department(new Short(departmentId)),new Employee(managerId),new Job(jobId) ))) ? "sukses" : "failed";

    }

    public String delete(String id) {
          IntrfcJM = new EmployeeDao();
        return (IntrfcJM.delete(new Employee(id))) ? "sukses" : "failed";

    }
     public List<Employee> search(String Name) {
        IntrfcJM = new EmployeeDao();
        return IntrfcJM.search(new Employee(Name));
    }

    public boolean confirm(int id) {
        IntrfcJM = new EmployeeDao();
       return(IntrfcJM.getById(id) != null); 
    }
}