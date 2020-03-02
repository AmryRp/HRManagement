/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityDepartment;

/**
 *
 * @author amry4
 */
public interface InterfaceDepartmentManagement {

    public boolean insertOrUpdate(EntityDepartment ED, boolean isInsert);

    public boolean delete(int id);

    public String getById(int Id);

    public List<EntityDepartment> getALL();
    
    public List<EntityDepartment> getCari(String nama);
}
