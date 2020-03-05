/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import model.Region;

/**
 *
 * @author amry4
 */
public interface IRegionDao {

    public boolean insertOrUpdate(Region R);

    public boolean delete(Region R);

    public List<Region> getAll(Region R);

    public List<Region> search(String R);

    public Region getById(BigDecimal r);

   
}
