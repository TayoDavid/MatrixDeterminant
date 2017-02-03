package MatrixDeterminant;

/**
 * Created by Omotayo on 16/06/2016.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MatrixUI3_3 extends Application {
    private TextField text0_0 = new TextField();
    private TextField text0_1 = new TextField();
    private TextField text0_2 = new TextField();
    private TextField text1_0 = new TextField();
    private TextField text1_1 = new TextField();
    private TextField text1_2 = new TextField();
    private TextField text2_0 = new TextField();
    private TextField text2_1 = new TextField();
    private TextField text2_2 = new TextField();

    private TextField result = new TextField();

    @Override
    public void start(Stage primaryStage) {
        // Vbox contain all the children nodes i.e both child panes and nodes.
        VBox vBox = new VBox();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem fourByFour = new MenuItem("Four by four");
        fourByFour.setOnAction(e -> {
            MatrixUI4_4 det4_4 = new MatrixUI4_4();
            det4_4.start(primaryStage);
        });

        MenuItem threeByThree = new MenuItem("Three by three");
        threeByThree.setOnAction(e -> {
            start(primaryStage);
        });

        MenuItem twoByTwo = new MenuItem("Two by two");
        twoByTwo.setOnAction(e -> {
            MatrixUI2_2 det2_2 = new MatrixUI2_2();
            det2_2.start(primaryStage);
        });
        MenuItem exitapp = new MenuItem("Exit");
        exitapp.setOnAction(e -> Platform.exit());

        // File now contain four by four, three by three, and two by two.
        file.getItems().addAll(fourByFour, threeByThree, twoByTwo, exitapp);

        MenuItem randomValues = new MenuItem("Random values");
        randomValues.setOnAction(e -> {
            text0_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_2.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text2_2.setText(String.format("%d", (int)(Math.random() * 20)));
        });

        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction(e -> clearTextFields());
        // Edit menu now contain the random value option
        edit.getItems().addAll(randomValues, clear);

        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> {
            MatrixDeterminantUI aboutPage = new MatrixDeterminantUI();
            aboutPage.start(primaryStage);
        });
        // help menu now contain the about app option
        help.getItems().add(about);

        // Put all menus in the menubar
        menuBar.getMenus().addAll(file, edit, help);

        // Put the menubar in the vbox pane
        vBox.getChildren().add(menuBar);

        // Border pane will hold a grid pane in the center for textFields and
        // a stack pane to the right to hold the result.
        BorderPane borderPane = new BorderPane();

        GridPane pane = new GridPane();
        pane.add(text0_0, 0, 0);
        pane.add(text0_1, 1, 0);
        pane.add(text0_2, 2, 0);
        pane.add(text1_0, 0, 1);
        pane.add(text1_1, 1, 1);
        pane.add(text1_2, 2, 1);
        pane.add(text2_0, 0, 2);
        pane.add(text2_1, 1, 2);
        pane.add(text2_2, 2, 2);

        pane.setVgap(5);
        pane.setHgap(5);
        
        //Set the number of column for textFields
        text0_0.setPrefColumnCount(3);
        text0_1.setPrefColumnCount(3);
        text0_2.setPrefColumnCount(3);
        text1_0.setPrefColumnCount(3);
        text1_1.setPrefColumnCount(3);
        text1_2.setPrefColumnCount(3);
        text2_0.setPrefColumnCount(3);
        text2_1.setPrefColumnCount(3);
        text2_2.setPrefColumnCount(3);

        // Put pane at the center of border pane.
        pane.setPadding(new Insets(20, 0, 15, 30));
        borderPane.setCenter(pane);

        // Create a stack pane to hold the result Textfield
        // and put it on the right side of border pane.
        StackPane resultPane = new StackPane();
        result.setPrefColumnCount(3);
        resultPane.getChildren().add(result);
        resultPane.setPadding(new Insets(0, 30, 0, 5));
        resultPane.setAlignment(Pos.CENTER);
        borderPane.setRight(resultPane);

        vBox.getChildren().add(borderPane);

        // Create an HBox, add the buttons to it and
        // place it at the bottom of the vBox
        HBox buttonPane = new HBox();
        Button btDeterminant = new Button("Determinant");
        Button btClear = new Button("Clear");
        Button btCancel = new Button("Cancel");
        buttonPane.setPadding(new Insets(0, 10, 5, 10));
        btDeterminant.setOnAction(e -> {
            int[][] matrix = {{Integer.parseInt(text0_0.getText()), Integer.parseInt(text0_1.getText()), Integer.parseInt(text0_2.getText())},
                              {Integer.parseInt(text1_0.getText()), Integer.parseInt(text1_1.getText()), Integer.parseInt(text1_2.getText())},
                              {Integer.parseInt(text2_0.getText()), Integer.parseInt(text2_1.getText()), Integer.parseInt(text2_2.getText())}
            };
            result.setText(String.format("%d", Determinant3by3.getDeterminant(matrix)));
        });

        btClear.setOnAction(e -> {
            clearTextFields();
        });

        btCancel.setOnAction(e -> Platform.exit());

        // Add button to Hbox
        buttonPane.setSpacing(5);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        buttonPane.getChildren().addAll(btDeterminant, btClear, btCancel);

        vBox.getChildren().add(buttonPane);

        // Create a scene and set it in the stage
        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setTitle("Matrix Determinant");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void clearTextFields( ) {
        text0_0.setText("");
        text0_1.setText("");
        text0_2.setText("");
        text1_0.setText("");
        text1_1.setText("");
        text1_2.setText("");
        text2_0.setText("");
        text2_1.setText("");
        text2_2.setText("");

        result.setText("");
    }
}
