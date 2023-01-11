package Q2;


import java.util.Collections;
import java.util.Vector;
public class SortNameAndGrade {
    public static void main(String[] args) {

        //3 arrays with 8 first and last names and 8 random numbers between 60 and 85
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        //creating a vector class instance
        Vector<StudentGrade> sg = new Vector<>();

        //making student objects and adding each StudentGrade object to the Vector class with add method of Vector class
        for (int i = 0; i < fnArray.length; i++) {
            sg.addElement(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        //printing the unsorted array
        System.out.println("\nThe unsorted Array.......");
        System.out.println(sg + "\b");

        //sorting using collections' sort
        Collections.sort(sg);

        //printing the sorted array
        System.out.println("\nSorted by Grades.........");
        System.out.println(sg + "\b");

        //Creating an array of StudentGrade type
        StudentGrade[] arrSG = new StudentGrade[fnArray.length];

        //Copying sg to arrSG using Vector's copy
        sg.copyInto(arrSG);

        //sorting by first name
        sort(arrSG,1);

        //print statement
        System.out.println("\nSorted by First Names......");

        //printing sorted by firstName array
        printArray(arrSG);

        //sorting by last name
        sort(arrSG,2);

        System.out.println("\nSorted by Last Names......");
        //printing sorted by last name
        printArray(arrSG);

    }

    //sort method
    public static void sort(StudentGrade[] sg, Integer key) {

        if (key == 1) {
            int i=0; int j=0;
            for (i = 1; i < sg.length; i++) {
                StudentGrade k = sg[i]; //this is held constant until we return to first loop so it is always the value at i for the 2nd loop even if the actual value there switches bc of the 2nd loop,
                for (j = i - 1; j >= 0 && sg[j].getFirstName().compareTo(k.getFirstName()) > 0; j--) { //comparing firstname to other first name in the same array
                    sg[j + 1] = sg[j];

                }
                sg[j+1] = k;
            }
        }
        if (key == 2) {
            for (int i = 1; i < sg.length; i++) {
                StudentGrade k = sg[i]; //this is held constant until we return to first loop so it is always the value at i for the 2nd loop even if the actual value there switches bc of the 2nd loop, it's still the og one
                for (int j = i - 1; j >= 0 && sg[j].getLN().compareTo(k.getLN()) > 0; j--) {//comparing last name to other last name
                    sg[j + 1]=sg[j]; //swapping if first one is bigger than the 2nd
                    sg[j]=k;

                }
            }
        }
    }

    //print array method
    public static void printArray (StudentGrade[] sgA) {
        for (int i = 0; i < sgA.length; i++) {
            System.out.printf("%8s %8s :  %d\n", sgA[i].getFirstName(), sgA[i].getLN(), sgA[i].getG()); //creating a print statement to format the array
        }
    }

    //header & footer

}

