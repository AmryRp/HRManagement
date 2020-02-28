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
import models.EntityDepartment;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoDepartmentsManagement implements InterfaceDepartmentsManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Departments (department_id,department_name,manager_id,location_id)VALUES(?,?,?,?)";
    final String update = "UPDATE HR.Departments SET department_NAME=?, manager_id_ID=?, location_id=? WHERE department_ID=?";
    final String delete = "DELETE FROM HR.departments WHERE department_id =?";
    final String select = "SELECT * FROM HR.departments ORDER BY department_ID";
    final String selectFK = "SELECT Location_id FROM HR.locatins";
    PreparedStatement pst = null;

    public DaoDepartmentsManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insert(EntityDepartment ED) {
        try {
            pst = c.prepareStatement(insert);
            pst.setInt(1, ED.getId());
            pst.setString(2, ED.getName());
            pst.setInt(3, ED.getManagerId());
            pst.setInt(4, ED.getLocationId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EntityDepartment ED) {
        PreparedStatement pst = null;
        try {
            pst = c.prepareStatement(update);
            pst.setString(1, ED.getName());
            pst.setInt(2, ED.getManagerId());
            pst.setInt(3, ED.getLocationId());
            pst.setInt(4, ED.getId());
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
            pst.executeQuery();
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EntityDepartment> getALL() {
          List<EntityDepartment> lb = null;
        try {
            lb = new ArrayList<EntityDepartment>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityDepartment Er = new EntityDepartment();
                Er.setId(rs.getInt(1));
                Er.setName(rs.getString(2));
                Er.setManagerId(rs.getInt(3));
                Er.setLocationId(rs.getInt(4));
                lb.add(Er);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb; }
}
