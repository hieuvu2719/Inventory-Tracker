/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuhi;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author hieud
 */
public class FXMLassign5Controller implements Initializable {

    @FXML
    private Label header, lblId, lblName, lblQoh, lblRop, lblPrice, message;

    @FXML
    private TextField itemId, itemName, qoh, rop, sellPrice;

    @FXML
    private GridPane pane;

    @FXML
    private Button add, save, order, exit;
    
    @FXML
    private ListView reorder;
    
    
    //set default setting
    private void setDefault(){
        header.getStyleClass().add("header");
        pane.getStyleClass().add("gridPane");
        itemId.getStyleClass().add("textField");
        itemName.getStyleClass().add("textField");
        qoh.getStyleClass().add("textField");
        rop.getStyleClass().add("textField");
        sellPrice.getStyleClass().add("textField");
        lblId.setText(Fields.ITEM_ID.getCaption() + ":");
        lblName.setText(Fields.ITEM_NAME.getCaption() + ":");
        lblQoh.setText(Fields.QOH.getCaption() + ":");
        lblRop.setText(Fields.ROP.getCaption() + ":");
        lblPrice.setText(Fields.PRICE.getCaption() + ":");

}
    
    //enable text fields
    private void enable(){
        itemId.setEditable(true);
        itemId.setText("");
        itemName.setEditable(true);
        itemName.setText("");
        qoh.setEditable(true);
        qoh.setText("");
        rop.setEditable(true);
        rop.setText("");
        sellPrice.setEditable(true);
        sellPrice.setText("");
        add.setDisable(true);
        order.setDisable(true);
        save.setDisable(false);
        reorder.setItems(null);
    }
    
    
    //disable text fields
    private void disable(){
        itemId.setEditable(false);
        itemId.setText("");
        itemName.setEditable(false);
        itemName.setText("");
        qoh.setEditable(false);
        qoh.setText("");
        rop.setEditable(false);
        rop.setText("");
        sellPrice.setEditable(false);
        sellPrice.setText("");
        add.setDisable(false);
        order.setDisable(false);
        save.setDisable(true);
    }
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //UI default settings
        setDefault();
        
        InventoryList invList = new InventoryList();
        Alert alert = new Alert(AlertType.NONE);

        //"add" button event
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enable();
                itemId.requestFocus();
                message.setText("");
                message.getStyleClass().remove("error");
            }
        });

        

        //"save" button event
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Inventory inventory = new Inventory();              
                try {
                    inventory.setId(itemId.getText());
                    inventory.setName(itemName.getText());
                    inventory.setSellPrice(Double.parseDouble(sellPrice.getText()));
                    inventory.setQoh(Integer.parseInt(qoh.getText()));
                    inventory.setRop(Integer.parseInt(rop.getText()));
                    invList.add(inventory);
                    disable();
                } catch (IllegalArgumentException e) {
                    alert.setAlertType(AlertType.ERROR);
                    alert.setTitle("Data Entry Error");
                    alert.setHeaderText("Invalid Value Entered");
                    alert.setContentText("Item must be its correct type");
                    alert.show();                    
                }
            }
        });


        

        
        
        //"order" button event
        order.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                ObservableList<String> obList= FXCollections.observableArrayList();
                if(invList.length()==0){
                    message.getStyleClass().add("error");
                    message.setText("No item to list. Add some.");
                }
                else{
                    for(int i=0; i<invList.length(); i++){
                        if(invList.get(i).getRop()!=0){
                            obList.add(invList.get(i).toString());
                            
                        }
                    }
                    if(obList.isEmpty()){
                        message.getStyleClass().remove("error");
                        message.setText("No item to re-order.");
                    }else{
                        
                        reorder.setItems(obList);
                    }
                }
            }
        });
        
        
        reorder.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable o){
                ArrayList<String> ropList = new ArrayList<>();
                for (int i = 0; i < invList.length(); i++) {
                    if (invList.get(i).getRop() != 0) {
                        ropList.add("Re-Order Point: " + invList.get(i).getRop());
                    }
                }
               
                int index = reorder.getSelectionModel().getSelectedIndex();
                message.setText(ropList.get(index));
            }
        });
       
        
        exit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                alert.setAlertType(AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("Exit the program");
                alert.setContentText("Are you sure you want to exit?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    System.exit(0);
                }
            }
        });
        
        
        
        

    }

}
