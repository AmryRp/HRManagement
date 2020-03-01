/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoDepartmentManagement;
import dao.DaoEmployeeManagement;
import dao.DaoLocationManagement;
import dao.InterfaceDepartmentManagement;
import dao.InterfaceEmployeeManagement;
import dao.InterfaceLocationManagement;
import java.util.ArrayList;
import java.util.List;
import models.EntityDepartment;
import models.EntityEmployee;
import models.EntityLocation;
import views.DepartmentView;

/**
 *
 * @author amry4
 */
public class DepartmentController {

    public DepartmentController() {
    }
    DepartmentView deptview;
    List<EntityDepartment> ListDept;
    InterfaceDepartmentManagement IntrfcDM;

    List<EntityLocation> ListLoc;
    InterfaceLocationManagement IntrfcLM;

    InterfaceEmployeeManagement IntrfcEMM;
    List<EntityEmployee> ListEmpM;
    EntityDepartment ED = new EntityDepartment();

    public DepartmentController(DepartmentView CountryView) {
        this.deptview = CountryView;
        IntrfcDM = new DaoDepartmentManagement();
        ListDept = IntrfcDM.getALL();

        IntrfcLM = new DaoLocationManagement();
        ListLoc = IntrfcLM.getALL();
        
        IntrfcEMM = new DaoEmployeeManagement();
        ListEmpM = IntrfcEMM.getAllManager();
    }

    public String Save(String id, String name, String Manager, String Location, boolean isSave) {

        return (IntrfcDM.insertOrUpdate(new EntityDepartment(Integer.parseInt(id), name, getValueBoxLoc(Manager), getValueBoxLoc(Location)),
                isSave)) ? "sukses" : "failed";
    }

    public String delete(String id) {

        return (IntrfcDM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

    public String getById(int id) {

        return (new DaoDepartmentManagement().getById(id));
    }


    private ArrayList getValueFKLoc() {
        ListLoc = IntrfcLM.getALL();
        String[] regionName = new String[ListLoc.size()];
        int[] regionId = new int[ListLoc.size()];
        int i = 0;
        while (i < ListLoc.size()) {
            regionName[i] = ListLoc.get(i).getCity();
            regionId[i] = ListLoc.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(regionName);
        FK.add(regionId);
        return FK;
    }

    public int getValueBoxLoc(String Data) {
        String val = Data;
        int idLocation = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFKLoc();
        String[] locationName = new String[result.size()];
        Integer[] locationId = new Integer[result.size()];
        locationName = (String[]) result.get(0);
        for (int i = 0; i < locationName.length; i++) {
            if (val.equals(locationName[i])) {
               idLocation = locationId[i];
            }
        }
        return idLocation;
    }
     private ArrayList getValueFKMan() {
        ListEmpM = IntrfcEMM.getALL();
        String[] regionName = new String[ListEmpM.size()];
        int[] regionId = new int[ListEmpM.size()];
        int i = 0;
        while (i < ListEmpM.size()) {
            regionName[i] = ListEmpM.get(i).getLastName();
            regionId[i] = ListEmpM.get(i).getId();
            i++;
        }
        ArrayList FK = new ArrayList<String>();
        FK.add(regionName);
        FK.add(regionId);
        return FK;
    }

    public int getValueBoxMan(String Data) {
        String val = Data;
        int idLocation = -1;
        ArrayList result = new ArrayList<String>();
        result = getValueFKMan();
        String[] locationName = new String[result.size()];
        Integer[] locationId = new Integer[result.size()];
        locationName = (String[]) result.get(0);
        for (int i = 0; i < locationName.length; i++) {
            if (val.equals(locationName[i])) {
               idLocation = locationId[i];
            }
        }
        return idLocation;
    }
}
