/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import dao.DaoCountryManagement;
import dao.DaoRegionManagement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.EntityCountry;
import dao.InterfaceCountryManagement;
import dao.InterfaceRegionManagement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import models.EntityRegion;

/**
 *
 * @author amry4
 */
public class CountryView extends javax.swing.JFrame {

    CountryController cct;
    InterfaceCountryManagement IntrfcCM;
    List<EntityCountry> ListCountry;
    List<EntityRegion> ListRegion;
    InterfaceRegionManagement IntrfcRM;
    boolean isClicked = true;
    int idxcmb;

    /**
     * Creates new form CountriesManagement
     */
    public CountryView() {
        initComponents();
        cct = new CountryController(this);
        IntrfcRM = new DaoRegionManagement();
        ListRegion = IntrfcRM.getALL();
        IntrfcCM = new DaoCountryManagement();
        ListCountry = IntrfcCM.getALL();
        bindingTable(TblCountries);
        Fillcbox(CmbRegionId);

    }

    public void Fillcbox(JComboBox Jbox) {
        ListRegion = IntrfcRM.getALL();
        String[] regionName = new String[ListRegion.size()];
        int[] regionId = new int[ListRegion.size()];
        int i = 0;
        while (i < ListRegion.size()) {
            regionName[i] = ListRegion.get(i).getName();
            regionId[i] = ListRegion.get(i).getId();
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(regionName);
        getCmbRegionId().setModel(dtm);

    }

    public void bindingTable(JTable tabel) {
        ListCountry = IntrfcCM.getALL();
        String[] tblHeader = new String[]{"id", "Country name", "Region Id"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[ListCountry.size()];
        while (dtm.getRowCount() < ListCountry.size()) {
            row[0] = ListCountry.get(dtm.getRowCount()).getId();
            row[1] = ListCountry.get(dtm.getRowCount()).getCountryName();
            row[2] = ListCountry.get(dtm.getRowCount()).getRegionId();
            dtm.addRow(row);
        }
        TblCountries.setModel(dtm);

    }

    private boolean IsEmptyField() {
        return TxtCountryId.getText().trim().equals("");
    }

    public void clearTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    public void refresh() {
        clearTable(TblCountries);
        bindingTable(TblCountries);
        TxtCountryId.setText("");
        TxtCountryName.setText("");
        CmbRegionId.setSelectedItem("Pilih Region");
        TxtCountryId.setEditable(true);
        isClicked = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCountryId = new javax.swing.JTextField();
        TxtCountryName = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        CmbRegionId = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCountries = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(907, 599));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setText("Country Id");

        jLabel3.setText("Country Name");

        jLabel4.setText("Region id");

        btnInsert.setBackground(new java.awt.Color(51, 204, 255));
        btnInsert.setText("SAVE");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        CmbRegionId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CmbRegionIdMousePressed(evt);
            }
        });
        CmbRegionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbRegionIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TxtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CmbRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CmbRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        TblCountries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Country_id", "Country_nam", "Region_id"
            }
        ));
        TblCountries.setToolTipText("");
        TblCountries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblCountriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblCountries);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("COUNTRIES MANAGEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(266, 266, 266))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {

            JOptionPane.showMessageDialog(rootPane, cct.Save(TxtCountryId.getText(),
                    TxtCountryName.getText(), CmbRegionId.getSelectedItem().toString(),
                    isClicked));
        }
        refresh();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!IsEmptyField()) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this data?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, cct.delete(TxtCountryId.getText()));
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        }
        bindingTable(TblCountries);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void CmbRegionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbRegionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbRegionIdActionPerformed

    private void TblCountriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCountriesMouseClicked
        DefaultTableModel dm = (DefaultTableModel) TblCountries.getModel();
        int row = TblCountries.getSelectedRow();
        TxtCountryId.setText(dm.getValueAt(row, 0).toString());
        TxtCountryName.setText(dm.getValueAt(row, 1).toString());
        CmbRegionId.setSelectedIndex((int) dm.getValueAt(row, 2) - 1);
        TxtCountryId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_TblCountriesMouseClicked

    private void CmbRegionIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbRegionIdMousePressed
      
    }//GEN-LAST:event_CmbRegionIdMousePressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CountriesView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbRegionId;
    private javax.swing.JTable TblCountries;
    private javax.swing.JTextField TxtCountryId;
    private javax.swing.JTextField TxtCountryName;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getCmbRegionId() {
        return CmbRegionId;
    }

    public javax.swing.JTable getTblCountries() {
        return TblCountries;
    }

    public javax.swing.JTextField getTxtCountryId() {
        return TxtCountryId;
    }

    public javax.swing.JTextField getTxtCountryName() {
        return TxtCountryName;
    }

}