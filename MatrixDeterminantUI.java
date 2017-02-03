package MatrixDeterminant;

/**
 * Created by Omotayo on 14/06/2016.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class MatrixDeterminantUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a vertical box and place the content inside.
        VBox mainUI = new VBox();

        // Create the menuBar and add menu items to the menu.
        MenuBar mymenu = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        // Menu items in file
        MenuItem fourByFour = new MenuItem("Four by four");
        MenuItem threeByThree = new MenuItem("Three by three");
        MenuItem twoByTwo = new MenuItem("Two by two");
        MenuItem exitapp = new MenuItem("Exit");

        fourByFour.setOnAction(e -> {
            MatrixUI4_4 matrixUI = new MatrixUI4_4();
            matrixUI.start(primaryStage);
        });

        threeByThree.setOnAction(e -> {
            MatrixUI3_3 det3_3 = new MatrixUI3_3();
            det3_3.start(primaryStage);
        });

        twoByTwo.setOnAction(e -> {
            MatrixUI2_2 twoByTwoMatrix = new MatrixUI2_2();
            twoByTwoMatrix.start(primaryStage);
        });

        exitapp.setOnAction(e -> Platform.exit());

        file.getItems().addAll(fourByFour, threeByThree, twoByTwo, exitapp);

        // Note there is no edit menu for the welcome stage
        // Menu items for help menu
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> start(primaryStage));

        help.getItems().add(about);
        // Add all menus to the menu bar
        mymenu.getMenus().addAll(file, edit, help);

        mainUI.getChildren().add(mymenu);

        // This pane contain the welcome note in label.
        StackPane labelPane = new StackPane();
        Label label = new Label("Welcome to Matrix \ndeterminant app." +
                "\n" + "    " + (char)169 + "omotayo");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        labelPane.getChildren().add(label);
        labelPane.setAlignment(Pos.CENTER);
        labelPane.setPadding(new Insets(40, 10, 0, 10));

        mainUI.getChildren().add(labelPane);

        Scene scene = new Scene(mainUI, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
