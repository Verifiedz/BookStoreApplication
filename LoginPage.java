/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginPage {

    private final Stage stage;
    GridPane root = new GridPane();

    
        Label labels = new Label();
        Label userID=new Label("User ID");  
        Label passID = new Label("Password");  
        
        TextField user = new TextField("admin");  
        TextField password = new TextField("admin");
      
        Button btn = new Button("Login");
        Button btn1 = new Button("Exit");
        Button btn2 = new Button("Change Password");
        Button btn3 = new Button("Create Account");
       
    
    public LoginPage(Stage stage) {
        this.stage = stage;

        // Create the first scene
        btn1.setOnAction(e -> System.exit(0));
        btn.setOnAction(e -> switchScene2());
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
       
        root.add(userID, 0, 0);
        root.add(user, 1, 0);
        root.add(passID, 0, 1);
        root.add(password, 1, 1);
        
        root.add(btn, 0, 3); 
        root.add(btn1, 1, 3);
        root.add(btn2, 0, 4);
        root.add(btn3, 1, 4);
        
        
      
        Scene scene1 = new Scene(root, 800, 800);

        // Set the first scene as the primary scene
        stage.setScene(scene1);
    }



    // Method to switch to the second scene
    private void switchScene2() {
        
        String getUser = user.getText();
        String getPass = password.getText();;
            
           if (getUser.equals("admin") && getPass.equals("admin")) {
                   OwnerScreen scene2 = new OwnerScreen(stage);    
           }
           
           else if (getUser.equals("customer") && getPass.equals("customer")) {
               labels.setText("Welcome " + getUser + " !");
               root.add(labels, 0, 5);
           }
                
           else {
                
               labels.setText("error");
               root.add(labels, 0, 5);
               
            }
           
        
    }
     // Method to switch to the second scene
    private void changePassword() {
        
    }
    
}

