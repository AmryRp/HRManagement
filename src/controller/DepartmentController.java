/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDao;
import dao.IDepartmentDao;
import dao.IEmployeeDao;
import dao.ILocationDao;
import dao.LocationDao;
import java.util.List;
import model.Department;
import model.Employee;
import model.Location;
import view.DepartmentlView;

/**
 *
 * @author amry4
 */
public class DepartmentController {
    DepartmentlView dv;
    List<Department> ListDept;
    IDepartmentDao  IDepartement;

    List< Location> ListLocation;
    ILocationDao  ILocation;
    
     List< Employee> ListEmployee;
    IEmployeeDao  IEmployee;
    
     Department EC = new  Department();
    Location ER = new  Location();
    public DepartmentController() {
    }

    public DepartmentController(DepartmentlView frame) {
        IDepartement = new DepartmentDao();
        ListDept = IDepartement.getAll();
        ILocation = new LocationDao();
        ListLocation = ILocation.getAll();
    }

    public String save(String Id, String Name, String managerId, String locationId) {
          IDepartement = new DepartmentDao();
          ILocation = new LocationDao();
         
        return (IDepartement.insertOrUpdate(new Department(new Short(Id),Name,new Employee(managerId),new Location(new Short(locationId)))))  ? "sukses" : "failed";

    }

    public String delete(String id) {

        return (IDepartement.delete(Short.parseShort(id))) ? "sukses" : "failed";

    }

    public List<Department> search(String Name) {
        IDepartement = new DepartmentDao();
        return IDepartement.search(Name);
    }
}
