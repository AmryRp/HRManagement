/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Employee;

/**
 *
 * @author amry4
 */
public interface IEmployeeDao {
    
    public boolean insertOrUpdate(Employee R);

    public boolean delete(int id);

    public List<Employee> getAll();
    public List<Employee> getManager();
    public List<Employee> search(Employee R);

    public Employee getById(int Id);
}
