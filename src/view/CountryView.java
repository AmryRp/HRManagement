/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CountryController;
import dao.CountryDao;
import dao.RegionDao;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Country;
import model.Region;
import dao.IGeneric;

/**
 * This class for view Country that used for input and output that user use.
 *
 * @author amry4
 */
public class CountryView extends javax.swing.JInternalFrame {

    Country EC = new Country();
    Region ER = new Region();
    CountryController cct;
    IGeneric<Country> IntrfcCM;
    List<Country> ListCountry;
    List<Region> ListRegion;
    IGeneric<Region> IntrfcRM;
    boolean isClicked = true;
    int idxcmb;

    /**
     *
     */
    public CountryView() {
        initComponents();
        cct = new CountryController();
        IntrfcRM = new RegionDao();
        ListRegion = IntrfcRM.getAll();
        IntrfcCM = new CountryDao();
        ListCountry = IntrfcCM.getAll();
        bindingTable(TblCountries);
        Fillcbox(CmbRegionId);

    }

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void Fillcbox(JComboBox Jbox) {
        ListRegion = IntrfcRM.getAll();
        String[] regionName = new String[ListRegion.size()];
        BigDecimal[] regionId = new BigDecimal[ListRegion.size()];
        String[] RegionsList = new String[ListRegion.size()];
        int i = 0;
        while (i < ListRegion.size()) {
            regionName[i] = ListRegion.get(i).getRegionName();
            regionId[i] = ListRegion.get(i).getRegionId();
            RegionsList[i] = regionId[i] + " " + regionName[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(RegionsList);
        getCmbRegionId().setModel(dtm);

    }

    /**
     * this function used for store data from object using getall() function
     * from interface
     *
     * @param tabel is JTable datatype for referencing JTable that used for
     * showing data table
     */
    public void bindingTable(JTable tabel) {
        ListCountry = IntrfcCM.getAll();
        String[] tblHeader = new String[]{"id", "Country name", "Region Id"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[dtm.getColumnCount()];
        while (dtm.getRowCount() < ListCountry.size()) {
            row[0] = ListCountry.get(dtm.getRowCount()).getCountryId();
            row[1] = ListCountry.get(dtm.getRowCount()).getCountryName();
            row[2] = (ListCountry.get(dtm.getRowCount()).getRegionId() == null)
                    ? "" : ListCountry.get(dtm.getRowCount()).getRegionId().getRegionId()
                    + " " + ListCountry.get(dtm.getRowCount()).getRegionId().getRegionName();
            dtm.addRow(row);
        }
        TblCountries.setModel(dtm);

    }

    /**
     * this function used for checking empty field
     *
     * @return to boolean true or false
     */
    private boolean IsEmptyField() {
        return TxtCountryId.getText().trim().equals("");
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
        clearTable(TblCountries);
        bindingTable(TblCountries);
        TxtCountryId.setText("");
        TxtCountryName.setText("");
        CmbRegionId.setSelectedItem("Pilih Region");
        TxtCountryId.setEditable(true);
        isClicked = true;
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
        ListCountry = IntrfcCM.search(key);
        String[] tblHeader = new String[]{"id", "name", "region"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[dtm.getColumnCount()];
        while (dtm.getRowCount() < ListCountry.size()) {
            row[0] = ListCountry.get(dtm.getRowCount()).getCountryId();
            row[1] = ListCountry.get(dtm.getRowCount()).getCountryName();
            row[2] = (ListCountry.get(dtm.getRowCount()).getRegionId() == null)
                    ? "" : ListCountry.get(dtm.getRowCount()).getRegionId().getRegionId() + " " + ListCountry.get(dtm.getRowCount()).getRegionId().getRegionName();
            dtm.addRow(row);

        }

        TblCountries.setModel(dtm);

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
        TxtSearch = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JButton();
        jBtnReport = new javax.swing.JButton();

        setClosable(true);
        setTitle("COUNTRY MANAGEMENT");

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

        TxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchActionPerformed(evt);
            }
        });

        BtnSearch.setText("SEARCH");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        jBtnReport.setText("Print Data");
        jBtnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnReport, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(jBtnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {
            String[] space = CmbRegionId.getSelectedItem().toString().split(" ");
            JOptionPane.showMessageDialog(rootPane, cct.Save(TxtCountryId.getText(),
                    TxtCountryName.getText(), space[0]));
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

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void CmbRegionIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmbRegionIdMousePressed

    }//GEN-LAST:event_CmbRegionIdMousePressed

    private void CmbRegionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbRegionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbRegionIdActionPerformed

    private void TblCountriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCountriesMouseClicked
        DefaultTableModel dm = (DefaultTableModel) TblCountries.getModel();
        int row = TblCountries.getSelectedRow();
        TxtCountryId.setText(dm.getValueAt(row, 0).toString());
        TxtCountryName.setText(dm.getValueAt(row, 1).toString());
        String Temp2 = (dm.getValueAt(row, 2) == null) ? "" : dm.getValueAt(row, 2).toString();
        CmbRegionId.setSelectedItem(Temp2);
        TxtCountryId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_TblCountriesMouseClicked

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        bindTblSearch(TblCountries, TxtSearch.getText());
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchActionPerformed

    private void jBtnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReportActionPerformed
//        try {
//            MainMenuView Main = new MainMenuView();
//            Report();
//        } catch (JRException ex) {
//            Logger.getLogger(CountryView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(CountryView.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        NewReport PR = new NewReport();
//        PR.show();
//        jPanel1.add(PR);
//        MainMenuView MM = new MainMenuView();
//        MM.showReport();
//        MM.getjPanel().add(PR);
//        MM.getjPanel().revalidate();

    }//GEN-LAST:event_jBtnReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JComboBox<String> CmbRegionId;
    private javax.swing.JTable TblCountries;
    private javax.swing.JTextField TxtCountryId;
    private javax.swing.JTextField TxtCountryName;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton jBtnReport;
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
