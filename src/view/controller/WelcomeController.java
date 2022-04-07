/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import interfaces.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author adril_4v37cln
 */
public class WelcomeController {

    public static final Pattern VALID_PHONE_NUMBER = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
    private Stage stage;

    private User user;

    private UserManager um;
    @FXML
    private Label lblprueba;

    public void initStage(Parent root) {
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("Cerrajeria Patxi SignUp Page");
        //Gets the icon of the window.
        //stage.getIcons().add(new Image("/view/resources/img/BluRoofLogo.png"));
        stage.setScene(scene);
        stage.setTitle("SignUp");
        stage.show();
        
        lblprueba.setText(user.getFullName());
    }

    //GETTERS AND SETTERS
    /**
     * Gets the stage
     *
     * @return the stage to get
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Sets the stage
     *
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Sets the user
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        if (user != null) {
            this.user = user;
        }
    }

    /**
     * Method that gets the implementaiton of the user manager
     *
     * @return the implementaiton of the user manager
     */
    public UserManager getUm() {
        return um;
    }

    /**
     * Method that sets the implementaiton of the user manager
     *
     * @param um the implementaiton of the user manager
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

}
