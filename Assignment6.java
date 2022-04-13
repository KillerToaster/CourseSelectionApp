// Assignment #: 6
//  Name: Isabella Hutchinson
//  StudentID: 1222695903
//  Lecture: 11:15-12:05 MWF
//  Description: The Assignment6 class creates a Tabbed Pane with
//               two tabs, one for course Creation and one for
//               course Selection.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application {
    private TabPane tabPane;
    private GeneratePane createPane;
    private SelectPane selectPane;
    private ArrayList<Course> courseList;

    public void start(Stage stage) {
        StackPane root = new StackPane();

        // courseList to be used in both generatePane & selectPane
        courseList = new ArrayList<Course>();

        selectPane = new SelectPane(courseList);
        createPane = new GeneratePane(courseList, selectPane);

        tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Add Course");
        tab1.setContent(createPane);
        tab1.setClosable(false);

        Tab tab2 = new Tab();
        tab2.setText("Select Course");
        tab2.setContent(selectPane);
        tab2.setClosable(false);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 900, 400);
        stage.setTitle("Course Selection App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}