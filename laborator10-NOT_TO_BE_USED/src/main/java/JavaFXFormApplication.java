import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXFormApplication extends Application {

    //UserService userService = new UserService();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {
        //creating label for name search
        Text text1 = new Text("Search users by name");

        //creating label id search
        Text text2 = new Text("Search users by id");

        //Creating Text Field name search
        TextField textField1 = new TextField();

        //Creating Text Field for id search
        TextField textField2 = new TextField();


        //Scene 2
        Label label2= new Label("This is the second scene");
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2);
        Scene scene2 = new Scene(layout2, 800, 500);

        //Creating Buttons
        Button button1 = new Button("Search");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //userService.searchByName(textField1.getText());
                System.out.println("caut dupa: "+textField1.getText());
                layout2.getChildren().addAll(new Label(textField1.getText()));
                stage.setScene(scene2);
            }
        });

        Button button2 = new Button("Clear");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
            }
        });

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(800, 500);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Grid Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

}
