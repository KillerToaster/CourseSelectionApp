// Assignment #: 6
//  Name: Isabella Hutchinson
//  StudentID: 1222695903
//  Lecture: 11:15-12:05 MWF
// Description: This class creates an instance of an Instructor object which includes their first and last name, office
//              number, and the number of their courses.

public class Instructor {

   // All these variables are private to avoid users from changing them accidentally
   private String firstName;
   private String lastName;
   private String officeNum;
   private int numCourses;

   // The default constructor, with "?" for each parameter
   public Instructor()
   {
      this("?","?","?",0 );
   }

   // The constructor accepts arguments for the first, last and office number
   public Instructor(String first, String last, String office, int num)
   {
      firstName = first;
      lastName = last;
      officeNum = office;
      numCourses = num;
   }
   public Instructor(Instructor object2)
   {	    lastName = object2.lastName;
   		firstName = object2.firstName;
   		officeNum = object2.officeNum;
   		numCourses = object2.numCourses;
    }

   // Getter to get the first name
   public String getFirstName()
   {
         return firstName;
   }

   // Getter to get the last name
   public String getLastName()
   {
         return lastName;
   }

   // Getter to get the office number
   public String getOfficeNum()
   {
         return officeNum;
  }

  // Setter to change the first name
  public void setFirstName(String someFirstName)
  {
         firstName = someFirstName;
  }

  // Setter to change the last name
  public void setLastName(String someLastName)
     {
        lastName = someLastName;
     }

     // Setter to change the academic level
  public void setOfficeNum(String office)
  {
        officeNum  = office;
   }
  public void setNumCourses(int num)
  {		numCourses = num;
  
  }
   public String toString()
   {  //create a string representing teh object
      String str = "\nLast Name:\t" + lastName + "\nFirst Name:\t" + firstName
      				+ "\nOffice Number:\t" + officeNum + "\n";
      return str;
	}
}


