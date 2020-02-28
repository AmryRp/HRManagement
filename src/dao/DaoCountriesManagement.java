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
import models.EntityCountries;
import models.EntityLocation;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoCountriesManagement implements InterfaceCountriesManagement {

    Connection c;
    final String insert = "INSERT INTO HR.Countries VALUES(?,?,?)";
    final String update = "UPDATE HR.Countries SET COUNTRY_NAME=?,"
            + " REGION_ID=? WHERE Country_ID=?";
    final String delete = "DELETE FROM HR.Countries WHERE Country_id =?";
    final String select = "SELECT * FROM HR.Countries ORDER BY Country_ID";
    final String search = "SELECT * FROM HR.Countries WHERE Country_NAME LIKE ?";
    final String selectFK = "SELECT Country_name FROM HR.Countries where country_id = ?";
    PreparedStatement pst = null;

    public DaoCountriesManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insert(EntityCountries EC) {

        try {
            pst = c.prepareStatement(insert);
            pst.setString(1, EC.getId());
            pst.setString(2, EC.getCountryName());
            pst.setInt(3, EC.getRegionId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EntityCountries EC) {
        try {
            pst = c.prepareStatement(update);
            pst.setString(1, EC.getCountryName());
            pst.setInt(2, EC.getRegionId());
            pst.setString(3, EC.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            pst = c.prepareStatement(delete);
            pst.setString(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EntityCountries> getALL() {
        List<EntityCountries> lb = null;

        try {
            lb = new ArrayList<EntityCountries>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityCountries EC = new EntityCountries();
                EC.setId(rs.getString(1));
                EC.setCountryName(rs.getString(2));
                EC.setRegionId(rs.getInt(3));
                lb.add(EC);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCountriesManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<EntityCountries> getCariRegions(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getById(String Id) {
        ResultSet rs;
        String temp = null;
        try {
            EntityCountries EC = new EntityCountries();
            pst = c.prepareStatement(selectFK);
            rs = pst.executeQuery();
            while (rs.next())
            {
//             EC.setId(rs.getString(1));
             temp = rs.getString(1);
            }
           

        } catch (Exception e) {
            return e.toString();
        }
    return temp;   
    }

}
