/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import dao.RegionDao;
import java.math.BigDecimal;
import model.Region;
import view.MainMenuView;

/**
 *
 * @author amry4
 */
public class ManualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RegionDao drm = new RegionDao();
        MainMenuView mainview =  new MainMenuView();
        mainview.setVisible(true);

//       drm.delete(new Region("timor leste"));
//        for (Region region : drm.search("Asia")) {
//                System.out.println(region.getRegionId());
//                System.out.println(region.getRegionName());
//        }
//        
        
    }
}