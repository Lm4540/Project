/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author pc
 */
public class Database {
    private String Driver;
    private String url;
    private String user;
    private String contra;

    public Database() {
        this.Driver="com.mysql.jdbc.Driver";
         this.url="jdbc:mysql://localhost:3306/agenda";
         this.user="root";
         this.contra="";
    }

    public String getDriver() {
        return Driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }
    
    
}
