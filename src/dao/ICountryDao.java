/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import model.Country;

/**
 *
 * @author amry4
 */
public interface ICountryDao {

    public boolean insertOrUpdate(Country R);

    public boolean delete(Country R);

    public List<Country> getAll();

    public List<Country> search(String R);

    public String getById(Country R);

}
