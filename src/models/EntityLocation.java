/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author amry4
 */
public class EntityLocation {

    private Integer Id;
    private String Address;
    private String ZipCode;

    public EntityLocation() {
    }

    public EntityLocation(Integer Id, String Address, String ZipCode, String City, String Province, String idCountry) {
        this.Id = Id;
        this.Address = Address;
        this.ZipCode = ZipCode;
        this.City = City;
        this.Province = Province;
        this.idCountry = idCountry;
    }
    private String City;
    private String Province;
    private String idCountry;

    public Integer getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAdrress(String Address) {
        this.Address = Address;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCounty) {
        this.idCountry = idCounty;
    }

}
