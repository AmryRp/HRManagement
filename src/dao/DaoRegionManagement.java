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
import models.EntityRegion;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoRegionManagement implements InterfaceRegionManagement {

    Connection c;
    final String insert = "INSERT INTO HR.REGIONS(REGION_NAME,REGION_ID)VALUES(?,?)";
    final String update = "UPDATE HR.regions SET region_name=? WHERE region_id=?";
    final String delete = "DELETE FROM HR.REGIONS WHERE Region_id =?";
    final String select = "SELECT * FROM HR.REGIONS ORDER BY REGION_ID";
    final String search = "SELECT * FROM HR.REGIONS WHERE REGION_NAME LIKE ?";
    PreparedStatement pst = null;

    public DaoRegionManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public boolean insertOrUpdate(EntityRegion Er, boolean isInsert) {
        
        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            pst.setString(1, Er.getName());
            pst.setInt(2, Er.getId());
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
    public List<EntityRegion> getALL() {
        List<EntityRegion> lb = null;

        try {
            lb = new ArrayList<EntityRegion>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityRegion Er = new EntityRegion();
                Er.setId(rs.getInt(1));
                Er.setName(rs.getString(2));
                lb.add(Er);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

}
