/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import exceptions.BusinessLogicException;
import exceptions.UserNotFoundException;
import interfaces.UserManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import resources.DBconnection;

/**
 *
 * @author adril_4v37cln
 */
public class UserManImplementation implements UserManager {

    private Connection con;
    private PreparedStatement stmt;
    private DBconnection db = new DBconnection();

    final String LOGIN = ("SELECT U.* FROM USER U WHERE U.USERNAME=? AND U.PASSWORD=?");

    @Override
    public void updateUser(User user) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser(User user) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllUsers() throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String id) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String login, String password) throws BusinessLogicException {

        User loggedUser = null;
        
        ResultSet rs = null;
        
        con = db.openConnection();
        
        
        try {
            stmt = con.prepareStatement(LOGIN);

            stmt.setString(1, login);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {

                System.out.println("logic.UserManagerImplementation.login()");
                
                loggedUser = new User();           
                loggedUser.setLogin(rs.getString(2));
                loggedUser.setPassword(rs.getString(3));
                loggedUser.setUserPrivilege(rs.getString(4));
                loggedUser.setFullName(rs.getString(5));
                loggedUser.setPhoneNumber(rs.getInt(6));
                loggedUser.setEmail(rs.getString(7));
            } else{
                throw new UserNotFoundException();
            }
        } catch (SQLException e) {
            String error = "Database error. \n Connection refused";
            //CreateException ex=new CreateException(e1.getMessage())

        } catch (UserNotFoundException ex) {
            Logger.getLogger(UserManImplementation.class.getName()).log(Level.INFO, null, ex);
        } finally {

            try {
                rs.close();
            } catch (SQLException ex) {

            }

            try {
                db.closeConnection(stmt, con);
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
         return loggedUser;
    }

    @Override
    public User changePassword(String user, String pass) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetPassword(String user) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
