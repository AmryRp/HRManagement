/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import dao.GeneralDao;
import dao.IDao;
import java.math.BigDecimal;
import java.util.List;
import model.Useraccount;

/**
 *
 * @author amry4
 */
public class LoginController {
    List<Useraccount> ListAccount;
    IDao<Useraccount> IAccount;
    Useraccount ua = new Useraccount();

    public LoginController() {
    IAccount = new GeneralDao();
    
    }

    public String getPassword(String username){
        IAccount = new GeneralDao();
    return (IAccount.manageData(new Useraccount(),"username",username,new BigDecimal("0"),false,false) != null) ? "sukses" : "failed";
    }
    
}
