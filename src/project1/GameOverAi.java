/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author alifa
 */
public class GameOverAi {
    
    
    boolean flag;
    public boolean display(int firstman,int secondman){
        Stage window=new Stage();
        Pane pane=new Pane();
        pane.setId("fun");
        Scene scenelast=new Scene(pane,400,300);
        
        flag =  false;
        window.initModality(Modality.APPLICATION_MODAL);
        Button btn=new Button("Back Again");
        btn.setOnAction(e-> {
            //Project1.windows.
            Project1.windows.setScene(Project1.scene);
            Initialization.flag = false;
            window.close();
        });
        Label lbl=new Label("");
        if(firstman>secondman){
            scenelast.getStylesheets().add
            (GameOver.class.getResource("styleforGameOver1.css").toExternalForm());
            lbl.setText(String.format("You beat AI by %d vs %d",firstman,secondman));
        }
        else if(firstman==secondman){ 
            scenelast.getStylesheets().add
            (GameOver.class.getResource("gameoverdraw.css").toExternalForm());
            lbl.setText(String.format("Point is equal! Draw"));
            
        }
        else{ lbl.setText(String.format("AI beat You by %d vs %d",firstman,secondman));
            scenelast.getStylesheets().add
            (GameOver.class.getResource("styleforGameOver.css").toExternalForm());
        }
        
        
        
        btn.setLayoutX(150);
        btn.setLayoutY(100);
        lbl.setLayoutX(80);
        lbl.setLayoutY(50);
        
        
        ;
        pane.getChildren().addAll(lbl,btn);
        pane.setStyle("-fx-background-color: brown");
        
        
        
        
        window.setScene(scenelast);
        window.setResizable(false);
        window.showAndWait();
        
        return flag;
    }
   
}
