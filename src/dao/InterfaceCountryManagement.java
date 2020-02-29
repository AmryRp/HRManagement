/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityCountry;

/**
 *
 * @author amry4
 */
public interface InterfaceCountryManagement {

    public boolean insertOrUpdate(EntityCountry EC, boolean isInsert);

    public boolean delete(String id);

    public List<EntityCountry> getALL();

    public String getById(String Id);

    public List<EntityCountry> getCariRegions(String nama);
}
