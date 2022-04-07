/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adril_4v37cln
 */
public class SignUpController {

    public static final Pattern VALID_PHONE_NUMBER = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
    private Stage stage;

    public void initStage(Parent root) {
           Scene scene = new Scene(root);
           
            stage.setResizable(false);
        stage.setTitle("Cerrajeria Patxi SignUp Page");
        //Gets the icon of the window.
        //stage.getIcons().add(new Image("/view/resources/img/BluRoofLogo.png"));
        stage.setScene(scene);
        stage.setTitle("SignUp");
        stage.show();
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

}
