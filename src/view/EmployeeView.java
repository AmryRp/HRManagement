/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmployeeController;
import controller.JobController;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.IGeneric;
import dao.JobDao;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Employee;
import model.Job;

/**
 *
 * @author amry4
 */
public class EmployeeView extends javax.swing.JInternalFrame {

     
    /**
     * Creates new form EmployeeView
     */
    public EmployeeView() {
        initComponents();
         Jct = new EmployeeController();
        IntrfcEM = new EmployeeDao();
        ListEmployee = IntrfcEM.getAll();
        IntrfcEMM = new EmployeeDao();
        ListEmpM = IntrfcEMM.getAll();
        ijm = new JobDao();
        idm = new DepartmentDao();
        bindingTable(TblEmployee);
        FillcboxManager(cmbManId);
        FillcboxDept(cmbDepId);
        FillcboxJob(CmbJobId);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE,-30);
        Calendar then = Calendar.getInstance();
        then.add(Calendar.DATE,+30);
        dateChooserHire.setMinDate(now);
        dateChooserHire.setMaxDate(then);
        Calendar c = Calendar.getInstance();
        
    }
    
    
        EmployeeController Jct;
    List<Employee> ListEmployee;
    List<Employee> ListEmpM;
    List<Job> ListJob;
    List<Department> ListDept;
    IGeneric<Employee, Integer, String> IntrfcEM;
    IGeneric<Employee, Integer, String> IntrfcEMM;
    IGeneric<Department, Short, String> idm;
    IGeneric<Job, String, String> ijm;
    boolean isClicked = true;
    
    /**
     * Creates new form JobsManager
     */
   private boolean IsEmptyField() {
        return TxtEmployeeId.getText().trim().equals("");
    }

   

    public void refresh() {
        clearTable(TblEmployee);
        bindingTable(TblEmployee);
        TxtEmployeeId.setText("");
        TxtFirstName.setText("");
        TxtLastName.setText("");
        TxtSal.setText("");
        TxtEmail.setText("");
        TxtPhoneNumber.setText("");
        dateChooserHire.setText("");
        CmbJobId.setSelectedItem("Choose Job");
        cmbManId.setSelectedItem("Choose Manager");
        cmbDepId.setSelectedItem("Choose Departement");
        TxtEmployeeId.setEditable(true);
        dateChooserHire.setEnabled(true);
        isClicked = true;
    }

    public void clearTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    public void bindingTable(JTable tabel) {
        ListEmployee = IntrfcEM.getAll();
        String[] tblHeader = new String[]{"id", "first name", "last name", "Email",
            "phone Number", "HireDate", "Job", "Salary", "Commission", "Manager", "Department"};
        DefaultTableModel dtm = new DefaultTableModel(null, tblHeader);
        tabel.getModel();
        Object[] row;
        row = new Object[ListEmployee.size()];
        while (dtm.getRowCount() < ListEmployee.size()) {
            row[0] = ListEmployee.get(dtm.getRowCount()).getEmployeeId();
            row[1] = ListEmployee.get(dtm.getRowCount()).getFirstName();
            row[2] = ListEmployee.get(dtm.getRowCount()).getLastName();
            row[3] = ListEmployee.get(dtm.getRowCount()).getEmail();
            row[4] = ListEmployee.get(dtm.getRowCount()).getPhoneNumber();
            row[5] = ListEmployee.get(dtm.getRowCount()).getHireDate();
            row[6] = ListEmployee.get(dtm.getRowCount()).getJobId().getJobTitle();
            row[7] = ListEmployee.get(dtm.getRowCount()).getSalary();
            row[8] = ListEmployee.get(dtm.getRowCount()).getCommissionPct();
            row[9] = (ListEmployee.get(dtm.getRowCount()).getManagerId() == null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getManagerId().getEmployeeId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getManagerId().getLastName();
            row[10] = (ListEmployee.get(dtm.getRowCount()).getDepartmentId()== null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentName();
            dtm.addRow(row);
        }
        TblEmployee.setModel(dtm);
    }

    public void FillcboxManager(JComboBox Jbox) {
        ListEmpM = IntrfcEMM.getAll();
        int[] managerId = new int[ListEmpM.size()];
        String[] managerName = new String[ListEmpM.size()];
        String[] manIdName= new String[ListEmpM.size()];
        int i = 0;
        while (i < ListEmpM.size()) {
            managerName[i] =(ListEmpM.get(i).getManagerId() == null) ? "" : ListEmpM.get(i).getManagerId().getLastName();
            managerId[i] = (ListEmpM.get(i).getManagerId() == null) ? 0 : ListEmpM.get(i).getManagerId().getEmployeeId();
            manIdName[i] = managerId[i]+" "+manIdName[i]; 
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(manIdName);
        getCmbManId().setModel(dtm);

    }

    public void FillcboxJob(JComboBox Jbox) {
        ListJob = ijm.getAll();
        String[] managerName = new String[ListJob.size()];
        int i = 0;
        while (i < ListJob.size()) {
            managerName[i] = ListJob.get(i).getJobTitle();
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(managerName);
        getCmbDepId().setModel(dtm);
    }

    public void FillcboxDept(JComboBox Jbox) {
        ListDept = idm.getAll();
        String[] managerName = new String[ListDept.size()];
        int i = 0;
        while (i < ListDept.size()) {
            managerName[i] = ListDept.get(i).getDepartmentName();
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(managerName);
        getCmbDepId().setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PEmployee = new javax.swing.JPanel();
        btnInsertEmp = new javax.swing.JButton();
        btnDeleteEmp = new javax.swing.JButton();
        TxtPhoneNumber = new javax.swing.JTextField();
        TxtLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtEmployeeId = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        TxtFirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtSal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtComP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CmbJobId = new javax.swing.JComboBox<>();
        cmbDepId = new javax.swing.JComboBox<>();
        cmbManId = new javax.swing.JComboBox<>();
        dateChooserHire = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEmployee = new javax.swing.JTable();

        PEmployee.setBackground(new java.awt.Color(204, 255, 204));
        PEmployee.setPreferredSize(new java.awt.Dimension(451, 300));

        btnInsertEmp.setBackground(new java.awt.Color(51, 204, 255));
        btnInsertEmp.setText("SAVE");
        btnInsertEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertEmpActionPerformed(evt);
            }
        });

        btnDeleteEmp.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteEmp.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteEmp.setText("DELETE");
        btnDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmpActionPerformed(evt);
            }
        });

        jLabel2.setText("Last Name");

        jLabel3.setText("First Name");

        jLabel4.setText("Email");

        jLabel5.setText("Employee Id");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Hire Date");

        jLabel8.setText("Job Id");

        jLabel9.setText("Salary");

        jLabel10.setText("Comission");

        jLabel11.setText("Manager Id");

        jLabel12.setText("Department Id");

        CmbJobId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Id", "item1", "item2" }));

        cmbDepId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Id", "item1", "item2" }));

        cmbManId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Id", "item1", "item2" }));

        javax.swing.GroupLayout PEmployeeLayout = new javax.swing.GroupLayout(PEmployee);
        PEmployee.setLayout(PEmployeeLayout);
        PEmployeeLayout.setHorizontalGroup(
            PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PEmployeeLayout.createSequentialGroup()
                            .addComponent(btnInsertEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnDeleteEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PEmployeeLayout.createSequentialGroup()
                            .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PEmployeeLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(32, 32, 32)
                                    .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PEmployeeLayout.createSequentialGroup()
                                            .addComponent(TxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel2))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PEmployeeLayout.createSequentialGroup()
                                    .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateChooserHire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addComponent(TxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addGap(18, 18, 18)
                            .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtSal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtComP, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbManId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbDepId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        PEmployeeLayout.setVerticalGroup(
            PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PEmployeeLayout.createSequentialGroup()
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtComP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbManId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbDepId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(PEmployeeLayout.createSequentialGroup()
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(TxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dateChooserHire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(CmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        TblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee id", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job id", "Salary", "Commision", "Manager", "Department"
            }
        ));
        TblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblEmployee);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PEmployee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertEmpActionPerformed
        if (IsEmptyField()) {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        } else {
            JOptionPane.showMessageDialog(rootPane, Jct.save(TxtEmployeeId.getText(), TxtFirstName.getText(),TxtLastName.getText(), TxtEmail.getText(),
                TxtPhoneNumber.getText(),dateChooserHire.getText(), CmbJobId.getSelectedItem().toString(), TxtSal.getText(),
                TxtComP.getText(), cmbManId.getSelectedItem().toString(), cmbDepId.getSelectedItem().toString()));
        refresh();
        }
    }//GEN-LAST:event_btnInsertEmpActionPerformed

    private void btnDeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmpActionPerformed
        if (!IsEmptyField()) {
            int result = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this data?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, Jct.delete(TxtEmployeeId.getText()));
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "fill id");
        }
    }//GEN-LAST:event_btnDeleteEmpActionPerformed

    private void DateChooserHireOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_DateChooserHireOnCommit
        System.out.println(dateChooserHire.getText());
    }//GEN-LAST:event_DateChooserHireOnCommit

    private void TblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblEmployeeMouseClicked
        DefaultTableModel dm = (DefaultTableModel) TblEmployee.getModel();
        int row = TblEmployee.getSelectedRow();
        TxtEmployeeId.setText(dm.getValueAt(row, 0).toString());
        TxtFirstName.setText(dm.getValueAt(row, 1).toString());
        TxtLastName.setText(dm.getValueAt(row, 2).toString());
        TxtEmail.setText(dm.getValueAt(row, 3).toString());
        TxtPhoneNumber.setText(dm.getValueAt(row, 4).toString());
        dateChooserHire.setText(dm.getValueAt(row, 5).toString());
        CmbJobId.setSelectedItem(dm.getValueAt(row, 6));
        TxtSal.setText(dm.getValueAt(row, 7).toString());
        TxtComP.setText(dm.getValueAt(row, 8).toString());
        cmbManId.setSelectedItem(dm.getValueAt(row, 9));
        cmbDepId.setSelectedItem(dm.getValueAt(row, 10));
        TxtEmployeeId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_TblEmployeeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbJobId;
    private javax.swing.JPanel PEmployee;
    private javax.swing.JTable TblEmployee;
    private javax.swing.JTextField TxtComP;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtEmployeeId;
    private javax.swing.JTextField TxtFirstName;
    private javax.swing.JTextField TxtLastName;
    private javax.swing.JTextField TxtPhoneNumber;
    private javax.swing.JTextField TxtSal;
    private javax.swing.JButton btnDeleteEmp;
    private javax.swing.JButton btnInsertEmp;
    private javax.swing.JComboBox<String> cmbDepId;
    private javax.swing.JComboBox<String> cmbManId;
    private datechooser.beans.DateChooserCombo dateChooserHire;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTblEmployee() {
        return TblEmployee;
    }

    public javax.swing.JTextField getTxtComP() {
        return TxtComP;
    }

    public javax.swing.JTextField getTxtEmail() {
        return TxtEmail;
    }

    public javax.swing.JTextField getTxtEmployeeId() {
        return TxtEmployeeId;
    }

    public javax.swing.JTextField getTxtFirstName() {
        return TxtFirstName;
    }

    public javax.swing.JTextField getTxtLastName() {
        return TxtLastName;
    }

    public javax.swing.JTextField getTxtPhoneNumber() {
        return TxtPhoneNumber;
    }

    public javax.swing.JTextField getTxtSal() {
        return TxtSal;
    }

    public javax.swing.JComboBox<String> getCmbDepId() {
        return cmbDepId;
    }

    public javax.swing.JComboBox<String> getCmbManId() {
        return cmbManId;
    }

    public datechooser.beans.DateChooserCombo getDateChooserHire() {
        return dateChooserHire;
    }
}
