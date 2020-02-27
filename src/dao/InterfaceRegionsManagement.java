/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.*;

/**
 *
 * @author amry4
 */
public interface InterfaceRegionsManagement {

    public boolean insert(EntityRegion Er);

    public boolean update(EntityRegion Er);

    public boolean delete(int id);

    public List<EntityRegion> getALL();

    public List<EntityRegion> getCariRegions(String nama);
}
