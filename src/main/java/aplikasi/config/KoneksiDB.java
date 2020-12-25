/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author dhiskar
 */
public class KoneksiDB {

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("");
        ds.setUrl("jdbc:mysql://localhost:3306/desa");
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        return ds;
    }
}
