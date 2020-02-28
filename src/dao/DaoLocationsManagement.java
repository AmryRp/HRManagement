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
public class DaoLocationsManagement implements InterfaceLocationsManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Locations (LOCATION_ID,STREET_ADDRESS,"
            + "POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID)VALUES(?,?,?,?,?,?)";
    final String update = "UPDATE HR.Locations SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=?,  "
            + "STATE_PROVINCE=?, COUNTRY_ID=? WHERE LOCATION_ID=?";
    final String delete = "DELETE FROM HR.Locations WHERE LOCATION_ID =?";
    final String select = "SELECT * FROM HR.Locations ORDER BY LOCATION_ID";
    final String search = "SELECT * FROM HR.Locations WHERE REGION_NAME LIKE ?";
    final String selectFK = "SELECT Country_id FROM HR.Countries";
    PreparedStatement statement = null;

    public DaoLocationsManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insert(EntityLocation EL) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(insert);
            statement.setInt(1, EL.getId());
            statement.setString(2, EL.getAddress());
            statement.setString(3, EL.getZipCode());
            statement.setString(4, EL.getCity());
            statement.setString(5, EL.getProvince());
            statement.setString(6, EL.getIdCountry());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EntityLocation EL) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(update);
            statement.setString(1, EL.getAddress());
            statement.setString(2, EL.getZipCode());
            statement.setString(3, EL.getCity());
            statement.setString(4, EL.getProvince());
            statement.setString(5, EL.getIdCountry());
            statement.setInt(6, EL.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(delete);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
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
            Logger.getLogger(DaoLocationsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<EntityLocation> getCariRegions(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
