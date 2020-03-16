/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Department;
import model.Employee;
import model.Location;
import dao.GeneralDao;
import dao.IDao;

/**
 *
 * @author amry4
 */
public class DepartmentController {

    List<Department> ListDept;
    IDao<Department> IDepartement;

    List< Location> ListLocation;
    IDao<Location> ILocation;

    List< Employee> ListEmployee;
    IDao<Employee> IEmployee;

    Department ED = new Department();
    Location ER = new Location();



    public DepartmentController() {
        IDepartement = new GeneralDao();
     
        ILocation = new GeneralDao();
        
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
        IDepartement = new GeneralDao();
        ILocation = new GeneralDao();

        return (IDepartement.manageData(new Department(new Short(Id), Name, new Employee(new Integer(managerId)), 
                new Location(new Short(locationId))),"","",new Short("0"),true,false) != null) ? "sukses" : "failed";

    }

    /**
     * delete function is used for deleting data from table
     * @param id is string datatype converted to short for deleting data
     * @return to String for delete from object Department
     */
    public String delete(String id) {
         IDepartement = new GeneralDao();
        return (IDepartement.manageData(new Department(),"","",new Integer(id),true,true) != null) ? "sukses" : "failed";

    }

    /**
     * this function used for confirm if id is not null
     *
     * @param id is Short Datatype
     * @return to boolean true or false
     */
    public boolean confirm(String id) {
        IDepartement = new GeneralDao();
        return (IDepartement.manageData(ED, "departmentId",id,"",false,false) != null);
    }
}
