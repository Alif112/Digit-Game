/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;

/**
 * this is the class for player vs AI . we build all the fitures here for player vs AI.
 * 
 */
public class SceneVsAi {

    static boolean test = true;
    int counter = 0;
    static boolean threadtest = false;
    static int alpha = 0, beta = 0;

    Initialization initobject = new Initialization();

    int clicknum = 0;

    DropShadow shadow = new DropShadow();
    int flag = 5;
    int PlayerFirst = 0, PlayerSecond = 0;
    Button refresh;
    public Scene myscene;

    // ChoiceBox choicebox1=new ChoiceBox();
    public Button btnarr[][];

    Button back = new Button("Back");

/**
 * this is the method where we color all the buttons.
 * and check the clicked button is valid or not.
 * then we call the gameover class if there is no valid buttons to press
 * 
 */
    
    
    public void colorEdgeButtons(Button button) {

        int x = 0, y = 0;
        //System.out.println("here the print");
        for (int i = 0; i < btnarr.length; i++) {
            for (int j = 0; j < btnarr[i].length; j++) {
                if (btnarr[i][j] == button) {
                    x = i;
                    y = j;
                }

            }
        }


        if (btnState[x][y] != BtnState.GREEN && gameState != GameState.STARTED) {
            return;
        }

        if (gameState == GameState.STARTED || gameState == GameState.COLUMN) {
            int num = Integer.parseInt(btnarr[x][y].getText());
            PlayerFirst += num;
            clicknum = 1;
            test = true;
            gameState = GameState.ROW;
        } else if (gameState == GameState.ROW) {
            int num = Integer.parseInt(btnarr[x][y].getText());
            PlayerSecond += num;
            gameState = GameState.COLUMN;
        }

       // System.out.println(PlayerFirst + "  " + PlayerSecond);

        int l = btnarr[x].length;
        if (gameState == GameState.ROW) {
            for (int m = 0; m < l; m++) {
                if (btnState[m][y] == BtnState.RED) {
                    btnState[m][y] = BtnState.BLUE;
                    btnarr[m][y].setStyle("-fx-background-color: blue;-fx-text-fill: white");
                }
                if (btnState[m][y] == BtnState.GREEN) {
                    btnState[m][y] = BtnState.WHITE;
                    btnarr[m][y].setStyle("-fx-background-color: white;-fx-text-fill: red");
                }

                if (btnState[x][m] == BtnState.WHITE) {
                    btnState[x][m] = BtnState.GREEN;
                    btnarr[x][m].setStyle("-fx-background-color: green;-fx-text-fill: yellow");

                }
            }
        }
        if (gameState == GameState.COLUMN) {
            for (int m = 0; m < l; m++) {
                if (btnState[x][m] == BtnState.RED) {
                    btnState[x][m] = BtnState.BLUE;
                    btnarr[x][m].setStyle("-fx-background-color: blue;-fx-text-fill: white");
                }
                if (btnState[x][m] == BtnState.GREEN) {
                    btnState[x][m] = BtnState.WHITE;
                    btnarr[x][m].setStyle("-fx-background-color: white;-fx-text-fill: red");
                }

                if (btnState[m][y] == BtnState.WHITE) {
                    btnarr[m][y].setStyle("-fx-background-color: green;-fx-text-fill: yellow");

                    btnState[m][y] = BtnState.GREEN;
                }

            }
        }
        Initialization.firstLabel.setText(String.format("YOU  :  %3d", PlayerFirst));
        Initialization.secondLabel.setText(String.format("Computer  : %3d", PlayerSecond));

        btnarr[x][y].setStyle("-fx-background-color: red;-fx-text-fill: white");
        btnState[x][y] = BtnState.RED;

        int test = 0;

        for (int i = 0; i < btnarr.length; i++) {
            for (int j = 0; j < btnarr[i].length; j++) {
                if (btnState[i][j] == BtnState.GREEN) {
                    test = 1;
                }

            }
        }

        if (clicknum != 0 && test == 0) {
            gameState = GameState.FINISHED;
        }

        if (gameState == GameState.FINISHED) {
            //System.out.println("game is finished");
            clicknum = 0;
            GameOverAi gameoverobject = new GameOverAi();
            Initialization.flag = true;
            gameoverobject.display(PlayerFirst, PlayerSecond);

            return;
        }

    }

    public enum BtnState {
        RED,
        GREEN,
        BLUE,
        WHITE
    };
    BtnState btnState[][];

    public enum GameState {

        STARTED,
        ROW,
        COLUMN,
        FINISHED

    };
    GameState gameState = GameState.STARTED;

    int offset_value = 5, current_value = 5;

    /**
 * this is the main method , where we create the buttons for the the main scene
 * and we create the choicebox here , the choose the matrix of buttons
 * this is the method for player vs Ai option
 * 
 */
    
    
    void mainMenu() {

        Initialization.firstLabel.setText(String.format("YOU  : 0"));
        Initialization.secondLabel.setText(String.format("Computer  : 0"));
        PlayerFirst = 0;
        PlayerSecond = 0;
        GridPane root2 = new GridPane();
        root2.setPadding(new Insets(10, 10, 10, 10));
        root2.setVgap(10);
        root2.setHgap(10);
        root2.setId("lol");
        back.setId("back");
        ChoiceBox choicebox1 = new ChoiceBox();
        choicebox1.setId("choicebox1");

        choicebox1.getItems().addAll("5*5");
        choicebox1.getItems().addAll("6*6");
        choicebox1.getItems().addAll("7*7");
        choicebox1.getItems().addAll("8*8");
        choicebox1.getItems().addAll("9*9");
        choicebox1.getItems().addAll("10*10");

        choicebox1.setValue("5*5");

        //refresh=new Button("Refresh");
    

        root2.setConstraints(choicebox1, 25, 1);

        root2.setConstraints(back, 25, 3);
        root2.setConstraints(Initialization.firstLabel, 25, 5);
        root2.setConstraints(Initialization.secondLabel, 25, 6);
        root2.getChildren().addAll(Initialization.firstLabel, Initialization.secondLabel);

        back.setOnAction(e -> {

            Project1.windows.setScene(Project1.scene);
        });

        root2.getChildren().addAll(choicebox1, back);

       
        gameState = GameState.STARTED;

        if (btnarr != null) {
            for (int i = 0; i < btnarr.length; i++) {
                for (int j = 0; j < btnarr[i].length; j++) {
                    root2.getChildren().remove(btnarr[i][j]);
                }
            }
        }
        
        /**
 * We are creating those buttons here default view
 * 
 */
        
        
        btnarr = new Button[current_value][current_value];
        btnState = new BtnState[current_value][current_value];

        int count = 1;
        int xpos = 4;
        for (int i = 0; i < current_value; i++) {

            for (int j = 0; j < current_value; j++) {
                int maxi = 20;
                Random rand = new Random();
                int a = rand.nextInt(2 * maxi) - maxi;
               
                btnarr[i][j] = new Button(a + "");
                btnarr[i][j].setPrefSize(50, 50);

                btnState[i][j] = BtnState.WHITE;

                
                btnarr[i][j].setEffect(shadow);
                btnarr[i][j].setStyle("-fx-text-fill: red");
                

                btnarr[i][j].setOnAction(e -> {
                    test = false;
                    colorEdgeButtons((Button) e.getSource());
                    int maxnum = -25;
                    alpha = 0;
                    beta = 0;

                    for (int p = 0; p < btnarr.length; p++) {
                        for (int q = 0; q < btnarr[p].length; q++) {
                            if (btnState[p][q] == BtnState.GREEN) {
                                int num = Integer.parseInt(btnarr[p][q].getText());
                                if (num >= maxnum) {
                                    maxnum = num;
                                    alpha = p;
                                    beta = q;
                                }

                            }

                        }
                    }
                    
                    try{Thread.sleep(500);}catch(Exception d){}
                    
                    if(test==true)
                    colorEdgeButtons(btnarr[alpha][beta]);
             
                });

                root2.setConstraints(btnarr[i][j], i + xpos, j + xpos);
                root2.getChildren().addAll(btnarr[i][j]);

            }
        }
        
        /**
 * here is the choicebox action to select you desired matrix
 * 
 */
        
        
        choicebox1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            

            public void changed(ObservableValue ov,
                    Number old_value, Number new_value) {

                Initialization.firstLabel.setText(String.format("YOU  : 0"));
                Initialization.secondLabel.setText(String.format("Computer  : 0"));

                PlayerFirst = 0;
                PlayerSecond = 0;
                gameState = GameState.STARTED;

                if (btnarr != null) {
                    for (int i = 0; i < btnarr.length; i++) {
                        for (int j = 0; j < btnarr[i].length; j++) {
                            root2.getChildren().remove(btnarr[i][j]);

                        }
                    }
                }

                current_value = offset_value + (int) new_value;
                System.out.println(current_value);
                btnarr = new Button[current_value][current_value];
                btnState = new BtnState[current_value][current_value];

                int xpos = 4;
                for (int i = 0; i < btnarr.length; i++) {

                    for (int j = 0; j < btnarr[i].length; j++) {
                        int maxi = 20;
                        Random rand = new Random();
                        int a = rand.nextInt(2 * maxi) - maxi;
                        btnarr[i][j] = new Button(a + "");
                        btnarr[i][j].setPrefSize(50, 50);
                        
                        btnState[i][j] = BtnState.WHITE;

                        btnarr[i][j].setEffect(shadow);
                        

                        btnarr[i][j].setStyle("-fx-text-fill: red");

                        btnarr[i][j].setOnAction(e -> {
                            test = false;
                            colorEdgeButtons((Button) e.getSource());
                            int maxnum = -25;
                            int alpha = 0, beta = 0;

                            for (int p = 0; p < btnarr.length; p++) {
                                for (int q = 0; q < btnarr[p].length; q++) {
                                    if (btnState[p][q] == BtnState.GREEN) {
                                        int num = Integer.parseInt(btnarr[p][q].getText());
                                        if (num >= maxnum) {
                                            maxnum = num;
                                            alpha = p;
                                            beta = q;
                                        }

                                    }

                                }
                            }
                            try{Thread.sleep(500);}catch(Exception d){}

                            if (test == true) {
                                colorEdgeButtons(btnarr[alpha][beta]);
                            }

                        });

                        root2.setConstraints(btnarr[i][j], i + xpos, j + xpos);
                        root2.getChildren().addAll(btnarr[i][j]);

                    }
                }

            }
            
            
        /**
        * this is the method where we color all the buttons.
        * and check the clicked button is valid or not.
        * then we call the gameover class if there is no valid buttons to press
        */

            void colorEdgeButtons(Button btn) {

                int x = 0, y = 0;
                //System.out.println("good");
                for (int i = 0; i < btnarr.length; i++) {
                    for (int j = 0; j < btnarr[i].length; j++) {
                        if (btnarr[i][j] == btn) {
                            x = i;
                            y = j;
                        }

                    }
                }

                if (btnState[x][y] != BtnState.GREEN && gameState != GameState.STARTED) {

                    return;
                }

                if (gameState == GameState.STARTED || gameState == GameState.COLUMN) {
                    int num = Integer.parseInt(btnarr[x][y].getText());
                    PlayerFirst += num;
                    gameState = GameState.ROW;
                    clicknum = 1;
                    test = true;
                } else if (gameState == GameState.ROW) {

                    for (int i = 0; i < btnarr.length; i++) {

                    }

                    int num = Integer.parseInt(btnarr[x][y].getText());
                    PlayerSecond += num;

                    gameState = GameState.COLUMN;
                }

                Initialization.firstLabel.setText(String.format("YOU  :  %3d", PlayerFirst));
                Initialization.secondLabel.setText(String.format("Computer  : %3d", PlayerSecond));

                //System.out.println("Player");
                //System.out.println(PlayerFirst + "  " + PlayerSecond);

                int l = btnarr[x].length;
                if (gameState == GameState.ROW) {
                    for (int m = 0; m < l; m++) {
                        if (btnState[m][y] == BtnState.RED) {
                            btnState[m][y] = BtnState.BLUE;
                            btnarr[m][y].setStyle("-fx-background-color: blue;-fx-text-fill: white");
                        }
                        if (btnState[m][y] == BtnState.GREEN) {
                            btnState[m][y] = BtnState.WHITE;
                            btnarr[m][y].setStyle("-fx-background-color: white;-fx-text-fill: red");
                        }

                        if (btnState[x][m] == BtnState.WHITE) {
                            btnarr[x][m].setStyle("-fx-background-color: green;-fx-text-fill: yellow");

                            btnState[x][m] = BtnState.GREEN;
                        }

                    }
                }
                try {
                    Thread.sleep(200);

                } catch (Exception e) {
                }
                if (gameState == GameState.COLUMN) {
                    for (int m = 0; m < l; m++) {
                        if (btnState[x][m] == BtnState.RED) {
                            btnState[x][m] = BtnState.BLUE;
                            btnarr[x][m].setStyle("-fx-background-color: blue;-fx-text-fill: white");
                        }
                        if (btnState[x][m] == BtnState.GREEN) {
                            btnState[x][m] = BtnState.WHITE;
                            btnarr[x][m].setStyle("-fx-background-color: white;-fx-text-fill: red");
                        }

                        if (btnState[m][y] == BtnState.WHITE) {
                            btnarr[m][y].setStyle("-fx-background-color: green;-fx-text-fill: yellow");

                            btnState[m][y] = BtnState.GREEN;
                        }

                    }
                }
                btnarr[x][y].setStyle("-fx-background-color: red;-fx-text-fill: white");
                btnState[x][y] = BtnState.RED;

                int test = 0;

                for (int i = 0; i < btnarr.length; i++) {
                    for (int j = 0; j < btnarr[i].length; j++) {
                        if (btnState[i][j] == BtnState.GREEN) {
                            test = 1;
                        }

                    }
                }

                if (clicknum != 0 && test == 0) {
                    gameState = GameState.FINISHED;
                }

                if (gameState == GameState.FINISHED) {
                    //System.out.println("game is finished");
                    clicknum = 0;
                    Initialization.flag = true;
                    GameOverAi gameoverobject = new GameOverAi();
                    gameoverobject.display(PlayerFirst, PlayerSecond);
                    return;
                }

            }

        });

        root2.setStyle("-fx-background-color: grey");

        myscene = new Scene(root2, Project1.xsize, Project1.ysize);
        myscene.getStylesheets().add(Project1.class.getResource("scenevsai.css").toExternalForm());

    }

}
