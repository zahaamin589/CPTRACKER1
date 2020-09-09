package sample;


import java.io.*;

import com.sun.javafx.collections.MapAdapterChange;
import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {
    DatePicker Datepicker;
    TextField Marks;
    Label titleLabel,dateLabel,marksLabel;
    HBox dBox,mBox,bBox;

    @Override
    public void start(Stage primaryStage) {
        dateLabel=new Label("Date:");
        dateLabel.setFont(new Font(16));
        marksLabel=new Label("Marks:");
        marksLabel.setFont(new Font(16));
        titleLabel=new Label("My CP Tracker");
        titleLabel.setFont(new Font("Arial",22));
        Marks=new TextField();
        Marks.setPrefWidth(150);
        Datepicker=new DatePicker();
        Datepicker.setPrefWidth(150);
        dBox=new HBox(90);
        dBox.getChildren().addAll(dateLabel,Datepicker);
        dBox.setAlignment(Pos.CENTER);
        mBox=new HBox(90);
        mBox.getChildren().addAll(marksLabel,Marks);
        mBox.setAlignment(Pos.CENTER);

        Button btn = new Button("Save Data");
        btn.setFont(new Font(16));
        btn.setOnAction((ActionEvent event) -> {
            save();
        });
        bBox=new HBox();
        bBox.getChildren().add(btn);
        bBox.setAlignment(Pos.CENTER);
        bBox.setPadding(new Insets(0,20,0,0));
        VBox vb=new VBox(50);
        vb.getChildren().addAll(titleLabel,dBox,mBox,btn);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb, 350, 300);
        primaryStage.setTitle("RollNumber CP Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void save(){
        try(PrintWriter writer=new PrintWriter(new FileWriter("cp.txt",true))){
            String m="-------- CP Marks on "+Datepicker.getValue().toString()+" ----------\n";
            m+=" Marks: "+Marks.getText();
            writer.println(m);
            alert(m);
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    private void alert(String data){
        Alert d=new Alert(AlertType.INFORMATION);
        d.setTitle("CP Data Saved");
        d.setHeaderText("Your CP data is saved successfully");
        d.setContentText(data);
        d.showAndWait();
    }

}





