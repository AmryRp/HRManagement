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
public class EntityDepartment {
    private Integer id;
    private String name;
    private Integer managerId;
    private Integer locationId;

    public EntityDepartment() {
    }

    public EntityDepartment(Integer id, String name, Integer managerId, Integer locationId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}
