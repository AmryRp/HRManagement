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
import dao.InterfaceLocationManagement;
import java.util.ArrayList;
import java.util.List;
import models.EntityDepartment;
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

    EntityDepartment ED = new EntityDepartment();

    public DepartmentController(DepartmentView CountryView) {
        this.deptview = CountryView;
        IntrfcDM = new DaoDepartmentManagement();
        ListDept = IntrfcDM.getALL();

        IntrfcLM = new DaoLocationManagement();
        ListLoc = IntrfcLM.getALL();
    }

    public String Save(String id, String name, String Manager, String Location, boolean isSave) {

        return (IntrfcDM.insertOrUpdate(new EntityDepartment(Integer.parseInt(id), name, getValueBox(Manager), getValueBox(Location)),
                isSave)) ? "sukses" : "failed";
    }

    public String delete(String id) {

        return (IntrfcDM.delete(Integer.parseInt(id))) ? "sukses" : "failed";

    }

    public Integer getByIdLocation(int id) {

        return (new DaoLocationManagement().getById(id));
    }

    public Integer getByIdManager(int id) {
        return (new DaoEmployeeManagement().getById(id));
    }

    private ArrayList getValueFK() {
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

    public int getValueBox(String Data) {
        String val = Data;
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
        return idx;
    }
}
