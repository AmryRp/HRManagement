/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoEmployeeManagement;
import dao.InterfaceEmployeeManagement;
import java.sql.Date;
import java.util.List;
import models.EntityEmployee;
import views.EmployeeView;

/**
 *
 * @author amry4
 */
public class EmployeeController {

    public EmployeeController(EmployeeView frame) {
        this.EmpView = frame;
        IntrfcEM = new DaoEmployeeManagement();
        ListEmp = IntrfcEM.getALL();
    }
    EmployeeView EmpView;
    InterfaceEmployeeManagement IntrfcEM;
    List<EntityEmployee> ListEmp;
    EntityEmployee EM = new EntityEmployee();

    public String Save(String id, String firstName, String lastName, String email,
            String phoneNumber, String hireDate, String jobId, String Salary, String commision, String managerId, String deptId, boolean isSave) {

        return (IntrfcEM.insertOrUpdate(new EntityEmployee(Integer.parseInt(id), firstName, lastName, email, phoneNumber,
                Date.valueOf(hireDate), jobId, Float.valueOf(Salary), Float.valueOf(commision), Integer.parseInt(managerId), Integer.parseInt(deptId)),
                isSave)) ? "sukses" : "failed";
    }
    
    public String delete(String id) {
         return (IntrfcEM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }
}
