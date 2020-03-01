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
import models.EntityLocation;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoLocationManagement implements InterfaceLocationManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Locations (STREET_ADDRESS,"
            + "POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID,LOCATION_ID)VALUES(?,?,?,?,?,?)";
    final String update = "UPDATE HR.Locations SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=?,  "
            + "STATE_PROVINCE=?, COUNTRY_ID=? WHERE LOCATION_ID=?";
    final String delete = "DELETE FROM HR.Locations WHERE LOCATION_ID =?";
    final String select = "SELECT * FROM HR.Locations ORDER BY LOCATION_ID";
    final String selectFK = "SELECT CITY FROM HR.Locations WHERE location_id = ?";
    PreparedStatement pst = null;

    public DaoLocationManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insertOrUpdate(EntityLocation EL, boolean isInsert) {

        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            pst.setString(1, EL.getAddress());
            pst.setString(2, EL.getZipCode());
            pst.setString(3, EL.getCity());
            pst.setString(4, EL.getProvince());
            pst.setString(5, EL.getIdCountry());
            pst.setInt(6, EL.getId());
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
    public List<EntityLocation> getALL() {
        List<EntityLocation> lb = null;
        try {
            lb = new ArrayList<EntityLocation>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityLocation Er = new EntityLocation();
                Er.setId(rs.getInt(1));
                Er.setAdrress(rs.getString(2));
                Er.setZipCode(rs.getString(3));
                Er.setCity(rs.getString(4));
                Er.setProvince(rs.getString(5));
                Er.setIdCountry(rs.getString(6));
                lb.add(Er);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLocationManagement.class.getName()).log(Level.SEVERE, null, ex);
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
            return temp;
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }
}
