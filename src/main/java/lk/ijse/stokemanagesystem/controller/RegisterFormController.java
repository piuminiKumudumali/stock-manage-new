package lk.ijse.stokemanagesystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterFormController {
    public AnchorPane registerNode;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene=new Scene(node);
        Stage stage= (Stage) this.registerNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
        stage.show();


    }

}
