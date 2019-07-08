/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Orics
 */
public class MainWindownController implements Initializable {
    
    @FXML
    private AnchorPane RoomAncPane;
    private boolean RoomMngmLoaded = false;
    
    @FXML
    private AnchorPane ReservationBillAncPane;
    private boolean ReservationBillMngmLoaded = false;
    
    @FXML
    private AnchorPane CustomerAncPane;
    private boolean CustomerMngmLoaded = false;
    
    
    @FXML
    private AnchorPane StatisticAncPane;
    private boolean StatisticMngmLoaded = false;
    
    @FXML
    private AnchorPane RegulationAncPane;
    private boolean RegulationMngmLoaded = false;
    
    @FXML
    private AnchorPane HelpAncPane;
    private boolean HelpMngmLoaded = false;
    
    @FXML
    private AnchorPane AnPane;
    
    @FXML
    private MenuItem AccountInfor_MenuItem;
    
    @FXML
    private MenuItem Logout_MenuItem;
    
    @FXML
    private Button Exit;
    
    @FXML
    private Button RoomBtn;
    
    @FXML
    private Button ReservationBillBtn;
   
    @FXML
    private Button CustomerBtn;
    
 
    private Button StatisticBtn;
    
    @FXML
    private Button RegulationBtn;
    
    @FXML
    private Button HelpBtn;
    
    @FXML
    private Button switch1;
    
    @FXML
    private Button switch2;
    
    @FXML
    private ImageView imgView;
    
    @FXML
    private Pane Triangle;
  
 
    private void OpenAccountInforWindown(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hotelmanagementsystem/GUI/AccountInforWindown.fxml"));
            Parent AccountInfor = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(AccountInfor);  
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindownController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GoToRoomManagement() {
        if(RoomMngmLoaded == false){
//            try {
//                
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hotelmanagementsystem/GUI/RoomManagement.fxml"));
//                Parent RoomManagement = loader.load();
//                AnPane.getChildren().add(RoomManagement);
//                RoomManagementController controller = (RoomManagementController)loader.getController();
//                FlowDTO flowDTO = new FlowDTO(); 
//                List<Flow> ListFlow = flowDTO.GetAllFlows();
//                controller.setCustomerManagementController(customerManagementController);
//                controller.setMainWindownController(this);
//                controller.setListFlow(ListFlow);  
//                controller.Load();
//                RoomMngmLoaded = true;
//                SwitchMngmTab("RoomManagement");
//            } catch (IOException ex) {
//                Logger.getLogger(MainWindownController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        else
        {
            SwitchMngmTab("RoomManagement");
        }
    }

    private void GoToCustomerManagement() {
        if(CustomerMngmLoaded == false){
//            try {
//                
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hotelmanagementsystem/GUI/CustomerManagement.fxml"));
//                Parent customerManagement = loader.load();
//                AnPane.getChildren().add(customerManagement);
//                CustomerManagementController controller = (CustomerManagementController)loader.getController();
//                
//                CustomerDTO cDTO = new CustomerDTO();
//                controller.setListCustomer(cDTO.GetAllCustomers());
//                
//                this.setCustomerManagementController(controller);
//                
//                CustomerTypeDTO  ctDTO = new CustomerTypeDTO();
//                controller.setListCustomerType(ctDTO.GetAllCustomerType());
//                
//                controller.Load();
//                CustomerMngmLoaded = true;
//                SwitchMngmTab("CustomerManagement");
//            } catch (IOException ex) {
//                Logger.getLogger(MainWindownController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        else
        {
            SwitchMngmTab("CustomerManagement");
        }
    }
    
    
    private void GoToReservationBIllManagement() {
        if(ReservationBillMngmLoaded == false){
//            try {
// 
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hotelmanagementsystem/GUI/ReservtionBillManagement.fxml"));
//                Parent reservationBIllManagement = loader.load();
//                AnPane.getChildren().add(reservationBIllManagement);
//                ReservtionBillManagementController controller = (ReservtionBillManagementController )loader.getController();
//                ReservationDTO rDTO = new ReservationDTO();
//                controller.setListReservation(rDTO.GetAllReservations());
//                
//                ReservationBillMngmLoaded = true;
//                SwitchMngmTab("ReservationBillManagement");
//            } catch (IOException ex) {
//                System.out.println("Load ReservtionBillManagement fxml fail");
//            }
        }
        else
        {
            SwitchMngmTab("ReservationBillManagement");
        }
    }
    
    public void SwitchMngmTab(String tabId){
        for (Node anPane : AnPane.getChildren()) {
            if(anPane.getId().compareTo(tabId) == 0)
                anPane.setVisible(true);
            else
                anPane.setVisible(false);
        }
    }

    private void Exit(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {   
        
        AccountInfor_MenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OpenAccountInforWindown();
            }
        });
        
        RoomBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GoToRoomManagement();
            }
        });
        
        ReservationBillBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GoToReservationBIllManagement();
            }
        });   
        
        CustomerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GoToCustomerManagement();
            }
        });    
        
        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Exit();
            }
        });
    }
}
