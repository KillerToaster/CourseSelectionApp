//  Assignment #: 6
//  Name: Isabella Hutchinson
//  StudentID: 1222695903
//  Lecture: 11:15-12:05 MWF
//  Description: GeneratePane creates a pane where a user can enter
//  course information and create a list of available courses.

import java.util.ArrayList;
import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a course
 * information and create a list of available courses.
 */
public class GeneratePane extends HBox {
   //instance variables
    private VBox leftMenu, rightMenu;
    private HBox layout;
    private GridPane gridPane;
    private Label courseTitle, instructorName, universityName, studentNum, errorMessage;
    private TextField courseInput, instructorInput, universityInput, studentInput;
    private Button addCourse;
    private TextArea courseDisplay;
    private ArrayList<Course> courseList;
    private SelectPane selectPane;
    private String displayText;
    // The relationship between GeneratePane and SelectPane is Aggregation
    //declare and init

    /**
     * CreatePane constructor
     *
     * @param list   the list of courses
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Course> list, SelectPane sePane) {
        courseList = list;
        selectPane = sePane;
        //create all labels
        courseTitle = new Label("Course Name");
        instructorName = new Label("Name of Instructor");
        universityName = new Label("Name of University");
        studentNum = new Label("Number of Students");
        errorMessage = new Label("");
        errorMessage.setTextFill(Color.RED);
        //create all textFields
        courseInput = new TextField();
        courseInput.setPromptText("ASU 101");
        instructorInput = new TextField();
        instructorInput.setPromptText("Navabi");
        universityInput = new TextField();
        universityInput.setPromptText("ASU");
        studentInput = new TextField();
        studentInput.setPromptText("45");
        //create all buttons
        addCourse = new Button("Add Course");
        //create all textAreas
        courseDisplay = new TextArea("No Courses");
        courseDisplay.setEditable(false);
        //create layout instances
        leftMenu = new VBox();
        rightMenu = new VBox();
        gridPane = new GridPane();
        layout = new HBox();
        //set gridPane parameters
        gridPane.setConstraints(courseTitle,0,0);
        gridPane.setConstraints(instructorName,0,1);
        gridPane.setConstraints(universityName,0,2);
        gridPane.setConstraints(studentNum,0,3);
        gridPane.setConstraints(courseInput,1,0);
        gridPane.setConstraints(instructorInput,1,1);
        gridPane.setConstraints(universityInput,1,2);
        gridPane.setConstraints(studentInput,1,3);
        gridPane.setConstraints(addCourse,1,4);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.getChildren().addAll(courseTitle,courseInput,instructorName,instructorInput,universityName,universityInput,studentNum,studentInput,addCourse);
        //add components to the layouts
        leftMenu.getChildren().addAll(errorMessage,gridPane);
        rightMenu.getChildren().addAll(courseDisplay);
        layout.getChildren().addAll(leftMenu,rightMenu);

		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
        //add all layouts to the scene
        this.getChildren().addAll(layout);
        //add action to button
        addCourse.setOnAction(new ButtonHandler());



		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
                // Bind button click action to event handler


    }

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a course" is pushed
     * or not, When the event occurs, it asks for course and instructor name, number of students enrolled,
     * and its university information from the relevant text fields, then create a
     * new course and adds it to the courseList. Meanwhile, it will display the course's
     * information inside the text area. using the toString method of the Course
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of student
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /**
         * handle Override the abstract method handle()
         */
        public void handle(ActionEvent event) {
            // Declare local variables
            Course newCourse;
            Instructor newInstructor;
            int numberOfStudents = 0;

            if(courseInput.getText().trim().isEmpty() || instructorInput.getText().trim().isEmpty() || universityInput.getText().trim().isEmpty() || studentInput.getText().trim().isEmpty())
                errorMessage.setText("Please fill out all fields.");
            else
            {
                try {

                     //Cast students Field to an integer, throws NumberFormatException if unsuccessful

                    numberOfStudents = Integer.valueOf(studentInput.getText());
                    newInstructor = new Instructor();
                    newInstructor.setLastName(instructorInput.getText());
                    newCourse = new Course(courseInput.getText(),newInstructor,universityInput.getText(),numberOfStudents);

                    // Data is valid, so create new Department object and populate data
                    // Loop through existing departments to check for duplicates
                    // and if exist do not add it to the list and display a message
                    //throw exception
                    int idx = 0;
                    boolean exception = false;
                    while(idx < courseList.size() && !exception)
                    {
                        if(newCourse.getInstructor().equals(courseList.get(idx).getInstructor()) || newCourse.getName().equals(courseList.get(idx).getName()))
                            exception = true;
                        idx++;
                    }
                    if (exception)
                        throw new RuntimeException("Course Already Exists");

                    courseList.add(newCourse);
                    selectPane.updateCourseList(newCourse);

                    if(courseList.size() == 1)
                        displayText = newCourse.toString();
                    else
                        displayText = displayText + newCourse.toString();
                    courseDisplay.setText(displayText);
                    errorMessage.setText("Course Successfully Added");
                }
                catch (NumberFormatException e) {
                    errorMessage.setText("Please enter a valid integer number");
                }
                catch (Exception e) {
                    // Catches generic exception and displays message
                    errorMessage.setText("Course is not added - already exist");
                }
            }
           
        }
    }
}


