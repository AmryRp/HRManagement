/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmployeeController;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.IGeneric;
import dao.JobDao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        ijm = new JobDao();
        idm = new DepartmentDao();
        bindingTable(TblEmployee);
        FillcboxM(cmbManId);
        FillcboxDept(cmbDepId);
        FillcboxJob(cmbJobId);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -30);
        Calendar then = Calendar.getInstance();
        then.add(Calendar.DATE, +30);
        dateChooserHire.setMinDate(now);
        dateChooserHire.setMaxDate(then);
        Calendar c = Calendar.getInstance();

    }

    EmployeeController Jct;
    List<Employee> ListEmployee;
    List<Job> ListJob;
    List<Department> ListDept;
    IGeneric<Employee> IntrfcEM;
    IGeneric<Department> idm;
    IGeneric<Job> ijm;
    boolean isClicked = true;

    /**
     * this function used for checking empty field
     *
     * @return to boolean true or false
     */
    private boolean IsEmptyField() {
        return TxtEmployeeId.getText().trim().equals("");
    }

    /**
     * this function used for refreshing input fields
     */
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
        cmbJobId.setSelectedItem("Choose Job");
        cmbManId.setSelectedItem("Choose Manager");
        cmbDepId.setSelectedItem("Choose Departement");
        TxtEmployeeId.setEditable(true);
        dateChooserHire.setEnabled(true);
        isClicked = true;
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
     * this function used for store data from object using getall() function
     * from interface
     *
     * @param tabel is JTable datatype for referencing JTable that used for
     * showing data table
     */
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
            SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yy");
            row[5] = hire.format(ListEmployee.get(dtm.getRowCount()).getHireDate());
            row[6] = (ListEmployee.get(dtm.getRowCount()).getJobId().getJobTitle() == null)
                    ? " " : ListEmployee.get(dtm.getRowCount()).getJobId().getJobId() + " "
                    + ListEmployee.get(dtm.getRowCount()).getJobId().getJobTitle();
            row[7] = ListEmployee.get(dtm.getRowCount()).getSalary();
            row[8] = ListEmployee.get(dtm.getRowCount()).getCommissionPct();
            row[9] = (ListEmployee.get(dtm.getRowCount()).getManagerId() == null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getManagerId().getEmployeeId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getManagerId().getLastName();
            row[10] = (ListEmployee.get(dtm.getRowCount()).getDepartmentId() == null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentName();
            dtm.addRow(row);
        }
        TblEmployee.setModel(dtm);
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
        ListEmployee = IntrfcEM.search(key);
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
            SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yy");
            row[5] = hire.format(ListEmployee.get(dtm.getRowCount()).getHireDate());
            row[6] = (ListEmployee.get(dtm.getRowCount()).getJobId().getJobTitle() == null)
                    ? " " : ListEmployee.get(dtm.getRowCount()).getJobId().getJobId() + " "
                    + ListEmployee.get(dtm.getRowCount()).getJobId().getJobTitle();
            row[7] = ListEmployee.get(dtm.getRowCount()).getSalary();
            row[8] = ListEmployee.get(dtm.getRowCount()).getCommissionPct();
            row[9] = (ListEmployee.get(dtm.getRowCount()).getManagerId() == null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getManagerId().getEmployeeId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getManagerId().getLastName();
            row[10] = (ListEmployee.get(dtm.getRowCount()).getDepartmentId() == null)
                    ? "" : ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentId()
                    + " " + ListEmployee.get(dtm.getRowCount()).getDepartmentId().getDepartmentName();
            dtm.addRow(row);
        }
        TblEmployee.setModel(dtm);
    }

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void FillcboxM(JComboBox Jbox) {

        ListEmployee = IntrfcEM.getAll();
        String[] Name = new String[ListEmployee.size()];
        int[] Id = new int[ListEmployee.size()];
        String[] ManIdName = new String[ListEmployee.size()];
        int i = 0;
        while (i < ListEmployee.size()) {
            Id[i] = (ListEmployee.get(i).getManagerId() == null) ? 0 : ListEmployee.get(i).getEmployeeId();
            Name[i] = (ListEmployee.get(i).getManagerId() == null) ? "" : ListEmployee.get(i).getLastName();
            ManIdName[i] = Id[i] + " " + Name[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(ManIdName);
        getCmbManId().setModel(dtm);
    }

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void FillcboxJob(JComboBox Jbox) {
        ListJob = ijm.getAll();
        String[] JobId = new String[ListJob.size()];
        String[] jobTittle = new String[ListJob.size()];
        String[] jobIdName = new String[ListJob.size()];
        int i = 0;
        while (i < ListJob.size()) {
            JobId[i] = ListJob.get(i).getJobId();
            jobTittle[i] = ListJob.get(i).getJobTitle();
            jobIdName[i] = JobId[i] + " " + jobTittle[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(jobIdName);
        getCmbJobId().setModel(dtm);
    }

    /**
     * this function for filing the model for combo box that used on
     *
     * @param Jbox is a datatype for j combo box
     */
    public void FillcboxDept(JComboBox Jbox) {
        ListDept = idm.getAll();
        Short[] deptId = new Short[ListDept.size()];
        String[] deptName = new String[ListDept.size()];
        String[] deptIdName = new String[ListDept.size()];
        int i = 0;
        while (i < ListDept.size()) {
            deptId[i] = ListDept.get(i).getDepartmentId();
            deptName[i] = ListDept.get(i).getDepartmentName();
            deptIdName[i] = deptId[i] + " " + deptName[i];
            i++;
        }
        DefaultComboBoxModel dtm = new DefaultComboBoxModel(deptIdName);
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
        cmbJobId = new javax.swing.JComboBox<>();
        cmbDepId = new javax.swing.JComboBox<>();
        cmbManId = new javax.swing.JComboBox<>();
        dateChooserHire = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEmployee = new javax.swing.JTable();
        BtnSearch = new javax.swing.JButton();
        TxtSearch = new javax.swing.JTextField();

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

        cmbJobId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Id", "item1", "item2" }));

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
                                        .addComponent(cmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(cmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap(439, Short.MAX_VALUE)
                .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(281, 281, 281))
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
            String[] split1 = cmbJobId.getSelectedItem().toString().split(" ");
            String[] split2 = cmbManId.getSelectedItem().toString().split(" ");
            String[] split3 = cmbDepId.getSelectedItem().toString().split(" ");
            JOptionPane.showMessageDialog(rootPane, Jct.save(TxtEmployeeId.getText(), TxtFirstName.getText(), TxtLastName.getText(), TxtEmail.getText(),
                    TxtPhoneNumber.getText(), dateChooserHire.getText(), split1[0], TxtSal.getText(),
                    TxtComP.getText(), split2[0], split3[0]));
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
        cmbJobId.setSelectedItem(dm.getValueAt(row, 6));
        TxtSal.setText(dm.getValueAt(row, 7).toString());
        String temp8 = (dm.getValueAt(row, 8) == null) ? "" : dm.getValueAt(row, 8).toString();
        TxtComP.setText(temp8);
        cmbManId.setSelectedItem(dm.getValueAt(row, 9));
        cmbDepId.setSelectedItem(dm.getValueAt(row, 10));
        TxtEmployeeId.setEditable(false);
        isClicked = false;
    }//GEN-LAST:event_TblEmployeeMouseClicked

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        bindTblSearch(TblEmployee, TxtSearch.getText());
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JPanel PEmployee;
    private javax.swing.JTable TblEmployee;
    private javax.swing.JTextField TxtComP;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtEmployeeId;
    private javax.swing.JTextField TxtFirstName;
    private javax.swing.JTextField TxtLastName;
    private javax.swing.JTextField TxtPhoneNumber;
    private javax.swing.JTextField TxtSal;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JButton btnDeleteEmp;
    private javax.swing.JButton btnInsertEmp;
    private javax.swing.JComboBox<String> cmbDepId;
    private javax.swing.JComboBox<String> cmbJobId;
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

    public javax.swing.JComboBox<String> getCmbJobId() {
        return cmbJobId;
    }

}
