/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adril_4v37cln
 */
public class User {
    
     private SimpleStringProperty login;
    /**
     * User's full name.
     */
     
     private SimpleStringProperty password;
     
     
         /**
     * Method that gets the login information of the user
     *
     * @return login the user's login
     */
    public String getLogin() {
        return this.login.get();
    }

    /**
     * Method that sets the users login
     *
     * @param login the user's login
     */
    public void setLogin(String login) {
        this.login.set(login);
    }

     
      @XmlTransient
    public String getPassword() {
        return this.password.get();
    }

    /**
     * Method that sets the password of the user
     *
     * @param password the password to be set
     */
    public void setPassword(String password) {
        this.password.set(password);
    }
     
    
}
