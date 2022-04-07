package model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Entity representing users. Contains basic personal data, identification
 *
 * @author Yeray Sampedro
 */
@XmlRootElement
public class Person implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
     * Identification field for user.
     */

    private Long id;

    /**
     * User's full name.
     */
    private SimpleStringProperty name;
    /**
     * User's password.
     */
    
      private SimpleStringProperty surnames;
    /**
     * User's password.
     */
    

    /**
     * User's email.
     */
    private SimpleStringProperty email;
    /**
     * User's birth date.
     */



    public Person(Long id, SimpleStringProperty name, SimpleStringProperty surnames, SimpleStringProperty email) {
        this.id = id;
        this.name = name;
        this.surnames =surnames;
        this.email = email;
       

    }

    public Person() {
        this.id = null;
        this.name= new  SimpleStringProperty();
        this.surnames = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        
    }

    /**
     * Method that gets the identification of the User
     *
     * @return id the identification number
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Method that sets the identification of the user
     *
     * @param id the identification number to be set
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Method that gets the user's full name
     *
     * @return fullName the user's full name
     */
    public String getName() {
        return this.name.get();
    }

    /**
     * Method that sets the user's full name
     *
     * @param fullName the full name to be set
     */
    public void setName(String name) {
        this.name.set(name);
    }
    
    public String getSurnames() {
        return this.surnames.get();
    }

    /**
     * Method that sets the user's full name
     *
     * @param fullName the full name to be set
     */
    public void setSurnames(String surnames) {
        this.surnames.set(surnames);
    }


    /**
     * Method that gets the email of a user
     *
     * @return email the email to get
     */
    public String getEmail() {
        return this.email.get();
    }

    /**
     * Method that sets the email of the user
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email.set(email);
    }


    /**
     * Integer representation for Person instance.
     *
     * @return the hashcode value
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares two User objects for equality. This method consider a User equal
     * to another User if their id fields have the same value.
     *
     * @param object The other User object to compare to.
     * @return true if ids are equals.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Obtains a string representation of the User id.
     *
     * @return The String representing the User id.
     */
    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }

}
