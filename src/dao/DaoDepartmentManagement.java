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
public class DaoDepartmentManagement implements InterfaceDepartmentManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Departments (department_name,"
            + "manager_id,location_id,department_id)VALUES(?,?,?,?)";
    final String update = "UPDATE HR.Departments SET department_NAME=?, manager_id_ID=?, location_id=? WHERE department_ID=?";
    final String delete = "DELETE FROM HR.departments WHERE department_id =?";
    final String select = "SELECT * FROM HR.departments";
    final String selectFK = "SELECT department_name FROM HR.Departments where department_id = ?";
    PreparedStatement pst = null;

    public DaoDepartmentManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insertOrUpdate(EntityDepartment ED, boolean isInsert) {

        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
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
            Logger.getLogger(DaoDepartmentManagement.class.getName()).log(Level.SEVERE, null, ex);
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
            pst.execute();
            rs = pst.getResultSet();
            while (rs.next()) {
                temp = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }

    @Override
    public List<EntityDepartment> getCari(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
