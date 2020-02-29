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
    final String search = "SELECT * FROM HR.Locations WHERE REGION_NAME LIKE ?";
      PreparedStatement ps = null;

    public DaoLocationManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insertOrUpdate(EntityLocation EL,boolean isInsert) {
      
        try {
            ps = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            ps.setString(1, EL.getAddress());
            ps.setString(2, EL.getZipCode());
            ps.setString(3, EL.getCity());
            ps.setString(4, EL.getProvince());
            ps.setString(5, EL.getIdCountry());
            ps.setInt(6, EL.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        
        try {
            ps = c.prepareStatement(delete);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
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

    

}
