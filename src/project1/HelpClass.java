/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import static project1.Project1.scene;

/**
 * this is the class for helping the players. 
 * if any player think any update of bug of the app
 * then we can fix it or update
 */
public class HelpClass {
    
    /**
     * this is the method for the helpclass to build text and buttons. 
     * we take a gridpane to do those jobs done
     * @return 
     */
    Scene helpScene;
    
    public void showhelp(){
        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        Button back=new Button("Back");
        back.setPrefSize(70, 40);
        
        grid.setConstraints(back,33,42);
        back.setOnAction(e ->{
            Project1.windows.setScene(Project1.scene);
        });
        
        
        
        
        
        Text txt=new Text("Contacts:");
        txt.setStyle("-fx-font-size: 25px");
        grid.setConstraints(txt, 2, 1);
        
        
        Text txt1=new Text("Md. Alif Al Amin");
        grid.setConstraints(txt1,2, 6);
        txt1.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt1.setFill(Color.ORANGE);
        
        
        Text txt2=new Text("Dept. Of Computer Science And Engineering");
        grid.setConstraints(txt2,2, 7);
        txt2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt2.setFill(Color.ORANGE);
        
        Text txt3=new Text("Shahjalal University of Science and Technology");
        grid.setConstraints(txt3,2, 8);
        txt3.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt3.setFill(Color.ORANGE);
        Text txt4=new Text("Email: alifalamin4@gmail.com");
        grid.setConstraints(txt4,2, 9);
        txt4.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt4.setFill(Color.ORANGE);
       

        grid.setId("help");
        grid.setStyle("-fx-background-color: brown");
        grid.getChildren().addAll(back,txt,txt1,txt2,txt3,txt4);
        
        helpScene = new Scene(grid,Project1.xsize,Project1.ysize);
        
        
        
        helpScene.getStylesheets().add
        (Project1.class.getResource("helpclass.css").toExternalForm());
        
        
        
    }
    
}
