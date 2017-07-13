/*
 * this is the class with main method, and the start method. 
 * the first class to open the game.     
 * we declare the main stage here

 */
package project1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * 
 * this is the application method. where we show the 
 * first scene for the app, 
 * after the main method we come here to open features
 */


public class Project1 extends Application {

    static int xsize=1000,ysize=650;
    Button play,rules,help,exit,mainButton,playVsAi;
    public static Stage windows;
    Text digitGame = new Text("Digit game");
    static Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        windows=primaryStage;
        
        
        
        GridPane root=new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(15);
        root.setHgap(15);
        

        playVsAi=new Button("Player vs AI");
        mainButton=new Button("Digit Game");
        mainButton.setPrefSize(300, 100);
        mainButton.setStyle("-fx-font-size: 35px");;
        
        root.setConstraints(mainButton, 20, 1);
        
        play=new Button("Player vs Player");
        
        play.setOnAction(e->{
            
            Scene1 scene1Object=new Scene1();
            scene1Object.mainMenu();
            
            
            windows.setScene(scene1Object.myscene);
        });
        root.setConstraints(playVsAi, 4, 5);
        playVsAi.setOnAction(e->{
            SceneVsAi scene1Object=new SceneVsAi();
            scene1Object.mainMenu();
            
            
            windows.setScene(scene1Object.myscene);
        });
        
        
        
        
        root.setConstraints(play, 4, 3);
        rules=new Button("Rules");
        rules.setOnAction(e ->{
           RulesClass r=new RulesClass();
           r.showRules();
           windows.setScene(r.rulesScene);
        });
        
        
        
        root.setConstraints(rules, 4, 7);
        help=new Button ("Help");
        help.setOnAction(e ->{
            HelpClass helpclass=new HelpClass();
            helpclass.showhelp();
            windows.setScene(helpclass.helpScene);
        });
        
        
        root.setConstraints(help, 4, 9);
        exit=new Button("Exit");
        exit.setOnAction(e -> { windows.close(); });
        root.setConstraints(exit, 4, 11);
        root.setConstraints(digitGame, 25, 1);
        
        root.getChildren().addAll(play,rules,help,exit,mainButton,playVsAi);
        root.setStyle("-fx-background-color: brown");
        root.setId("pane");
        
        scene = new Scene(root, xsize, ysize);
        scene.getStylesheets().add
        (Project1.class.getResource("sceneNo1.css").toExternalForm());
        
        
        windows.setTitle("Digit Game");
        windows.setScene(scene);
         windows.setResizable(false);
        
        windows.show();
    }

    /**
     * this is the main method of the project
     */
    public static void main(String[] args) {
        
        
        launch(args);
    }
    
    
    
}
