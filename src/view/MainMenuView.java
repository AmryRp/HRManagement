/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;

/**
 *
 * @author amry4
 */
public class MainMenuView extends javax.swing.JFrame {

    Color paneldefault;
    Color panelClicked;
    Color panelBG;

    public MainMenuView() {
        initComponents();
        paneldefault = new Color(240, 240, 240);
        panelClicked = new Color(0, 200, 200);
        PCountry.setBackground(paneldefault);
        PRegion.setBackground(paneldefault);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        PRegion = new javax.swing.JMenuItem();
        PCountry = new javax.swing.JMenuItem();
        PLocation = new javax.swing.JMenuItem();
        PDepartment = new javax.swing.JMenuItem();
        PJob = new javax.swing.JMenuItem();
        PEmployee = new javax.swing.JMenuItem();
        PJobHistory = new javax.swing.JMenuItem();
        PJobGrade = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HR MANAGEMENT");
        setIconImages(null);

        jPanel.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1163, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        PRegion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        PRegion.setText("Region");
        PRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRegionActionPerformed(evt);
            }
        });
        jMenu1.add(PRegion);

        PCountry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        PCountry.setText("Country");
        PCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCountryActionPerformed(evt);
            }
        });
        jMenu1.add(PCountry);

        PLocation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        PLocation.setText("Location");
        PLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLocationActionPerformed(evt);
            }
        });
        jMenu1.add(PLocation);

        PDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        PDepartment.setText("Department");
        PDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDepartmentActionPerformed(evt);
            }
        });
        jMenu1.add(PDepartment);

        PJob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        PJob.setText("Job");
        PJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PJobActionPerformed(evt);
            }
        });
        jMenu1.add(PJob);

        PEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        PEmployee.setText("Employee");
        PEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(PEmployee);

        PJobHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        PJobHistory.setText("Job History");
        PJobHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PJobHistoryActionPerformed(evt);
            }
        });
        jMenu1.add(PJobHistory);

        PJobGrade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        PJobGrade.setText("Job Grade");
        PJobGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PJobGradeActionPerformed(evt);
            }
        });
        jMenu1.add(PJobGrade);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRegionActionPerformed

        RegionView RV = new RegionView();
        RV.show();
        jPanel.add(RV);

    }//GEN-LAST:event_PRegionActionPerformed

    private void PCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCountryActionPerformed
        CountryView CV = new CountryView();
        CV.show();
        jPanel.add(CV);
    }//GEN-LAST:event_PCountryActionPerformed

    private void PLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLocationActionPerformed
//        LocInternalVIew LV = new LocInternalVIew();
//        LV.show();
//        jPanel.add(LV);
    }//GEN-LAST:event_PLocationActionPerformed

    private void PDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDepartmentActionPerformed
//        DepartmentInternalView DV = new DepartmentInternalView();
//        DV.show();
//        jPanel.add(DV);
    }//GEN-LAST:event_PDepartmentActionPerformed

    private void PJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PJobActionPerformed
//        JobInternalView JV = new JobInternalView();
//        JV.show();
//        jPanel.add(JV);
    }//GEN-LAST:event_PJobActionPerformed

    private void PEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PEmployeeActionPerformed
//        EmployeeInternalView EmpV = new EmployeeInternalView();
//        EmpV.show();
//        jPanel.add(EmpV);
    }//GEN-LAST:event_PEmployeeActionPerformed

    private void PJobHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PJobHistoryActionPerformed
//        JobHistoryInternalView JHV = new JobHistoryInternalView();
//        JHV.show();
//        jPanel.add(JHV);
    }//GEN-LAST:event_PJobHistoryActionPerformed

    private void PJobGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PJobGradeActionPerformed
//        JobGradeInternalView JGV = new JobGradeInternalView();
//        JGV.show();
//        jPanel.add(JGV);
    }//GEN-LAST:event_PJobGradeActionPerformed

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
//            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainMenuView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem PCountry;
    private javax.swing.JMenuItem PDepartment;
    private javax.swing.JMenuItem PEmployee;
    private javax.swing.JMenuItem PJob;
    private javax.swing.JMenuItem PJobGrade;
    private javax.swing.JMenuItem PJobHistory;
    private javax.swing.JMenuItem PLocation;
    private javax.swing.JMenuItem PRegion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}
