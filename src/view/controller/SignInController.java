/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import exceptions.BusinessLogicException;
import exceptions.FieldsEmptyException;
import exceptions.MaxCharactersException;
import exceptions.UserNotFoundException;
import interfaces.UserManager;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.User;

/**
 * FXML Controller class
 *
 * @author adril_4v37cln
 */
public class SignInController {

    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());

    private Stage stage;

    private UserManager um;
    @FXML
    private Label lblLogin;
    @FXML
    private TextField txtLogin;
    @FXML
    private Label lblPass;
    @FXML
    private PasswordField passfield;
    @FXML
    private Label lblSignUp;
    @FXML
    private Hyperlink linkSignUp;
    @FXML
    private Button btnSignIn;

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
        stage.setOnCloseRequest(this::handleWindowClosing);
        stage.show();
        LOGGER.info("SignIn Open Window");
        // TODO
    }

    private void handleWindowClosing(WindowEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You are about to close this window");
        alert.setContentText("Are you sure you want to close this window?");
        Optional<ButtonType> result = alert.showAndWait();
        // If the button is Ok, it consumes the handleWindowClosing event,
        // so it won't do it and if not, it closes the window
        if (ButtonType.OK != result.get()) {
            e.consume();
        } else {
            LOGGER.info("SignIn Window is closed");
        }

    }

    @FXML
    private void HandleSignUpWindow(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/SignUp.fxml"));
            Stage stageSignUp = new Stage();
            Parent root = (Parent) loader.load();
            SignUpController controller = ((SignUpController) loader.getController());
            controller.setStage(stageSignUp);
            stageSignUp.initModality(Modality.APPLICATION_MODAL);
            stageSignUp.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            controller.initStage(root);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error");
            alert.setContentText("There was a problem creating the window, try again later");
            alert.showAndWait();
            LOGGER.warning(ex.getClass().getSimpleName() + " exception thrown at SignIn method");
        }

    }

    @FXML
    private void HandleSignIn(ActionEvent event) {
        User user;
         try {
            checkEmptyFields();
            user = um.login(txtLogin.getText(), passfield.getText().trim());
            if (user != null) {
                System.out.println(user.getFullName());
                
                Parent root;
                FXMLLoader loader = null;
                loader = new FXMLLoader(getClass().getResource("/view/fxml/Welcome.fxml"));
                root = (Parent) loader.load();
                Stage stageWelcome = new Stage();
                WelcomeController controller = ((WelcomeController) loader.getController());
                controller.setStage(stageWelcome);
                controller.setUm(um);
                controller.setUser(user);
                this.stage.close();
                LOGGER.info("Initializing Welcome window and closing SignIn window");
                controller.initStage(root);
            }else{
                throw new UserNotFoundException();
            }
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error");
            alert.setContentText("There was a problem creating the window, try again later");
            alert.showAndWait();
            LOGGER.warning(ex.getClass().getSimpleName() + " exception thrown at SignIn method");
        } catch (FieldsEmptyException | MaxCharactersException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("There was an issue with the fields");
            alert.setContentText(ex.getMessage());
            alert.show();
            LOGGER.warning(ex.getClass().getSimpleName() + " exception thrown at SignIn method");
        } catch (BusinessLogicException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Could not log in");
            alert.setContentText(ex.getMessage());
            alert.show();
            LOGGER.warning(ex.getClass().getSimpleName() + " exception thrown at SignIn method");
        } catch (UserNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("El usuario o contraseña son incorrectos");
            alert.setContentText(ex.getMessage());
            alert.show();
            LOGGER.warning(ex.getClass().getSimpleName() + " exception thrown at SignIn method");
        } 
    }

     private void checkEmptyFields() throws FieldsEmptyException, MaxCharactersException {
        //if one or more fields are empty , this method throws a FieldsEmptyException.
        if (txtLogin.getText().trim().isEmpty() || passfield.getText().trim().isEmpty()) {
            LOGGER.warning("Fields empty");
            throw new FieldsEmptyException();
        }
        //if one or more fields of this window are filled with a string whose length is higher than 255 chars.
        if (txtLogin.getText().trim().length() > 255 || passfield.getText().trim().length() > 255) {
            LOGGER.warning("Max character length reached");
            throw new MaxCharactersException();
        }
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
    public UserManager getUm() {
        return um;
    }

    /**
     * Method that sets the UserManager impoementation gotten with the factory
     *
     * @param um
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

    

}
