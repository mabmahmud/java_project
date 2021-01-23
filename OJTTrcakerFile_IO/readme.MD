                  ****File I/O in Java******** 
				  
				  
 
File I/O
Instructions
The topic for the assignments in CIS2232 will be to create an OJT reflection application.  This will allow you apply the concepts to a familiar business need.  The program should be submitted in your assignments Bitbucket repository in a folder called Assignment1.

Business Requirement 1 (Menu option A)
When the user selects ‘A’ (for Add) - allow the user to enter the student id, name, and reflection text.  No validation is required and the user can be expected to enter the right values.  An object oriented solution is expected.  An OjtReflection class should be used to contain the attributes.

When all the entries are added to an ArrayList<OjtReflection> the details should be written to a file (/cis2232/reflection.json).  This can happen when the user exits the program.  Reflection should be encoded as json and written to the file on a line per reflection.  (Note:  if you prefer to use comma separated instead...that's fine too!)

Business Requirement 2
When the program starts, if the file created above exists it should be used to load the ArrayList<OjtReflection>.  This will eliminate the need for the program to prompt for the attributes each time the program is run.  

Business Requirement 3 (Menu option S)
Show all of the reflections details to the console.  As well at the top (before the list of reflections), it should show the total number of reflections (a count of all of the reflections). 



Sample i/o to demonstrate option U
Choice: A

Student id: 12345

Name: Joe Smith

Reflection:  We obtained access to the network

Choice: U 

Student id:  12345

Additional reflection:  This week we used version control

Here are the reflections:

Student id: 12345

Name: Joe Smith

Reflection

We obtained access to the network

This week we used version control