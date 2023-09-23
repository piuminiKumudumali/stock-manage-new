package lk.ijse.stokemanagesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.stokemanagesystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerManageFormController {
    public TextField customerId;
    public TextField nameId;
    public TextField addressId;
    public TextField salaryId;



    public void initialize(){
        System.out.println("Customer form just loaded");
    }

    public void btnSaveOnAction(ActionEvent actionEvent){
        String id=customerId.getText();
        String name=nameId.getText();
        String address=addressId.getText();
        Double salary= Double.valueOf(salaryId.getText());

        try {
            Connection con= DbConnection.getInstance().getConnection();
            String sql="INSERT INTO customer VALUES(?,?,?,?)";
            PreparedStatement pstm= con.prepareStatement(sql);

            pstm.setString(1,id);
            pstm.setString(2,name);
            pstm.setString(3,address);
            pstm.setDouble(4,salary);

            boolean isSaved=pstm.executeUpdate()>0;
            if(isSaved){
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").show();
            }

        } catch (SQLException e) {
             new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void clearFields() {
        customerId.setText("");
        nameId.setText("");
        addressId.setText("");
        salaryId.setText("");
    }

    public void custIdOnAction(ActionEvent actionEvent) {
        String id=customerId.getText();

        try {
            Connection con=DbConnection.getInstance().getConnection();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
