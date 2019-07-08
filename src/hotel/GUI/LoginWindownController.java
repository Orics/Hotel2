/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUI;

import hotel.DAL.DataAccess;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Orics
 */
public class LoginWindownController implements Initializable {

    private Stage stage = null;
    private double xOffset = 0;
    private double yOffset = 0;   
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Pane LogoPane;
    
    @FXML
    private TextField LoginUsername_TextField;
    
    @FXML
    private TextField LoginPassword_TextField;
    
    @FXML
    private TextField ConnectString_Label;
    
    @FXML
    private TextField DatabaseUsername_TextField;
    
    @FXML
    private TextField DatabasePassword_TextField;
    
    @FXML
    private Button Login_Button;
    
    @FXML
    private Button Exit_Button;
    
    
    @FXML
    private Button Connect_Button;
    
    @FXML            
    private Label LoginNotif_Label;
    
    @FXML            
    private Label LoginMgmt_Label;
    
    @FXML   
    private Label DataMgmt_Label;
    
    @FXML
    private Label DatabaseNotif_Label;
    
    @FXML
    private CheckBox Remember_CheckBox;
   
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public Stage getStage(){
        return stage;
    }
    
    
    private boolean CheckLogin(){
//        DataAccess dt = new DataAccess();
//        String sql = "select password from ht_account where EmployeeID = '" + LoginUsername_TextField.getText() + "'";
//        String password = "";
//        try {
//            password = dt.ExecuteScalarQuery(sql);
//        }
//        catch (Exception e) {
//            ShowLoginNotification("Username or password is NOT correct");
//            return false;
//        }
//        
//        if(password != null && password.compareTo(LoginPassword_TextField.getText()) == 0){ 
//            return true; 
//        }
//        else
//        {  
//            ShowLoginNotification("Username or password is NOT correct");
//            return false;
//        }
        return true; 
    }
    
    private void OpenMainWindown() {  
        if(CheckLogin() == true){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hotel/GUI/MainWindown.fxml"));
                Parent mainwindown = loader.load();
                //MainWindownController controller = (MainWindownController)loader.getController();
                Stage stage = new Stage(StageStyle.UNDECORATED);
                Scene scene = new Scene(mainwindown);     
                stage.setScene(scene);
                this.stage.close();             
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginWindownController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    private void Exit(){
        System.exit(0);
    }
    
    private boolean TestConnect(){
        DataAccess da = new DataAccess();
        da.setConnectString(ConnectString_Label.getText());
        da.setUsername(DatabaseUsername_TextField.getText());
        da.setPassword(DatabasePassword_TextField.getText());
        if(da.TestConnect() == true){
            DatabaseNotif_Label.setText("Connection successfull");
            DatabaseNotif_Label.setTextFill(Color.GREEN);
            return true;
        }
        else
        {
            DatabaseNotif_Label.setText("Connection failed");
            DatabaseNotif_Label.setTextFill(Color.RED);
            return false;
        }
    }
    
     
    
    private void SwitchToDatabaseManagement(){ 
        DataMgmt_Label.setVisible(false);
        LoginMgmt_Label.setVisible(true);
        LogoPane.setLayoutX(100);
    } 
    
    private void SwitchToHotelManagement() { 
        DataMgmt_Label.setVisible(true);
        LoginMgmt_Label.setVisible(false);
        LogoPane.setLayoutX(450);
    } 
    
    
    private void HideLoginNotification() {
        LoginNotif_Label.setVisible(false);
    }
    
    private void ShowLoginNotification(String notifi){
        LoginNotif_Label.setText(notifi);
        LoginNotif_Label.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set 
        LoginMgmt_Label.setVisible(false);
        LoginNotif_Label.setText("");
        DatabaseNotif_Label.setText("");
        
        
        LoginUsername_TextField.setOnMouseClicked((new EventHandler<MouseEvent>() {             
            @Override
            public void handle(MouseEvent event) {
                HideLoginNotification();
            }
        }));
        
        LoginPassword_TextField.setOnMouseClicked((new EventHandler<MouseEvent>() {             
            @Override
            public void handle(MouseEvent event) {
                HideLoginNotification();
            }
        }));
        
        Login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {        
                OpenMainWindown();              
            }
        });
        
        Exit_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Exit();
            }
        });
        
        DataMgmt_Label.setOnMouseClicked((new EventHandler<MouseEvent>() {             
            @Override
            public void handle(MouseEvent event) {
                SwitchToDatabaseManagement();
            }
        }));
        
        LoginMgmt_Label.setOnMouseClicked((new EventHandler<MouseEvent>() {             
            @Override
            public void handle(MouseEvent event) {     
                SwitchToHotelManagement();
            }
        }));
        
        Connect_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(TestConnect()==true){
               };
            }
        });
    }      
}
