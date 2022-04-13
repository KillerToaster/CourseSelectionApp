// Assignment #: 6
//  Name: Isabella Hutchinson
//  StudentID: 1222695903
//  Lecture: 11:15-12:05 MWF
//  Description: SelectPane displays a list of available courses
//  from which a user can select and compute total number of students in multiple courses.

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;

/**
* SelectPane displays a list of available courses from which a user
* can select and compute total number of students for selected courses.
*/
public class SelectPane extends BorderPane {

    private Label selectCourses, numOfStudents;
    private ScrollPane scrollPane;
    private VBox scrollBox;
    private BorderPane borderPane;
    private CheckBox courses;
    private ArrayList<Course> courseList;
    private int totalStudents;


    public SelectPane(ArrayList<Course> list) {
        //create labels and instantiate variable values
        this.courseList = list;
        totalStudents = 0;
        selectCourses = new Label("Select Course(s)");
        numOfStudents = new Label("Total number of students for the selected courses: " + totalStudents);
        scrollBox = new VBox();
        //create the layout
        scrollPane = new ScrollPane();
        scrollPane.setContent(scrollBox);
        this.setTop(selectCourses);
        this.setCenter(scrollPane);
        this.setBottom(numOfStudents);

    } // end of SelectPane constructor



    // This method uses the newly added parameter Course object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateCourseList(Course newCourse) {
        // Create checkbox for new course with appropriate text
        // Bind checkbox toggle action to event handler
        // Passes the number of students in each course to the handler. When the checkbox is
        // toggled, this number will be added/subtracted from the total number of selected students
        // Add new checkbox to checkbox container

        CheckBox newCheckBox = new CheckBox(newCourse.toString());
        newCheckBox.setOnAction(new SelectionHandler(newCourse.getNumStudents()));
        scrollBox.getChildren().add(newCheckBox);
        scrollPane.setContent(scrollBox);
        this.setCenter(scrollPane);

    }



    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected students.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of students associated with a given course/checkbox
        private int numStudents;

        public SelectionHandler(int nums) {
            this.numStudents = nums;
        }

        //over-ride the abstract method handle
        public void handle(ActionEvent event) {
            //check is CheckBox is selected
            if (((CheckBox)event.getSource()).isSelected())
                totalStudents = totalStudents + this.numStudents;
            else
                totalStudents = totalStudents - this.numStudents;
            numOfStudents.setText("Total number of students for the selected courses: " + totalStudents);
        }
    }

}
