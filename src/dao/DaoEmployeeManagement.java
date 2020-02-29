/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import models.EntityEmployee;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoEmployeeManagement implements InterfaceEmployeeManagement{
     Connection c;
     final String insert = "INSERT INTO HR.Employees (Employee_id,First_name,Last_name,"
            + "EMail,phone_number,Hire_date,Job_id,Salary,Commission_PCT,Manager_id,"
            + "Department_id)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    final String update = "UPDATE HR.Employees SET employee_name=?,first_name = ?,"
            + "last_name=?, Email=?, phone_number=?,hire_date=?,job_id=?,Salary=?"
            + "COmmission_pct=?,Manager_id=?,department_id=? WHERE employee_id=?";
    final String delete = "DELETE FROM HR.employees WHERE employee_id =?";
    final String select = "SELECT * FROM HR.employees ORDER BY employee_ID";
    final String search = "SELECT * FROM HR.employees WHERE last_NAME LIKE ?";
    PreparedStatement statement = null;
    public DaoEmployeeManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insert(EntityEmployee EM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(EntityEmployee EM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityEmployee> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
