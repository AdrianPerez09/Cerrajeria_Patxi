/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adril_4v37cln
 */
public class User {

    private Long id;

    private SimpleStringProperty login;

    private SimpleStringProperty password;

    private SimpleStringProperty userPrivilege;

    private SimpleStringProperty fullName;

    private SimpleIntegerProperty phoneNumber;

    private SimpleStringProperty email;

    public User(Long id, SimpleStringProperty login, SimpleStringProperty password, SimpleStringProperty userPrivilege, SimpleStringProperty fullName, SimpleIntegerProperty phoneNumber, SimpleStringProperty email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userPrivilege =userPrivilege;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
        this.id = null;
        this.login = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.userPrivilege = new SimpleStringProperty();
        this.fullName = new SimpleStringProperty();
        this.phoneNumber = new SimpleIntegerProperty();
        this.email = new SimpleStringProperty();
    }


    public Integer getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getUserPrivilege() {
        return userPrivilege.get();
    }

    public void setUserPrivilege(String userPrivilege) {
        this.userPrivilege.set(userPrivilege);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

}
