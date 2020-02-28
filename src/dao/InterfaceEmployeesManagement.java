/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityEmployee;

/**
 *
 * @author amry4
 */
public interface InterfaceEmployeesManagement {
     public boolean insert(EntityEmployee EM);

    public boolean update(EntityEmployee EM);

    public boolean delete(int id);

    public List<EntityEmployee> getALL();
}
