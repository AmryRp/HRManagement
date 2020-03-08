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

    public String save(String employeeId, String firstName, String lastName, String email, String phoneNumber, 
            String hireDate, String salary,String Commission, String departmentId, String managerId, String jobId) {
       IntrfcJM = new EmployeeDao();
        return (IntrfcJM.insertOrUpdate(new Employee(Integer.parseInt(employeeId), firstName,lastName,email,
                phoneNumber,new Date(hireDate),new BigDecimal(salary),new BigDecimal(Commission),new Department(new Short(departmentId)),new Employee(managerId),new Job(jobId) ))) ? "sukses" : "failed";

    }

    public String delete(String id) {
          IntrfcJM = new EmployeeDao();
        return (IntrfcJM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }
     public List<Employee> search(String Name) {
        IntrfcJM = new EmployeeDao();
        return IntrfcJM.search(Name);
    }

    public boolean confirm(int id) {
        IntrfcJM = new EmployeeDao();
       return(IntrfcJM.getById(id) != null); 
    }
}
