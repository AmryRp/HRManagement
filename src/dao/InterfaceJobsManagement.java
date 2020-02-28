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
public interface InterfaceJobsManagement {
     public boolean insert(EntityJob Ej);

    public boolean update(EntityJob Ej);

    public boolean delete(String id);

    public List<EntityJob> getALL();

}
