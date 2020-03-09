/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DepartmentController;
import controller.EmployeeController;
import controller.LocationController;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.IGeneric;
import dao.LocationDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Employee;
import model.Location;

/**
 *
 * @author amry4
 */
public class DepartmentlView extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepartmentInternalView
     */
    public DepartmentlView() {
        initComponents();
        Dct = new DepartmentController();
        idm = new DepartmentDao();
        ListDM = idm.getAll();
        ilm = new LocationDao();
        ListLM = ilm.getAll();
        iem = new EmployeeDao();
        ListEM = iem.getAll();
        bindingTable(TblDM);
        FillcboxM(CmbDMMan);
        FillcboxL(CmbDMLoc);

    }
    DepartmentController Dct;
    IGeneric<Department> idm;
    List<Department> ListDM;
    IGeneric<Employee> iem;
    List<Employee> ListEM;
    IGeneric<Location> ilm;
    List<Location> ListLM;
    boolean isClicked = true;

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void FillcboxM(JComboBox Jbox) {

        ListEM = iem.getAll();
        String[] Name = new String[ListEM.size()];
        int[] Id = new int[ListEM.size()];
        String[] ManIdName = new String[ListEM.size()];
        int i = 0;
        while (i < ListEM.size()) {
            Id[i] = (ListEM.get(i).getManagerId() == null) ? 0 : ListEM.get(i).getManagerId().getEmployeeId();
            Name[i] = (ListEM.get(i).getManagerId() == null) ? "" : ListEM.get(i).getManagerId().getLastName();
            ManIdName[i] = Id[i] + " " + Name[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(ManIdName);
        getCmbDMMan().setModel(dtm);
    }

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void FillcboxL(JComboBox Jbox) {

        ListLM = ilm.getAll();
        Short[] locId = new Short[ListLM.size()];
        String[] locationname = new String[ListLM.size()];
        String[] locIdName = new String[ListLM.size()];
        int i = 0;
        while (i < ListLM.size()) {
            locId[i] = ListLM.get(i).getLocationId();
            locationname[i] = ListLM.get(i).getCity();
            locIdName[i] = locId[i] + " " + locationname[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(locIdName);
        getCmbDMLoc().setModel(dtm);
    }

   /**
     * this function used for store data from object using getall() function
     * from interface
     *
     * @param tabel is JTable datatype for referencing JTable that used for
     * showing data table
     */
    public void bindingTable(JTable tabel) {
        ListDM = idm.getAll();
        String[] tblHeader = new String[]{"Department Id", "Department Name", "Manager", "Location"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[dtm.getColumnCount()];
        while (dtm.getRowCount() < ListDM.size()) {
            row[0] = ListDM.get(dtm.getRowCount()).getDepartmentId();
            row[1] = ListDM.get(dtm.getRowCount()).getDepartmentName();
            row[2] = (ListDM.get(dtm.getRowCount()).getManagerId() == null)
                    ? "" : ListDM.get(dtm.getRowCount()).getManagerId().getEmployeeId()
                    + " " + ListDM.get(dtm.getRowCount()).getManagerId().getLastName();
            row[3] = (ListDM.get(dtm.getRowCount()).getLocationId() == null) ? ""
                    : ListDM.get(dtm.getRowCount()).getLocationId().getLocationId() + " "
                    + ListDM.get(dtm.getRowCount()).getLocationId().getCity();
            dtm.addRow(row);
        }
        TblDM.setModel(dtm);
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
        ListDM = idm.search(key);
        String[] tblHeader = new String[]{"Department Id", "Department Name", "Manager", "Location"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[dtm.getColumnCount()];
        while (dtm.getRowCount() < ListDM.size()) {
            row[0] = ListDM.get(dtm.getRowCount()).getDepartmentId();
            row[1] = ListDM.get(dtm.getRowCount()).getDepartmentName();
            row[2] = (ListDM.get(dtm.getRowCount()).getManagerId() == null)
                    ? "" : ListDM.get(dtm.getRowCount()).getManagerId().getEmployeeId()
                    + " " + ListDM.get(dtm.getRowCount()).getManagerId().getLastName();
            row[3] = (ListDM.get(dtm.getRowCount()).getLocationId() == null) ? ""
                    : ListDM.get(dtm.getRowCount()).getLocationId().getLocationId() + " "
                    + ListDM.get(dtm.getRowCount()).getLocationId().getCity();
            dtm.addRow(row);
        }
        TblDM.setModel(dtm);
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
        clearTable(TblDM);
        bindingTable(TblDM);
        TxtDMId.setText("");
        TxtDMName.setText("");
        CmbDMLoc.setSelectedIndex(0);
        CmbDMMan.setSelectedIndex(0);
        TxtDMId.setEditable(true);
        isClicked = true;
    }

   /**
     * this function used for checking empty field
     *
     * @return to boolean true or false
     */
    private boolean IsEmptyField() {
        return TxtDMId.getText().trim().equals("");
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
        TxtDMId = new javax.swing.JTextField();
        TxtDMName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        CmbDMLoc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CmbDMMan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDM = new javax.swing.JTable();
        TxtSearch = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JButton();

        setClosable(true);
        setTitle("DEPARTMENT MANAGEMENT");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setText("Department Id");

        jLabel3.setText("Department Name");

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

        CmbDMLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Location", "item1", "item2" }));

        jLabel4.setText("Department Location");

        jLabel5.setText("Department Manager");

        CmbDMMan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Location", "item1", "item2" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(CmbDMMan, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(CmbDMLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(TxtDMId, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(TxtDMName, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TxtDMId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(TxtDMName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(CmbDMMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(CmbDMLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        TblDM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Department id", "Department Name", "Manager", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDM);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(272, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {
            String[] split1 = CmbDMMan.getSelectedItem().toString().split(" ");
            String[] split2 = CmbDMLoc.getSelectedItem().toString().split(" ");
            JOptionPane.showMessageDialog(rootPane, Dct.save(TxtDMId.getText(), TxtDMName.getText(), split1[0], split2[0]));
        }
        refresh();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!IsEmptyField()) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this data?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, Dct.delete(TxtDMId.getText()));
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TblDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDMMouseClicked
        DefaultTableModel dm = (DefaultTableModel) TblDM.getModel();
        int row = TblDM.getSelectedRow();
        TxtDMId.setText(dm.getValueAt(row, 0).toString());
        TxtDMName.setText(dm.getValueAt(row, 1).toString());
        String Temp3 = (dm.getValueAt(row, 2) == null) ? "" : dm.getValueAt(row, 2).toString();
        CmbDMMan.setSelectedItem(Temp3);
        String Temp2 = (dm.getValueAt(row, 3) == null) ? "" : dm.getValueAt(row, 3).toString();
        CmbDMLoc.setSelectedItem(Temp2);

        TxtDMId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_TblDMMouseClicked

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        bindTblSearch(TblDM, TxtSearch.getText());
    }//GEN-LAST:event_BtnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JComboBox<String> CmbDMLoc;
    private javax.swing.JComboBox<String> CmbDMMan;
    private javax.swing.JTable TblDM;
    private javax.swing.JTextField TxtDMId;
    private javax.swing.JTextField TxtDMName;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getCmbDMLoc() {
        return CmbDMLoc;
    }

    public JComboBox<String> getCmbDMMan() {
        return CmbDMMan;
    }

    public JTable getTblDM() {
        return TblDM;
    }

    public JTextField getTxtDMId() {
        return TxtDMId;
    }

    public JTextField getTxtDMName() {
        return TxtDMName;
    }
}
