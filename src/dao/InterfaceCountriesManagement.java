/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.EntityCountries;

/**
 *
 * @author amry4
 */
public interface InterfaceCountriesManagement {
     public boolean insert(EntityCountries EC);

    public boolean update(EntityCountries EC);

    public boolean delete(int id);

    public List<EntityCountries> getALL();

    public List<EntityCountries> getCariRegions(String nama);
}
