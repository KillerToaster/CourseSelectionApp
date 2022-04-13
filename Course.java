
// Assignment #: 6
//  Name: Isabella Hutchinson
//  StudentID: 1222695903
//  Lecture: 11:15-12:05 MWF
// Description: This class creates and instance of Course which stores the course name, the instructor of the course,
//              the university of the course, and the number of students in it.

public class Course {

   // All these variables are private to avoid users from changing them accidentally
   private String courseName;
   private Instructor instructor;
   private String university;
   private int numStudents;


   // The default President constructor, with "?" for each parameter
   public Course()
   {
      this("?",null, "?", 0);
   }

   // The constructor uses the different setter methods to change the first and last name as well
   // as academic level for us.
   public Course(String name, Instructor instr, String univer, int num)
   {
      courseName = name;
      university = univer;
      //create a new instructor object
      instructor = new Instructor(instr);
      numStudents = num;
   }

   // Getter to get the first name
   public String getName()
   {
      return courseName;
   }

   // Getter to get the instructor name
   public Instructor getInstructor()
   {
      return new Instructor(instructor);
   }
   
   public int getNumStudents()
   {   return numStudents;
   
   }
   public void addStudent(int num)
   {     numStudents += num;
	   
   }
   // Setter to change the name
   public void setName(String someName)
   {
      courseName = someName;
   }
   public void setUniversity(String name)
   {   university = name;
   
   }

	public void setInstructor(String f, String l, String u, int num)
	{      
      this.instructor =  new Instructor(f, l, u, num);
   }
   // Prints out the information in format:
   public String toString()
   {
      return "Course name:\t" + courseName + " at " + university + "\nInstructor name: " + instructor.getLastName() +"\n\n";
   }

// this is the end of the class

}