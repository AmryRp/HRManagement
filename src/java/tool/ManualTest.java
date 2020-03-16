/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

//import view.Login;
import tool.BCrypt;
import model.*;
import dao.GeneralDao;

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
        GeneralDao<Region> gd = new GeneralDao<Region>();
//        RegionDao drm = new RegionDao();
//        Login mainview = new Login();
//        mainview.setVisible(true);
//
//        
//    String pw_hash = BCrypt.hashpw("Bismillah", BCrypt.gensalt());
//        System.out.println(pw_hash);

//    BCrypt.checkpw(pw_hash, pw_hash);
        for (Region r : gd.manageData(new Region(), "regionName", "", "", false, true)) {
            System.out.println(r.getRegionName());
        }
    }
}
