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
import models.EntityJobGrade;
import tools.Connections;

/**
 *
 * @author amry4
 */
public class DaoJobGradeManagement implements InterfaceJobGradeManagement {

    public DaoJobGradeManagement() {
        Connections conn = new Connections();
        c = conn.getC();
    }

    Connection c;
    final String insert = "INSERT INTO HR.Job_grade(Lowest_sal,Highest_sal,Grade_level )VALUES(?,?,?)";
    final String update = "UPDATE HR.Job_grade SET Lowest_name = ?,Highest_sal = ? WHERE Grade_level=?";
    final String delete = "DELETE FROM HR.Job_grade WHERE Grade_level =?";
    final String select = "SELECT * FROM HR.Job_grade ORDER BY Grade_level";
    final String search = "SELECT * FROM HR.Job_grade WHERE last_NAME LIKE ?";
    PreparedStatement pst = null;

    @Override
    public boolean insertOrUpdate(EntityJobGrade EJD, boolean isInsert) {
        
        try {
            pst = (isInsert) ? c.prepareStatement(insert) : c.prepareStatement(update);
            pst.setInt(1, EJD.getLowestSalary());
            pst.setInt(2, EJD.getHighestSalary());
            pst.setString(3, EJD.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }}

    @Override
    public boolean delete(String id) {
         try {
            pst = c.prepareStatement(delete);
            pst.setString(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }}

    @Override
    public List<EntityJobGrade> getALL() {
        List<EntityJobGrade> lb = null;

        try {
            lb = new ArrayList<EntityJobGrade>();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                EntityJobGrade EM = new EntityJobGrade();
                EM.setId(rs.getString(1));
                EM.setLowestSalary(rs.getInt(2));
                EM.setHighestSalary(rs.getInt(3));
                lb.add(EM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb; }

}
