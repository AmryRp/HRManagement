/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityLocation;

/**
 *
 * @author amry4
 */
public interface InterfaceLocationManagement {

    public boolean insertOrUpdate(EntityLocation EL, boolean isInsert);

    public boolean delete(int id);
    
    
    public String getById(int Id);

    public List<EntityLocation> getALL();

}
