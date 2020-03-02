/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.EntityJobHistory;
import java.sql.ResultSet;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoJobHistoryManagement implements InterfaceJobHistoryManagement {

    Connection c;
    final String select = "SELECT * FROM HR.job_history ORDER BY job_id";
    final String search = "SELECT * FROM HR.job_history WHERE job_id LIKE ?";
    PreparedStatement statement = null;

    public DaoJobHistoryManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    @Override
    public List<EntityJobHistory> getALL() {
        List<EntityJobHistory> lb = null;

        try {
            lb = new ArrayList<EntityJobHistory>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityJobHistory ejh = new EntityJobHistory();
                ejh.setId(rs.getInt(1));
                ejh.setStartDate(rs.getDate(2));
                ejh.setEndDate(rs.getDate(3));
                ejh.setJobId(rs.getString(4));
                ejh.setDepartmentId(rs.getInt(5));
                lb.add(ejh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<EntityJobHistory> getCari(String nama) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
