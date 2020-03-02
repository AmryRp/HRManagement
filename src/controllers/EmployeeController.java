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
import java.time.LocalDate;
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
        ListEmpM = IntrfcEMM.getAllManager();
        IntrfcJM = new DaoJobManagement();
        ListJob = IntrfcJM.getALL();
        IntrfcDM = new DaoDepartmentManagement();
        ListDept = IntrfcDM.getALL();
    }

    public String Save(String id, String firstName, String lastName, String email,
            String phoneNumber, Date hireDate, String jobId, String Salary, String commision, String managerId, String deptId, boolean isSave) {

        return (IntrfcEM.insertOrUpdate(new EntityEmployee(Integer.parseInt(id), firstName, lastName, email, phoneNumber,
                hireDate, getValueBoxJob(jobId), Float.valueOf(Salary), Float.valueOf(commision), getValueBoxManager(managerId.toString()), getValueBoxDept(deptId.toString())),
                isSave)) ? "sukses" : "failed";
    }

    public String delete(String id) {
        return (IntrfcEM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

    public String getById(int id) {

        return (new DaoEmployeeManagement().getById(id));
    }

    private ArrayList getValueFKManager() {
        ListEmpM = IntrfcEMM.getAllManager();
        String[] mName = new String[ListEmpM.size()];
        int[] mId = new int[ListEmpM.size()];
        int i = 0;
        while (i < ListEmpM.size()) {
            mId[i] = ListEmpM.get(i).getId();
            mName[i] = ListEmpM.get(i).getLastName();

            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(mId);
        FK.add(mName);

        return FK;
    }

    public Integer getValueBoxManager(String Data) {
        String val = Data;
        int Id = 0;
        ArrayList result = new ArrayList<String>();
        ArrayList resultint = new ArrayList<Integer>();
        result = getValueFKManager();
        String[] region_name = new String[result.size()];
        int[] region_ID = new int[result.size()];
        region_ID = (int[]) result.get(0);
        region_name = (String[]) result.get(1);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                Id = region_ID[i];
            }
        }
        return Id;
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
        String idx = " ";
        ArrayList result = new ArrayList<String>();
        result = getValueFKJob();
        String[] region_name = new String[result.size()];
        String[] region_ID = new String[result.size()];
        region_ID = (String[]) result.get(1);
        region_name = (String[]) result.get(0);
        for (int i = 0; i < region_name.length; i++) {
            if (val.equals(region_name[i])) {
                idx = region_ID[i];
            }
        }
        return idx;
    }

    private ArrayList getValueFKDept() {
        ListDept = IntrfcDM.getALL();
        String[] mName = new String[ListDept.size()];
        int[] mId = new int[ListDept.size()];
        int i = 0;
        while (i < ListDept.size()) {
            mId[i] = ListDept.get(i).getId();
            mName[i] = ListDept.get(i).getName();

            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(mId);
        FK.add(mName);

        return FK;
    }

    public Integer getValueBoxDept(String Data) {
        String val = Data;
        int Id = 0;
        ArrayList result = new ArrayList<String>();
        ArrayList resultint = new ArrayList<Integer>();
        result = getValueFKDept();
        String[] dept_name = new String[result.size()];
        int[] dept_id = new int[result.size()];
        dept_id = (int[]) result.get(0);
        dept_name = (String[]) result.get(1);
        for (int i = 0; i < dept_name.length; i++) {
            if (val.equals(dept_name[i])) {
                Id = dept_id[i];
            }
        }
        return Id;
    }
}
