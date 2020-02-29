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
public class DaoJobManagement implements InterfaceJobManagement{

    Connection c;
    final String insert = "INSERT INTO HR.Employees (job_title,"
            + "min_salary,max_salary,Job_id)VALUES(?,?,?,?)";
    final String update = "UPDATE HR.Employees SET job_title=?,min_Salary=?"
            + ", max_Salary=? WHERE job_id=?";
    final String delete = "DELETE FROM HR.jobs WHERE job_id =?";
    final String select = "SELECT * FROM HR.jobs ORDER BY job_id";
    final String search = "SELECT * FROM HR.jobs WHERE job_title LIKE ?";
    PreparedStatement pst = null;
    public DaoJobManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }
    @Override
    public boolean insertOrUpdate(EntityJob Ej,boolean isInsert) {
        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            pst.setString(1, Ej.getTitle());
            pst.setFloat(2, Ej.getMinSalary());
            pst.setFloat(3, Ej.getMaxSalary());
            pst.setString(4, Ej.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } }

    @Override
    public boolean delete(String id) {
          try {
            pst = c.prepareStatement(delete);
            pst.setString(1, id);
            pst.executeQuery();
            return pst.executeUpdate() > 0;
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
            Logger.getLogger(DaoJobManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    
    }
    
}
