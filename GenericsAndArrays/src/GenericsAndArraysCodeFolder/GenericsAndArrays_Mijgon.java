package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenericsAndArrays_Mijgon {
    public static void main(String[] args) throws Exception {

        System.out.printf("\n====================================================");
        //importing
        header(2);
        System.out.printf("\n====================================================");
        System.out.println("\nThis program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.\n");

        //Creating an ArrayList type ref var with integer tag
        ArrayList<Integer> refVI = new ArrayList(Arrays.asList(2, 3, 4, 3, 2, 2));

        ArrayList<String> refVS = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        //Array of pair type ref variable with sz of refVI or refVS
        Pair<Integer, String>[] pairSZI = new Pair[refVI.size()];

        //populating the Pair type array with ArrayList ref variables and assigning those values to key & value in Pair<> generic class
        for (int i = 0; i < pairSZI.length; i++) {
            pairSZI[i] = new Pair<>(refVI.get(i), refVS.get(i));
        }
        for (int i = 0; i < pairSZI.length; i++) {
            pairSZI[i] = new Pair<>(refVI.get(i), refVS.get(i));
        }
        Scanner inputScan = new Scanner(System.in);

        //allowing user input
        //try-catch block
        int x = 0;
        char r = 'y';
        while (r == 'y') {

            while (true) {
                try {
                    System.out.print("Enter Academic Year (2,3,or 4): ");
                    x = inputScan.nextInt();
                    if (x < 2 || 4 < x) {
                        throw new Exception();
                    }
                    break;

                } catch (Exception ex) {
                    System.out.print("Incorrect input! ");
                    inputScan.nextLine();

                }
            }
            ArrayList<String> leader = new ArrayList<>();
            for (int k = 0; k < pairSZI.length; k++) {
                if (pairSZI[k].getKey().equals(x)) {
                    leader.add(pairSZI[k].getValue());
                }

            }
            System.out.printf("Found %d leader(s) from year %d.\nHere is the list:\n" +
                    "%s\n", leader.size(), x, leader);
            System.out.printf("Do you with to continue? (Press y to continue or any other key to terminate): ");
            r = inputScan.next().charAt(0);
        }
        System.out.printf("====================================================");
        footer(2);
        System.out.printf("\n====================================================");
    }

    //methods
    //header
    public static void header(int num) {
        System.out.printf("\nLab Exercise %d-Q1\nPrepared By: Mijgon Zekria\nStudent Number: 251245044\nGoal of this Exercise: to use generic classes, ArrayList, and ArrayList methods!", num);

    }
    public static void footer(int num2){
            System.out.printf("\nCompletion of Lab Exercise %d-Q1 is successful!\nSigning off-Mijgon", num2);

        }
}