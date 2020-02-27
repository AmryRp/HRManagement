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
    private String Adrress;
    private String ZipCode;
    private String City;
    private String Province;
    private String idCounty;

    public Integer getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return Adrress;
    }

    public void setAdrress(String Adrress) {
        this.Adrress = Adrress;
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

    public String getIdCounty() {
        return idCounty;
    }

    public void setIdCounty(String idCounty) {
        this.idCounty = idCounty;
    }

}
