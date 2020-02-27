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
public class EntityJobGrade {
    private String id;
    private int lowestSalary;
    private int highestSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public int getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(int highestSalary) {
        this.highestSalary = highestSalary;
    }
}
