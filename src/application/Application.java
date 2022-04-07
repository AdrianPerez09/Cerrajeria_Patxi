/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import factories.UserManagerFactory;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.controller.SignInController;

/**
 *
 * @author adril_4v37cln
 */
public class Application extends javafx.application.Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
 
    public static void main(String[] args) {
         launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fxml/SignIn.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        SignInController controller = ((SignInController) fxmlLoader.getController());
        controller.setStage(primaryStage);
        controller.setUm(UserManagerFactory.createUsersManager());
        LOGGER.info("Openning SignIn Window");
        controller.initStage(root);
    }
}
