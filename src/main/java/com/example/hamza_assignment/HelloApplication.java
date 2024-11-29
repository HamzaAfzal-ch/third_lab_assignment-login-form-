package com.example.hamza_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    NewFIle dataFIle=new NewFIle();
    @Override
    public void start(Stage primaryStage) throws IOException {
   
        GridPane layout = new GridPane();
        Label nameLabel = new Label("Full Name");
        TextField nameField = new TextField();
        layout.setVgap(10);
        layout.setHgap(20);

        layout.add(nameLabel, 0, 0);
        layout.add(nameField, 1, 0);

        Button newButton = new Button("New/Register");
        // GridPane.setMargin(newButton, new Insets(20,0,0,20));
        layout.add(newButton, 4, 0);

        Label idLabel = new Label("ID");
        TextField idField = new TextField();

        layout.add(idLabel, 0, 1);
        layout.add(idField, 1, 1);

        Button dltButton = new Button("Delete");
        layout.add(dltButton, 4, 1);


        Label genderLabel=new Label("Gender");
        TextField genderField=new TextField();
        layout.add(genderLabel, 0, 2);
        layout.add(genderField, 1, 2);

        Button restoreButton=new Button("Restore");
        layout.add(restoreButton, 4, 2);

        Label homeLabel=new Label("Home Province");
        TextField homeField=new TextField();
        layout.add(homeLabel, 0, 3);
        layout.add(homeField, 1, 3);


        Button findButton=new Button("Find");
        layout.add(findButton, 4, 3);

        Label dateLabel = new Label("Date");
       DatePicker datePicker = new DatePicker();
        
        layout.add(dateLabel, 0, 4);
        layout.add(datePicker, 1, 4);
       
       
        

        Button closeButton=new Button("CLose");
        layout.add(closeButton, 4, 4);
        closeButton.setOnAction(e ->{
            System.exit(0);
        });
 

        newButton.setOnAction(e->{
            String name=nameField.getText();
            String Id=idField.getText();
            String gender=genderField.getText();
            String province=homeField.getText();
            LocalDate date=datePicker.getValue();

            dataFIle.writeInFile(name, Id, gender, province, date);
        });

        findButton.setOnAction(e->{
            String name=nameField.getText();
            String id=idField.getText();
            
            try{
                if (dataFIle.checkInFile(name, id)) {
                    showWlcm(name);
                }
                 
            }catch(Exception u){
System.out.println(u.getMessage());
            }
           
           
        });
        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setTitle("login form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
public void showWlcm(String name){
    
    StackPane stackLayout=new StackPane();
    Label congrats=new Label(name+"\nWelcome Succesfully logged In");
    stackLayout.getChildren().add(congrats);
    Scene scene=new Scene(stackLayout,200,200);
    Stage newStage=new Stage();
    newStage.setScene(scene);
    newStage.show();
}
    public static void main(String[] args) {
        launch();
    }
}