/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import interfaces.UserManager;
import javax.naming.OperationNotSupportedException;
import logic.UserManImplementation;
//import logic.UserManagerImplementation;
/**
 * Method that returns an implementation of UserManager
 *
 * @param type the type of instance
 * @return UserManager the implementation
 * @throws OperationNotSupportedException
 */
public class UserManagerFactory {


    public static UserManager createUsersManager()
            throws OperationNotSupportedException {
        //The object to be returned.
        UserManager userManager = null;
     
        userManager = new UserManImplementation();
       
        return userManager;
    }
}
