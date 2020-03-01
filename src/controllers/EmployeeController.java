/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoDepartmentManagement;
import dao.DaoEmployeeManagement;
import dao.DaoJobManagement;
import dao.InterfaceDepartmentManagement;
import dao.InterfaceEmployeeManagement;
import dao.InterfaceJobManagement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.EntityDepartment;
import models.EntityEmployee;
import models.EntityJob;
import views.EmployeeView;

/**
 *
 * @author amry4
 */
public class EmployeeController {

    EmployeeView EmpView;
    //Employee
    InterfaceEmployeeManagement IntrfcEM;
    List<EntityEmployee> ListEmp;
    //Manager
    InterfaceEmployeeManagement IntrfcEMM;
    List<EntityEmployee> ListEmpM;
    //Job
    InterfaceJobManagement IntrfcJM;
    List<EntityJob> ListJob;
    //Department
    InterfaceDepartmentManagement IntrfcDM;
    List<EntityDepartment> ListDept;

    EntityEmployee EM = new EntityEmployee();

    public EmployeeController() {
        
    }

    public EmployeeController(EmployeeView frame) {
        this.EmpView = frame;
        IntrfcEM = new DaoEmployeeManagement();
        ListEmp = IntrfcEM.getALL();
        IntrfcEMM = new DaoEmployeeManagement();
        ListEmpM = IntrfcEM.getAllManager();
        IntrfcJM = new DaoJobManagement();
        ListJob = IntrfcJM.getALL();
        IntrfcDM = new DaoDepartmentManagement();
        ListDept = IntrfcDM.getALL();
    }

    public String Save(String id, String firstName, String lastName, String email,
            String phoneNumber, String hireDate, String jobId, String Salary, String commision, String managerId, String deptId, boolean isSave) {

        return (IntrfcEM.insertOrUpdate(new EntityEmployee(Integer.parseInt(id), firstName, lastName, email, phoneNumber,
                Date.valueOf(hireDate), getValueBoxJob(jobId), Float.valueOf(Salary), Float.valueOf(commision), getValueBoxManager(managerId), getValueBoxDept(deptId)),
                isSave)) ? "sukses" : "failed";
    }

    public String delete(String id) {
        return (IntrfcEM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

    private ArrayList getValueFKManager() {
        ListEmpM = IntrfcEMM.getAllManager();
        String[] mName = new String[ListEmpM.size()];
        int[] mId = new int[ListEmpM.size()];
        int i = 0;
        while (i < ListEmpM.size()) {
            mName[i] = ListEmpM.get(i).getLastName();
            mId[i] = ListEmpM.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(mName);
        FK.add(mId);
        return FK;
    }

    public int getValueBoxManager(String Data) {
        String val = Data;
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFKManager();
        String[] region_name = new String[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }
        return idx;
    }

    private ArrayList getValueFKJob() {
        ListJob = IntrfcJM.getALL();
        String[] mName = new String[ListJob.size()];
        String[] mId = new String[ListJob.size()];
        int i = 0;
        while (i < ListJob.size()) {
            mName[i] = ListJob.get(i).getTitle();
            mId[i] = ListJob.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(mName);
        FK.add(mId);
        return FK;
    }

    public String getValueBoxJob(String Data) {
        String val = Data;
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFKJob();
        String[] region_name = new String[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }
        return val;
    }

    private ArrayList getValueFKDept() {
        ListDept = IntrfcDM.getALL();
        String[] mName = new String[ListDept.size()];
        int[] mId = new int[ListDept.size()];
        int i = 0;
        while (i < ListDept.size()) {
            mName[i] = ListDept.get(i).getName();
            mId[i] = ListDept.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(mName);
        FK.add(mId);
        return FK;
    }

    public int getValueBoxDept(String Data) {
        String val = Data;
        int idx = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFKDept();
        String[] region_name = new String[result.size()];
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = i + 1;
            }
        }
        return idx;
    }
}
