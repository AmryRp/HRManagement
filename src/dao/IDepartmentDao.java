/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Department;

/**
 *
 * @author amry4
 */
public interface IDepartmentDao {

    public boolean insertOrUpdate(Department R);

    public boolean delete(Department R);

    public List<Department> getAll();

    public List<Department> search(String R);

    public Department getById(int Id);
}
