/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adril_4v37cln
 */
public class SignInController {

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());
   
    private Stage stage;
    
    /**
     * Initializes the controller class.
     */
     
    public void initStage(Parent root) {
        
        LOGGER.info("Initializing SignIn stage.");
        Scene scene = new Scene(root);
        //CSS load      
        String css = this.getClass().getResource("/view/resources/css/SignIn.css").toExternalForm();
        if (css == null) {
            
            System.out.println("no css ");
        }
        scene.getStylesheets().add(css);       
        //Stage dimension setters       
        stage.setResizable(false);
        stage.setTitle("BluRoof SignIn Page");
        //Gets the icon of the window.
        //stage.getIcons().add(new Image("/view/resources/img/BluRoofLogo.png"));
        stage.setScene(scene);
        stage.setTitle("SignIn");
        //Close request handler declaration
        //stage.setOnCloseRequest(this::handleWindowClosing);
        stage.show();
        LOGGER.info("SignIn Open Window");
        // TODO
    }  
    
     public Stage getStage() {
        return stage;
    }

    /**
     * Sets the stage.
     *
     * @param stage the stage to set.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Method that gets the Implementation of user manager
     *
     * @return um the user manager
     */
    
    
    
    //  Database Interface Implementation.
    
   /** 
    public UserManager getUm() {
        return um;
    }
*/
    /**
     * Method that sets the UserManager impoementation gotten with the factory
     *
     * @param um
     */
    
    /*
    public void setUm(UserManager um) {
        this.um = um;
    }       
    */
}
