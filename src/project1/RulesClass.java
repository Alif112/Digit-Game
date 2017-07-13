/*
 * class for showing the rules of the game. and some tips to good well.
 */
package project1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

/**
 *
 *
 */
public class RulesClass {
    
    static Scene rulesScene;
    
    /**
 * this method creates the view of rulesclass, here we put some text in the scene. 
 *
 * 
 */
    
    public Scene showRules(){
        
        GridPane root=new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(15);
        root.setHgap(15);
        
        Button back=new Button("Back");
        back.setPrefSize(70, 40);
        root.setConstraints(back,2, 25);
        
        back.setOnAction(e ->{
            Project1.windows.setScene(Project1.scene);
        });
        
        
        
        
        Text txt=new Text("Rules To Play");
        root.setConstraints(txt,2, 1);
        txt.setFont(Font.font ("Verdana", 30));
        txt.setFill(Color.YELLOW);
        
        Text txt1=new Text("1. You have to get the maximum number greater than your opponent");
        root.setConstraints(txt1,2, 6);
        txt1.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt1.setFill(Color.ORANGE);
        
        
        Text txt2=new Text("2. If you are Player 1 , you can only select green buttons from the Row");
        root.setConstraints(txt2,2, 8);
        txt2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt2.setFill(Color.ORANGE);
        
        Text txt3=new Text("3. Same as Player1, Player 2 can only select green buttons from the column");
        root.setConstraints(txt3,2, 10);
        txt3.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt3.setFill(Color.ORANGE);
        Text txt4=new Text("4. If you press any button, For that there is no valid buttons then its GameOver");
        root.setConstraints(txt4,2, 12);
        txt4.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt4.setFill(Color.ORANGE);
        Text txt5=new Text("5. You can also play with Computer, Where You are Player 1 and Computer is Player 2");
        root.setConstraints(txt5,2, 14);
        txt5.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        txt5.setFill(Color.ORANGE);
        
        
        
       
        root.setId("lol");
        root.getChildren().addAll(txt,txt1,txt2,txt3,txt4,txt5,back);
        
        rulesScene=new Scene(root,Project1.xsize,Project1.ysize);
        
        rulesScene.getStylesheets().add
            (RulesClass.class.getResource("rules.css").toExternalForm());
        
        
        return rulesScene;
    }
    
}
