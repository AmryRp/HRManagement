/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author amry4
 */
public class Connections {
    private Connection c = null;

    public Connection getC() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setServerName("localhost");
            dataSource.setServiceName("XE");
            dataSource.setPortNumber(1521);
            dataSource.setDriverType("thin");
            dataSource.setDatabaseName("HR");
            dataSource.setUser("system");
            dataSource.setPassword("040297");
            
            this.c = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return c;
    }
    
    
}
