package lk.ijse.stokemanagesystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.stokemanagesystem.db.Db;

import java.io.IOException;

public class LoginFormController {
    public TextField textUserName;
    public TextField textPassword;
    public AnchorPane rootNode;


    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String user=textUserName.getText();
        String password=textPassword.getText();

        if(user.equals(Db.user)&&password.equals(Db.password)){
            navigate();
        }else {
            new Alert(Alert.AlertType.ERROR,"Credential Invalid").show();
        }
    }

    private void navigate() throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/view/main_form.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Form");
        stage.centerOnScreen();


    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
       Parent node= FXMLLoader.load(getClass().getResource("/view/register_form.fxml"));
       Scene scene=new Scene(node);
       Stage stage= (Stage) this.rootNode.getScene().getWindow();
       stage.setScene(scene);
       stage.setTitle("Register Form");
       stage.centerOnScreen();
       stage.show();
    }
}
