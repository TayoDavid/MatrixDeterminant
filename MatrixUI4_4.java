package MatrixDeterminant;

/**
 * Created by Omotayo on 10/06/2016.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class MatrixUI4_4 extends Application {
    private TextField text0_0 = new TextField();
    private TextField text0_1 = new TextField();
    private TextField text0_2 = new TextField();
    private TextField text0_3 = new TextField();
    private TextField text1_0 = new TextField();
    private TextField text1_1 = new TextField();
    private TextField text1_2 = new TextField();
    private TextField text1_3 = new TextField();
    private TextField text2_0 = new TextField();
    private TextField text2_1 = new TextField();
    private TextField text2_2 = new TextField();
    private TextField text2_3 = new TextField();
    private TextField text3_0 = new TextField();
    private TextField text3_1 = new TextField();
    private TextField text3_2 = new TextField();
    private TextField text3_3 = new TextField();

    private TextField output = new TextField();         // Output field

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem fourByFour = new MenuItem("Four by four");
        fourByFour.setOnAction(e -> start(primaryStage));

        MenuItem threeBythree = new MenuItem("Three by three");
        threeBythree.setOnAction(e -> {
            MatrixUI3_3 det3_3 = new MatrixUI3_3();
            det3_3.start(primaryStage);
        });
        MenuItem twoByTwo = new MenuItem("Two by two");
        twoByTwo.setOnAction(e -> {
            MatrixUI2_2 twoByTwoMatrix = new MatrixUI2_2();
            twoByTwoMatrix.start(primaryStage);
        });
        MenuItem exitapp = new MenuItem("Exit");
        exitapp.setOnAction(e -> Platform.exit());
        // Add menu items to file menu
        file.getItems().addAll(fourByFour, threeBythree, twoByTwo, exitapp);


        // add menu items to the edit menu
        MenuItem randomValues = new MenuItem("Random values");
        randomValues.setOnAction(e -> {
            text0_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_3.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_3.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_3.setText(String.format("%d", (int)(Math.random() * 20)));
            text3_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text3_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text3_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text3_3.setText(String.format("%d", (int)(Math.random() * 20)));
        });

        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction(e -> clearFields());
        // add options to edit menu
        edit.getItems().addAll(randomValues, clear);

        // Add menu item to help menu
        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> {
            MatrixDeterminantUI mainUI = new MatrixDeterminantUI();
            mainUI.start(primaryStage);
        });
        // add about to help menu
        help.getItems().add(about);

        // Add menus to menubar
        menuBar.getMenus().addAll(file, edit, help);

        vBox.getChildren().add(menuBar);

        // The border pane form the main body of the pane
        BorderPane pane = new BorderPane();

        GridPane gridpane = new GridPane();
        gridpane.setVgap(5);
        gridpane.setHgap(5);
        gridpane.setPadding(new Insets(5, 5, 5, 25));
        gridpane.setAlignment(Pos.CENTER);

        text0_0.setPrefColumnCount(3);
        text0_1.setPrefColumnCount(3);
        text0_2.setPrefColumnCount(3);
        text0_3.setPrefColumnCount(3);
        text1_0.setPrefColumnCount(3);
        text1_1.setPrefColumnCount(3);
        text1_2.setPrefColumnCount(3);
        text1_3.setPrefColumnCount(3);
        text2_0.setPrefColumnCount(3);
        text2_1.setPrefColumnCount(3);
        text2_2.setPrefColumnCount(3);
        text2_3.setPrefColumnCount(3);
        text3_0.setPrefColumnCount(3);
        text3_1.setPrefColumnCount(3);
        text3_2.setPrefColumnCount(3);
        text3_3.setPrefColumnCount(3);

        gridpane.add(text0_0, 0, 0);
        gridpane.add(text0_1, 1, 0);
        gridpane.add(text0_2, 2, 0);
        gridpane.add(text0_3, 3, 0);
        gridpane.add(text1_0, 0, 1);
        gridpane.add(text1_1, 1, 1);
        gridpane.add(text1_2, 2, 1);
        gridpane.add(text1_3, 3, 1);
        gridpane.add(text2_0, 0, 2);
        gridpane.add(text2_1, 1, 2);
        gridpane.add(text2_2, 2, 2);
        gridpane.add(text2_3, 3, 2);
        gridpane.add(text3_0, 0, 3);
        gridpane.add(text3_1, 1, 3);
        gridpane.add(text3_2, 2, 3);
        gridpane.add(text3_3, 3, 3);

        pane.setCenter(gridpane);

        // Output text field
        StackPane outputPane = new StackPane();
        output.setPrefColumnCount(3);
        output.setEditable(false);
        outputPane.getChildren().add(output);
        pane.setRight(outputPane);
        BorderPane.setAlignment(outputPane, Pos.CENTER);
        outputPane.setPadding(new Insets(0,10,10,5));


        // Buttons
        HBox hBox = new HBox();
        Button btDeterminant = new Button("Determinant");
        Button btExit = new Button("Cancel");
        Button btClear = new Button("Clear");
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(0,10,10,10));


        // Process events
        btDeterminant.setOnAction(e -> computeDeterminant());
        btClear.setOnAction(e -> clearFields());
        btExit.setOnAction(e -> ExitDeterminant());

        hBox.getChildren().addAll(btDeterminant, btClear, btExit);
        pane.setBottom(hBox);

        vBox.getChildren().add(pane);
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setTitle("Matrix Determinant");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void computeDeterminant () {
        // Get values from text fields
        int[][] matrix = {{Integer.parseInt(text0_0.getText()), Integer.parseInt(text0_1.getText()),
                                  Integer.parseInt(text0_2.getText()), Integer.parseInt(text0_3.getText())},
                          {Integer.parseInt(text1_0.getText()), Integer.parseInt(text1_1.getText()),
                                  Integer.parseInt(text1_2.getText()), Integer.parseInt(text1_3.getText())},
                          {Integer.parseInt(text2_0.getText()), Integer.parseInt(text2_1.getText()),
                                  Integer.parseInt(text2_2.getText()), Integer.parseInt(text2_3.getText())},
                          {Integer.parseInt(text3_0.getText()), Integer.parseInt(text3_1.getText()),
                                  Integer.parseInt(text3_2.getText()), Integer.parseInt(text3_3.getText())} };

        output.setText(String.format("%d", Determinant4by4.MatrixDeterminant(matrix)));

    }

    private void clearFields() {
        text0_0.setText("");
        text0_1.setText("");
        text0_2.setText("");
        text0_3.setText("");
        text1_0.setText("");
        text1_1.setText("");
        text1_2.setText("");
        text1_3.setText("");
        text2_0.setText("");
        text2_1.setText("");
        text2_2.setText("");
        text2_3.setText("");
        text3_0.setText("");
        text3_1.setText("");
        text3_2.setText("");
        text3_3.setText("");

        output.setText("");
    }

    private void ExitDeterminant() {
        System.exit(1);
    }
}
