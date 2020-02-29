/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import controllers.LocationController;
import dao.DaoCountryManagement;
import dao.DaoLocationManagement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.EntityCountry;
import models.EntityLocation;
import dao.InterfaceCountryManagement;
import dao.InterfaceLocationManagement;

/**
 *
 * @author amry4
 */
public final class LocationView extends javax.swing.JFrame {

    public LocationView() {
        initComponents();
        Lct = new LocationController(this);
        IntrfcLM = new DaoLocationManagement();
        ListLocation = IntrfcLM.getALL();
        IntrfcCM = new DaoCountryManagement();
        ListCountry = IntrfcCM.getALL();
        bindingTable(tblViewLocation);
        Fillcbox(CmbCountryId);
        getValueBox();
    }
    LocationController Lct;
    InterfaceLocationManagement IntrfcLM;
    List<EntityLocation> ListLocation;
    List<EntityCountry> ListCountry;
    InterfaceCountryManagement IntrfcCM;
    boolean isClicked = true;

    private ArrayList getValueFK() {
        ListCountry = IntrfcCM.getALL();
        ArrayList FK = new ArrayList<String>();
        String[] countryname = new String[ListCountry.size()];
        int[] countryId = new int[ListCountry.size()];
        int i = 0;
        while (i < ListCountry.size()) {
            countryname[i] = ListCountry.get(i).getCountryName();
            countryId[i] = ListCountry.get(i).getRegionId();
            i++;
        }
        FK.add(countryname);
        FK.add(countryId);
        return FK;
    }

    public void Fillcbox(JComboBox Jbox) {

        ListCountry = IntrfcCM.getALL();
        String[] countryname = new String[ListCountry.size()];
        int[] countryId = new int[ListCountry.size()];
        int i = 0;
        while (i < ListCountry.size()) {
            countryname[i] = ListCountry.get(i).getCountryName();
            countryId[i] = ListCountry.get(i).getRegionId();
            i++;
        }
        DefaultComboBoxModel tR = new DefaultComboBoxModel(countryname);
        getCmbCountryId().setModel(tR);
    }

    public String getValueBox() {
        String val = getCmbCountryId().getSelectedItem().toString();
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFK();
        String[] region_name = new String[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }

        return val;
    }

    public void bindingTable(JTable tabel) {
        ListLocation = IntrfcLM.getALL();
        String[] tblHeader = new String[]{"id", "Address", "Postal Code",
            "City", "State Province", "Country Id"};
        DefaultTableModel tR = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[ListLocation.size()];
        while (tR.getRowCount() < ListLocation.size()) {
            row[0] = ListLocation.get(tR.getRowCount()).getId();
            row[1] = ListLocation.get(tR.getRowCount()).getAddress();
            row[2] = ListLocation.get(tR.getRowCount()).getZipCode();
            row[3] = ListLocation.get(tR.getRowCount()).getCity();
            row[4] = ListLocation.get(tR.getRowCount()).getProvince();
//            row[5] = ;
            row[5] = new CountryController().getById(ListLocation.get(tR.getRowCount()).getIdCountry());
            tR.addRow(row);
        }
        tblViewLocation.setModel(tR);
    }
     public void IdBind(JTable tabel) {
        ListLocation = IntrfcLM.getALL();
        DefaultTableModel tR = new DefaultTableModel();
        tabel.getModel();
        Object[] row;
        row = new Object[ListLocation.size()];
        while (tR.getRowCount() < ListLocation.size()) {
            row[0] = ListLocation.get(tR.getRowCount()).getId();
            tR.addRow(row);
        }
        tblViewLocation.setModel(tR);
    }
    public void clearTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    public void refresh() {
        clearTable(tblViewLocation);
        bindingTable(tblViewLocation);
        TxtLocationId.setText("");
        TxtCity.setText("");
        TxtStreetAddress.setText("");
        TxtZipCode.setText("");
        TxtProvince.setText("");
        CmbCountryId.setSelectedIndex(0);
        TxtLocationId.setEditable(true);
        isClicked = true;
    }

    private boolean IsEmptyField() {
        return TxtLocationId.getText().trim().equals("");
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
        btnInsertLoaction = new javax.swing.JButton();
        btnDeleteLocation = new javax.swing.JButton();
        TxtLocationId = new javax.swing.JTextField();
        TxtStreetAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtZipCode = new javax.swing.JTextField();
        TxtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtProvince = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CmbCountryId = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewLocation = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        btnInsertLoaction.setBackground(new java.awt.Color(51, 204, 255));
        btnInsertLoaction.setText("SAVE");
        btnInsertLoaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertLoactionActionPerformed(evt);
            }
        });

        btnDeleteLocation.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteLocation.setText("DELETE");
        btnDeleteLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLocationActionPerformed(evt);
            }
        });

        TxtLocationId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocationIdActionPerformed(evt);
            }
        });
        TxtLocationId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtLocationIdKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Location id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Street Address");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Zip code");

        TxtZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtZipCodeActionPerformed(evt);
            }
        });

        TxtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCityActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("City");

        TxtProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProvinceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Province");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Country");

        CmbCountryId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih country", "a", "b", "c" }));
        CmbCountryId.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(TxtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(TxtLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(49, 49, 49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(76, 76, 76)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(btnInsertLoaction, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CmbCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDeleteLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(CmbCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(TxtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertLoaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblViewLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location_id", "Street_address", "Postal_code", "City", "State_Province", "Country_id"
            }
        ));
        tblViewLocation.setPreferredSize(new java.awt.Dimension(907, 599));
        tblViewLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewLocationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewLocation);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("LOCATIONS MANAGEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(360, 360, 360))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblViewLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewLocationMouseClicked

        DefaultTableModel dm = (DefaultTableModel) tblViewLocation.getModel();
        int row = tblViewLocation.getSelectedRow();
        TxtLocationId.setText(dm.getValueAt(row, 0).toString());
        TxtStreetAddress.setText(dm.getValueAt(row, 1).toString());
        String Temp2 = (dm.getValueAt(row, 2)==null) ? "" : dm.getValueAt(row, 2).toString();
        TxtZipCode.setText(Temp2);
        TxtCity.setText(dm.getValueAt(row, 3).toString());
        String Temp4 = (dm.getValueAt(row, 4)==null) ? "" : dm.getValueAt(row, 4).toString();
        TxtProvince.setText(Temp4);
        CmbCountryId.setSelectedItem(dm.getValueAt(row, 5));
        TxtLocationId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_tblViewLocationMouseClicked

    private void btnDeleteLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLocationActionPerformed
        if (!IsEmptyField()) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this data?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, Lct.delete(TxtLocationId.getText()));
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        }
        bindingTable(tblViewLocation);
    }//GEN-LAST:event_btnDeleteLocationActionPerformed

    private void btnInsertLoactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertLoactionActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {
            JOptionPane.showMessageDialog(rootPane, Lct.Save(TxtLocationId.getText(),
                    TxtStreetAddress.getText(), TxtZipCode.getText(),
                    TxtCity.getText(), TxtProvince.getText(),
                    CmbCountryId.getSelectedItem().toString(), isClicked));
            refresh();

        }
        bindingTable(tblViewLocation);
    }//GEN-LAST:event_btnInsertLoactionActionPerformed

    private void TxtZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtZipCodeActionPerformed

    private void TxtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCityActionPerformed

    private void TxtProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtProvinceActionPerformed

    private void TxtLocationIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocationIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocationIdActionPerformed

    private void TxtLocationIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtLocationIdKeyTyped
       
    }//GEN-LAST:event_TxtLocationIdKeyTyped

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
//            java.util.logging.Logger.getLogger(LocationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LocationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LocationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LocationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LocationsView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbCountryId;
    private javax.swing.JTextField TxtCity;
    private javax.swing.JTextField TxtLocationId;
    private javax.swing.JTextField TxtProvince;
    private javax.swing.JTextField TxtStreetAddress;
    private javax.swing.JTextField TxtZipCode;
    private javax.swing.JButton btnDeleteLocation;
    private javax.swing.JButton btnInsertLoaction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblViewLocation;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getCmbCountryId() {
        return CmbCountryId;
    }

    public javax.swing.JTextField getTxtCity() {
        return TxtCity;
    }

    public javax.swing.JTextField getTxtLocationId() {
        return TxtLocationId;
    }

    public javax.swing.JTextField getTxtProvince() {
        return TxtProvince;
    }

    public javax.swing.JTextField getTxtStreetAddress() {
        return TxtStreetAddress;
    }

    public javax.swing.JTextField getTxtZipCode() {
        return TxtZipCode;
    }

    public javax.swing.JTable getTblViewLocation() {
        return tblViewLocation;
    }

}
