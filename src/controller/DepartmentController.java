/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDao;
import dao.IGeneric;
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
    IGeneric<Department> IDepartement;

    List< Location> ListLocation;
    IGeneric<Location> ILocation;

    List< Employee> ListEmployee;
    IGeneric<Employee> IEmployee;

    Department EC = new Department();
    Location ER = new Location();

    public DepartmentController() {
    }

    public DepartmentController(DepartmentlView frame) {
        IDepartement = new DepartmentDao();
        ListDept = IDepartement.getAll();
        ILocation = new LocationDao();
        ListLocation = ILocation.getAll();
    }

    /**
     * This function is used for save,update or input data on table Department
     * @param Id is String Datatype for departmentId
     * @param Name is String Datatype for departmentName
     * @param managerId is String Datatype for managerId
     * @param locationId is String Datatype for locationId
     * @return to String for insertOrUpdate with object Department
     */
    public String save(String Id, String Name, String managerId, String locationId) {
        IDepartement = new DepartmentDao();
        ILocation = new LocationDao();

        return (IDepartement.insertOrUpdate(new Department(new Short(Id), Name, new Employee(managerId), new Location(new Short(locationId))))) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     * @param id is string datatype converted to short for deleting data
     * @return to String for delete from object Department
     */
    public String delete(String id) {
        return (IDepartement.delete(Short.parseShort(id))) ? "sukses" : "failed";

    }

    /**
     * this function used for search a data from table
     *
     * @param Name is String Datatype
     * @return to List Department
     */
    public List<Department> search(String Name) {
        IDepartement = new DepartmentDao();
        return IDepartement.search(Name);
    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(Short id) {
        IDepartement = new DepartmentDao();
        return (IDepartement.getById(id) != null);
    }
}
