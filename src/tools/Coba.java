/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.DaoRegionManagement;
import models.EntityRegion;

/**
 *
 * @author amry4
 */
public class Coba {

    public static void main(String[] args) {
        DaoRegionManagement drm = new DaoRegionManagement();
        for (EntityRegion region : drm.getALL()) {
            System.out.println(region.getName());

        }
    }
}