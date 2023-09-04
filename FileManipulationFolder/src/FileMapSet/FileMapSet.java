package LE4Q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class mijgonExcerciseOnFileMapSet {
    public static void main(String[] args) throws FileNotFoundException {

        //header
        System.out.print("====================================================");
        header(4);
        System.out.printf("\n====================================================\n");

        //creating a file onject ref & checking if file called SE2205Students.txt exists
        File se2205 = new File("C:/Users/MZ16/OneDrive/Desktop/extra school/SE2205Students.txt");

        //Extracting the last names
        Scanner inputFile = new Scanner(se2205);
        Scanner inputFile2 = new Scanner(se2205);

        System.out.println("List of the Number of students with the same Last Names:\n Last-name\t\t\tnumbers\n--------------------------------");
        printNames(lastN(inputFile));

        System.out.println("List of the Number of students with the same First Names:\n First-name\t\t\tnumbers\n--------------------------------");
        printNames(firstN(inputFile2));

        //footer
        System.out.print("====================================================");
        footer(4);
        System.out.println("\n====================================================");


    }

    public static Map<String, Integer> lastN(Scanner s) {
        Map<String, Integer> map = new TreeMap<>();

        while (s.hasNext()) {
            String st = s.nextLine();
            String[] lNA = st.split(" "); //splitting the name by " "
            String lN = lNA[0];


            if (map.containsKey(lN)) {
                int value = map.get(lN) + 1;
                map.put(lN, value);
            } else {
                map.put(lN, 1);
            }

        }
        s.close();
        return map;
    }

    public static Map<String, Integer> firstN(Scanner s) {
        Map<String, Integer> map = new TreeMap<>();

        while (s.hasNext()) {
            String st = s.nextLine();
            String[] fNA = st.split(" ");
            String fN = fNA[fNA.length-1];

            if (map.containsKey(fN)) {
                int value = map.get(fN) + 1;
                map.put(fN, value);
            } else {
                map.put(fN, 1);
            }
        }
        s.close();
        return map;
    }

    public static void printNames(Map<String,Integer> m) {
        Set<Map.Entry<String, Integer>> s = m.entrySet();

        for (Map.Entry<String, Integer> it : s) {
            if (it.getValue() > 1) {
                System.out.printf("%11s\t\t\t%d\n", it.getKey(), it.getValue());
            }

        }


    }
    public static void header(int num) {
        System.out.printf("\nLab Exercise %d\nPrepared By: Mijgon Zekria\nStudent Number: 251245044\nGoal of this Exercise: to extract key and value from a file and place it into a tree-map!", num);

    }
    public static void footer(int num2){
        System.out.printf("\nCompletion of Lab Exercise %d is successful!\nSigning off-Mijgon", num2);

    }
}