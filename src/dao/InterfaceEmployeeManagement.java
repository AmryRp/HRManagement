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
public interface InterfaceEmployeeManagement {
    public boolean insertOrUpdate(EntityEmployee EM, boolean isInsert);

    public boolean delete(int id);

    public List<EntityEmployee> getALL();
}
