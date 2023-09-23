package lk.ijse.stokemanagesystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane rootNodeMain;
    public AnchorPane branchNode;

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene=new Scene(node);
        Stage stage= (Stage) this.rootNodeMain.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/customermanage_form.fxml"));
        this.branchNode.getChildren().clear();
        this.branchNode.getChildren().add(node);
    }


    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/itemmanage_form.fxml"));
        this.branchNode.getChildren().clear();
        this.branchNode.getChildren().add(node);
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/suppliermanage_form.fxml"));
        this.branchNode.getChildren().clear();
        this.branchNode.getChildren().add(node);

    }
}
