/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityJob;

/**
 *
 * @author amry4
 */
public interface InterfaceJobManagement {
     public boolean insertOrUpdate(EntityJob Ej, boolean isInsert);

    public boolean delete(String id);

    public List<EntityJob> getALL();
     public String getById(String Id);

}
