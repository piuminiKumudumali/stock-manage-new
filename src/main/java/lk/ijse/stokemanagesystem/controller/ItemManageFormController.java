package lk.ijse.stokemanagesystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.stokemanagesystem.db.DbConnection;
import lk.ijse.stokemanagesystem.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManageFormController {
    @FXML
    private TextField itemId;

    @FXML
    private TextField descriptionId;

    @FXML
    private TextField unitPriceId;

    @FXML
    private TextField qtyOnHandId;



    @FXML
    private Button backBtnId;

    public void initialize(){
        System.out.println("Item form just loaded");
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String code = itemId.getText();
        String description = descriptionId.getText();
        double unitPrice = Double.parseDouble(unitPriceId.getText());
        int qtyOnHand = Integer.parseInt(qtyOnHandId.getText());

        try {
            Connection con = DbConnection.getInstance().getConnection();
            String sql = "INSERT INTO item VALUES(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, code);
            pstm.setString(2, description);
            pstm.setDouble(3, unitPrice);
            pstm.setInt(4, qtyOnHand);

            boolean isSaved = pstm.executeUpdate() > 0;

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item is Saved").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Item is not saved").show();
        }

    }

    @FXML
    void itemCodeOnAction(ActionEvent event) {

        String code=itemId.getText();

        try {
            Connection con= DbConnection.getInstance().getConnection();
            String sql="SELECT * FROM WHERE code=?";

            PreparedStatement pstm= con.prepareStatement(sql);
            pstm.setString(1,code);

            ResultSet rslt=pstm.executeQuery();

            if(rslt.next()){
                String itemCode=rslt.getString(1);
                String itemDescription= rslt.getString(2);
                double itemUnitPrice= rslt.getDouble(3);
                int quantityOnHand=rslt.getInt(4) ;

                var itemDto=new ItemDto(itemCode,itemDescription,itemUnitPrice,quantityOnHand);
                setField(itemDto);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setField(ItemDto itemDto) {

    }

}