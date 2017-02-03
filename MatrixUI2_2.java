package MatrixDeterminant;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.event.*;
import javafx.stage.Stage;

/**
 * Created by Omotayo on 16/06/2016.
 */

public class MatrixUI2_2 extends Application {
    private TextField text0_0 = new TextField();
    private TextField text0_1 = new TextField();
    private TextField text1_0 = new TextField();
    private TextField text1_1 = new TextField();
    private TextField result = new TextField();

    @Override
    public void start(Stage primaryStage) {
        // The main containing node
        VBox vBox = new VBox();
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        // Menu items for file
        MenuItem fourByFour = new MenuItem("Four by Four");
        MenuItem threeByThree = new MenuItem("Three by three");
        MenuItem twoByTwo = new MenuItem("Two by two");
        MenuItem exitapp = new MenuItem("Exit");

        fourByFour.setOnAction(e -> {
            MatrixUI4_4 det4_4 = new MatrixUI4_4();
            det4_4.start(primaryStage);
        });

        threeByThree.setOnAction(e -> {
            MatrixUI3_3 det3_3 = new MatrixUI3_3();
            det3_3.start(primaryStage);
        });

        twoByTwo.setOnAction(e -> {
            start(primaryStage);
        });

        exitapp.setOnAction(e -> Platform.exit());
        // Add menu items to file menu
        file.getItems().addAll(fourByFour, threeByThree, twoByTwo, exitapp);

        // Edit menu
        MenuItem randomValues = new MenuItem("Random values");
        randomValues.setOnAction(e -> {
            text0_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text0_1.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_0.setText(String.format("%d", (int)(Math.random() * 20)));
            text1_1.setText(String.format("%d", (int)(Math.random() * 20)));
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

        menuBar.getMenus().addAll(file, edit, help);
        vBox.getChildren().add(menuBar);
        // Call the stage for MatrixUI4_4 i.e four by four

        BorderPane paneContainer = new BorderPane();
        GridPane pane = new GridPane();

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(25, 10, 10, 30));

        pane.add(text0_0, 0, 0);
        pane.add(text0_1, 1, 0);
        pane.add(text1_0, 0, 1);
        pane.add(text1_1, 1, 1);

        text0_0.setPrefColumnCount(3);
        text0_1.setPrefColumnCount(3);
        text1_0.setPrefColumnCount(3);
        text1_1.setPrefColumnCount(3);

        result.setPrefColumnCount(3);

        pane.setAlignment(Pos.CENTER);
        // BorderPane is the container for both the gridpane and the Textfield (result).
        paneContainer.setCenter(pane);

        // this pane will put the result textfeild at the center.
        StackPane resultPane = new StackPane();
        resultPane.getChildren().add(result);
        resultPane.setPadding(new Insets(20, 50, 0, 5));

        // The border pane then set the stackpane containing the result textfeild to the right
        paneContainer.setRight(resultPane);
        // paneContainer.setAlignment(resultPane, Pos.CENTER);

        // HBox will set the button horizontally together.
        HBox buttons = new HBox();
        Button btDeterminant = new Button("Determinant");
        Button btClear = new Button("Clear");
        Button btCancel = new Button("Cancel");
        buttons.setSpacing(5);
        buttons.setAlignment(Pos.BASELINE_CENTER);

        // set on action the determinant button press
        btDeterminant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                compute2_2Det();
            }
        });

        // set on action on clear button press
        btClear.setOnAction(e -> {
            clearTextFields();
        });

        // set on action on cancel press
        btCancel.setOnAction(e -> Platform.exit());

        buttons.getChildren().addAll(btDeterminant, btClear, btCancel);

        paneContainer.setBottom(buttons);

        vBox.getChildren().add(paneContainer);


        buttons.setPadding(new Insets(10, 5, 5, 5));
       // vBox.getChildren().add(buttons);


        // Set scene and place it inside the stage
        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setTitle("Matrix Determinant");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void compute2_2Det() {
        int[][] matrix = {{Integer.parseInt(text0_0.getText()), Integer.parseInt(text0_1.getText())},
                {Integer.parseInt(text1_0.getText()), Integer.parseInt(text1_1.getText())} };

       // Determinant2by2 det2_2 = new Determinant2by2();
        result.setText(String.format("%d", Determinant2by2.getDeterminant(matrix)));
    }

    public void clearTextFields() {
        text0_0.setText("");
        text0_1.setText("");
        text1_0.setText("");
        text1_1.setText("");

        result.setText("");
    }
}
