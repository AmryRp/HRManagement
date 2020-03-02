/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.EntityEmployee;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoEmployeeManagement implements InterfaceEmployeeManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Employees (First_name,Last_name,"
            + "EMail,phone_number,Hire_date,Job_id,Salary,Commission_PCT,Manager_id,"
            + "Department_id,Employee_id)VALUES(?,?,?,?,TO_DATE(?,'dd/mm/yy'),?,?,?,?,?,?)";
    final String update = "UPDATE HR.Employees SET first_name = ?,"
            + "last_name=?, Email=?, phone_number=?,hire_date=?,job_id=?,Salary=?"
            + "COmmission_pct=?,Manager_id=?,department_id=? WHERE employee_id=?";
    final String delete = "DELETE FROM HR.employees WHERE employee_id =?";
    final String select = "SELECT * FROM HR.employees ORDER BY employee_ID";
    final String search = "SELECT * FROM HR.employees WHERE last_NAME LIKE ?";
    final String selectManager = "select distinct manager.employee_id,manager.last_name from HR.employees worker Join HR.employees manager ON (worker.manager_id = manager.employee_id)";
    final String selectFK = "SELECT last_name FROM HR.employees where employee_id = ?";
    PreparedStatement pst = null;

    public DaoEmployeeManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insertOrUpdate(EntityEmployee EM, boolean isInsert) {

        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            pst.setString(1, EM.getFirstName());
            pst.setString(2, EM.getLastName());
            pst.setString(3, EM.getEmail());
            pst.setString(4, EM.getPhoneNumber());
            pst.setDate(5, EM.getHireDate());
            pst.setString(6, EM.getJobId());
            pst.setFloat(7, EM.getSalary());
            pst.setFloat(8, EM.getCommision());
            pst.setInt(9, EM.getManagerId());
            pst.setInt(10, EM.getDeptId());
            pst.setInt(11, EM.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            pst = c.prepareStatement(delete);
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EntityEmployee> getALL() {
        List<EntityEmployee> lb = null;

        try {
            lb = new ArrayList<EntityEmployee>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityEmployee EM = new EntityEmployee();
                EM.setId(rs.getInt(1));
                EM.setFirstName(rs.getString(2));
                EM.setLastName(rs.getString(3));
                EM.setEmail(rs.getString(4));
                EM.setPhoneNumber(rs.getString(5));
                EM.setHireDate(rs.getDate(6));
                EM.setJobId(rs.getString(7));
                EM.setSalary(rs.getFloat(8));
                EM.setCommision(rs.getFloat(9));
                EM.setManagerId(rs.getInt(10));
                EM.setDeptId(rs.getInt(11));
                lb.add(EM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public String getById(int Id) {
        String temp = "";
        try {
            ResultSet rs;
            temp = new String();
            pst = c.prepareStatement(selectFK);
            pst.setInt(1, Id);
            pst.executeUpdate();
            rs = pst.getResultSet();
            while (rs.next()) {
              
                temp = rs.getString(1);
            }
            
        } catch (SQLException e) {
            
             e.printStackTrace();
             return temp;
        }
        
        return temp;
    }
    
    @Override
    public List<EntityEmployee> getAllManager() {
        List<EntityEmployee> ListManager = null;

        try {
            ListManager = new ArrayList<EntityEmployee>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(selectManager);
            while (rs.next()) {
                EntityEmployee EJM = new EntityEmployee();
                EJM.setId(rs.getInt(1));
                EJM.setLastName(rs.getString(2));
                
                ListManager.add(EJM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListManager;
    }


    @Override
    public List<EntityEmployee> getAllJob() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityEmployee> getAllDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityEmployee> getCari(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
