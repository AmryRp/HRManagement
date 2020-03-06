/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Location;

/**
 *
 * @author amry4
 */
public interface ILocationDao {

    public boolean insertOrUpdate(Location l);

    public boolean delete(Location l);

    public List<Location> getAll();

    public List<Location> Search(Location l);

    public Location getById(int id);

}
