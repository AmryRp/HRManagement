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
                EntityJobHistory Er = new EntityJobHistory();
                Er.setId(rs.getInt(1));
                Er.setStartDate(rs.getDate(2));
                Er.setStartDate(rs.getDate(3));
                Er.setJobId(rs.getString(4));
                Er.setDepartmentId(rs.getInt(3));
                lb.add(Er);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }

}
