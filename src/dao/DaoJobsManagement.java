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
import models.EntityJob;
import tools.Connections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amry4
 */
public class DaoJobsManagement implements InterfaceJobManagement{

    Connection c;
    final String insert = "INSERT INTO HR.Employees (Job_id,job_title,"
            + "min_salary,max_salar)VALUES(?,?,?,?)";
    final String update = "UPDATE HR.Employees SET job_id=?,job_title=?,min_Salary=?"
            + ", max_Salary=? WHERE job_id=?";
    final String delete = "DELETE FROM HR.jobs WHERE job_id =?";
    final String select = "SELECT * FROM HR.jobs ORDER BY job_id";
    final String search = "SELECT * FROM HR.jobs WHERE job_title LIKE ?";
    PreparedStatement statement = null;
    public DaoJobsManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }
    @Override
    public boolean insert(EntityJob Ej) {
        
        try {
            statement = c.prepareStatement(insert);
            statement.setString(1, Ej.getId());
            statement.setString(2, Ej.getTitle());
            statement.setFloat(3, Ej.getMinSalary());
            statement.setFloat(4, Ej.getMaxSalary());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EntityJob Ej) {
       
        try {
            statement = c.prepareStatement(update);
            statement.setString(1, Ej.getId());
            statement.setString(2, Ej.getTitle());
            statement.setFloat(3, Ej.getMinSalary());
            statement.setFloat(4, Ej.getMaxSalary());
            statement.setString(5, Ej.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } }

    @Override
    public boolean delete(String id) {
          try {
            statement = c.prepareStatement(delete);
            statement.setString(1, id);
            statement.executeQuery();
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EntityJob> getALL() {
         List<EntityJob> lb = null;
        try {
            lb = new ArrayList<EntityJob>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityJob Er = new EntityJob();
                Er.setId(rs.getString(1));
                Er.setTitle(rs.getString(2));
                Er.setMinSalary(rs.getFloat(3));
                Er.setMaxSalary(rs.getFloat(4));
                lb.add(Er);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    
    }
    
}
