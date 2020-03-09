/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CountryController;
import controller.LocationController;
import dao.CountryDao;
import dao.IGeneric;
import dao.LocationDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Country;
import model.Location;

/**
 *
 * @author amry4
 */
public class LocationView extends javax.swing.JInternalFrame {

    LocationController Lct;
    IGeneric<Location> IntrfcLM;
    List<Location> ListLocation;
    IGeneric<Country> IntrfcCM;
    List<Country> ListCountry;
    boolean isClicked = true;

    public LocationView() {
        initComponents();
        Lct = new LocationController();
        IntrfcLM = new LocationDao();
        ListLocation = IntrfcLM.getAll();
        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
        bindingTable(tblViewLocation);
        Fillcbox(CmbCountryId);
    }

    public void Fillcbox(JComboBox Jbox) {

        ListCountry = IntrfcCM.getAll();
        String[] countryId = new String[ListCountry.size()];
        String[] countryname = new String[ListCountry.size()];
        String[] countryIdName = new String[ListCountry.size()];
        int i = 0;
        while (i < ListCountry.size()) {
            countryId[i] = ListCountry.get(i).getCountryId();
            countryname[i] = ListCountry.get(i).getCountryName();
            countryIdName[i] = countryId[i] + " " + countryname[i];
            i++;
        }
        DefaultComboBoxModel tR = new DefaultComboBoxModel(countryIdName);
        getCmbCountryId().setModel(tR);
    }

    /**
     * this function used for store data from object using getall() function
     * from interface
     *
     * @param tabel is JTable datatype for referencing JTable that used for
     * showing data table
     */
    public void bindingTable(JTable tabel) {
        ListLocation = IntrfcLM.getAll();
        String[] tblHeader = new String[]{"id", "Address", "Postal Code",
            "City", "State Province", "Country Id"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[ListLocation.size()];
        while (dtm.getRowCount() < ListLocation.size()) {
            row[0] = ListLocation.get(dtm.getRowCount()).getLocationId();
            row[1] = ListLocation.get(dtm.getRowCount()).getStreetAddress();
            row[2] = ListLocation.get(dtm.getRowCount()).getPostalCode();
            row[3] = ListLocation.get(dtm.getRowCount()).getCity();
            row[4] = ListLocation.get(dtm.getRowCount()).getStateProvince();
            row[5] = (ListLocation.get(dtm.getRowCount()).getCountryId() == null)
                    ? "" : ListLocation.get(dtm.getRowCount()).getCountryId().getCountryId() + " "
                    + ListLocation.get(dtm.getRowCount()).getCountryId().getCountryName();
            dtm.addRow(row);
        }
        tblViewLocation.setModel(dtm);
    }

    /**
     * this function used for clearing table that used for refresh
     *
     * @param table is JTable datatype for referencing JTable that used for
     * showing data table
     */
    public void clearTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    /**
     * this function used for refreshing input fields
     */
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

    /**
     * this function used for checking empty field
     *
     * @return to boolean true or false
     */
    private boolean IsEmptyField() {
        return TxtLocationId.getText().trim().equals("");
    }

    /**
     * this function used for store data from object using search(keyword)
     * function from interface
     *
     * @param tabel is JTable datatype for referencing JTable that used for
     * showing data table
     * @param key is string datatype for search keyword
     */
    public void bindTblSearch(JTable tabel, String key) {
        ListLocation = IntrfcLM.search(key);
        String[] tblHeader = new String[]{"id", "name", "region"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[dtm.getColumnCount()];
        while (dtm.getRowCount() < ListLocation.size()) {
            row[0] = ListLocation.get(dtm.getRowCount()).getLocationId();
            row[1] = ListLocation.get(dtm.getRowCount()).getStreetAddress();
            row[2] = ListLocation.get(dtm.getRowCount()).getPostalCode();
            row[3] = ListLocation.get(dtm.getRowCount()).getCity();
            row[4] = ListLocation.get(dtm.getRowCount()).getStateProvince();
            row[5] = (ListLocation.get(dtm.getRowCount()).getCountryId() == null)
                    ? "" : ListLocation.get(dtm.getRowCount()).getCountryId().getCountryId() + " "
                    + ListLocation.get(dtm.getRowCount()).getCountryId().getCountryName();
            dtm.addRow(row);

        }

        tblViewLocation.setModel(dtm);

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
        BtnSearch = new javax.swing.JButton();
        TxtSearch = new javax.swing.JTextField();

        setClosable(true);
        setTitle("LOCATIONS MANAGEMENT");

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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Location id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Street Address");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Zip code");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("City");

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

        BtnSearch.setText("SEARCH");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        TxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertLoactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertLoactionActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {
            String[] space = CmbCountryId.getSelectedItem().toString().split(" ");
            JOptionPane.showMessageDialog(rootPane, Lct.Save(TxtLocationId.getText(),
                    TxtStreetAddress.getText(), TxtZipCode.getText(),
                    TxtCity.getText(), TxtProvince.getText(), space[0]));
            refresh();

        }
    }//GEN-LAST:event_btnInsertLoactionActionPerformed

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
    }//GEN-LAST:event_btnDeleteLocationActionPerformed

    private void tblViewLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewLocationMouseClicked

        DefaultTableModel dm = (DefaultTableModel) tblViewLocation.getModel();
        int row = tblViewLocation.getSelectedRow();
        TxtLocationId.setText(dm.getValueAt(row, 0).toString());
        TxtStreetAddress.setText(dm.getValueAt(row, 1).toString());
        String Temp2 = (dm.getValueAt(row, 2) == null) ? "" : dm.getValueAt(row, 2).toString();
        TxtZipCode.setText(Temp2);
        TxtCity.setText(dm.getValueAt(row, 3).toString());
        String Temp4 = (dm.getValueAt(row, 4) == null) ? "" : dm.getValueAt(row, 4).toString();
        TxtProvince.setText(Temp4);
        String Temp5 = (dm.getValueAt(row, 5) == null) ? "" : dm.getValueAt(row, 5).toString();
        CmbCountryId.setSelectedItem(Temp5);
        TxtLocationId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_tblViewLocationMouseClicked

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        bindTblSearch(tblViewLocation, TxtSearch.getText());
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JComboBox<String> CmbCountryId;
    private javax.swing.JTextField TxtCity;
    private javax.swing.JTextField TxtLocationId;
    private javax.swing.JTextField TxtProvince;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JTextField TxtStreetAddress;
    private javax.swing.JTextField TxtZipCode;
    private javax.swing.JButton btnDeleteLocation;
    private javax.swing.JButton btnInsertLoaction;
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

    public javax.swing.JTable getTblViewLocation() {
        return tblViewLocation;
    }
}
