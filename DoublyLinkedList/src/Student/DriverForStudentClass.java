package LE3Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    public static void main(String[] args) {

        //ArrayList<> of Students instantiated with no arguement constructor
        ArrayList<Student> studentsL = new ArrayList<>();

        //adding a student object using no-argument constructor
        Student s1 = new Student(); //creating a student type object

        //header method
        System.out.printf("====================================================");
        myHeader(s1,3,2);
        System.out.printf("\n====================================================");

        studentsL.add(s1);//adding s1 to studentsL which is our arrayList

        //adding a bunch of students in order using arguement constructor
        Student s2 = new Student("Harry", "Potter", 75.5);
        Student s3 = new Student("Ronald", "Weasly", 86.0);
        Student s4 = new Student("Hermione", "Granger", 91.7);
        Student s5 = new Student("Parvati", "Patil", 93.75);

        studentsL.add(s2);
        studentsL.add(s3);
        studentsL.add(s4);
        studentsL.add(s5);

        //printing the score-card by calling toString method of ArrayList
        System.out.printf("\nThe Score Card: \n%s\b\n", studentsL);

        //sorting it in ascending order
        Collections.sort(studentsL);
        System.out.printf("The sort list in terms of score in descending order....\n%s\b\n", studentsL);

        //creating a HelperClassCompareFirstName ref variable
        HelperClassCompareFirstNames fstNC = new HelperClassCompareFirstNames();
        //creating a HelperClassCompareLastName ref variable
        HelperClassCompareLastNames lstNC = new HelperClassCompareLastNames( );

        //sorting based on last name using collection's method sort
        studentsL.sort(lstNC);

        //printing out in terms of last name
        System.out.printf("The sorted list in terms of Last Names.... \n%s\b\n", studentsL);

        //printing out in terms of first name
        studentsL.sort(fstNC);
        System.out.printf("The sorted list in terms of First Names....\n%s\b\n", studentsL);

        //footer
        System.out.printf("====================================================");
        footer(3,2);
        System.out.printf("\n====================================================");

    }

    //header
    public static void myHeader(Student myInfo, int labE_number, int q_number) {
        System.out.printf("\nLab Exercise %d-Q%d\nPrepared By: %s %s\nStudent Number: 251245044\nGoal of this Exercise: to understand how comparable and comparator work!", labE_number,q_number,myInfo.getFirstName(),myInfo.getLastName());
    }
    //footer
    public static void footer(int labE_number,int q_number) {
        System.out.printf("\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off-Mijgon", labE_number, q_number);
    }
}
