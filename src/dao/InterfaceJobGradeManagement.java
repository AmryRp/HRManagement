/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityJobGrade;

/**
 *
 * @author amry4
 */
public interface InterfaceJobGradeManagement {

    public boolean insertOrUpdate(EntityJobGrade EJD, boolean isInsert);

    public boolean delete(String id);

    public List<EntityJobGrade> getALL();
}
