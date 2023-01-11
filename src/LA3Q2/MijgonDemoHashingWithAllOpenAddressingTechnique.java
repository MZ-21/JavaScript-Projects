package LA3Q2;
import LA3Q1.*;
import static LA3Q1.MijgonDemoHashingWithLinearAddressing.*;
import java.util.*;

import static LA3Q1.MijgonDemoHashingWithLinearAddressing.*;

public class MijgonDemoHashingWithAllOpenAddressingTechnique {
    public static void main(String[] args){
        //header
        System.out.print("====================================================");
        header(3,2);
        System.out.printf("\n====================================================");

        //instantiating scanner
        input = new Scanner(System.in);
        //allowing user to input data items
        System.out.print("\nHow many data items: ");
        items = input.nextInt();

        //allowing user to input load factor
        System.out.print("What is the load factor (Recommended:<=0.5): ");
        lf =input.nextDouble();

        //Finding table capacity using nearest prime
        tableCapacity = checkPrime((int)(items/lf));
        System.out.printf("The minimum required table capacity would be: %d \n",tableCapacity);

        //Creating a MijgonValueEntry type array with inputted table capacity
        hashTable = new MijgonValueEntry[tableCapacity];

        //filling the hashTable with MijgonValueEntry type objects
        for(int i=0;i<hashTable.length;i++){
            hashTable[i] = new MijgonValueEntry();
        }

        //creating Integer type array
        Integer[] intA = {-11,22,-33,-44,55};

        //print above array using print array method
        System.out.print("The given dataset is: "); printArray(intA);
        System.out.println("\nLet's enter each data item from the above to the hash table:");

        //print statement
        System.out.print("\nAdding data - linear probing resolves collision");//printing statement

        //adding each value from intA to hashTable using addValueLinearProbe
        for(int i=0;i<intA.length;i++){
            addValueLinearProbe(intA[i]);
        }
        //printing hashTable by calling printHashTable()
        printHashTable();

        //reseting hashTable using emptyHashTable() Method
        emptyHashTable();

        //using addValueQuadraticProbe method to add values to the newly reset hashTable
        for(int i=0;i<intA.length;i++) {
            addValueQuadraticProbe(intA[i]);
        }
        System.out.print("\nAdding data - quadratic probing resolves collision");
        if(lf>0.5){System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");}

        //printing hashTable
        printHashTable();

        //reseting hashTable
        emptyHashTable();

        //print statement
        System.out.println("\nAdding data - double-hashing resolves collision");
        //adding the values from integer array using addDoubleHashing method
        for (int i=0;i<intA.length;i++) {
            addValueDoubleHashing(intA[i]);
        }
        System.out.printf("The q value for double hashing is: %d",thePrimeNumberForSecondHashFunction(tableCapacity));
        //printing the table
        printHashTable();

        //calling footer
        System.out.print("====================================================");
        footer(3,2);
        System.out.printf("\n====================================================\n");


    }

    //methods

    //addValueDoubleHashing method ~ method that adds a value into the hash table based on double hashing
    public static void addValueDoubleHashing(Integer k) {
        int q = thePrimeNumberForSecondHashFunction(tableCapacity); //using this method to find the next smaller prime

        int h1 = k % tableCapacity; //first hashFunction which is the key mod tableCapacity

        //if the h1 is negative, then making it positive to find an index
        if(h1<0){
            h1 = h1+tableCapacity;
        }
        //2nd hash function incase the first has a collision
        int h2 = q - (k % q);
        boolean flag = false; //creating a flag to tell the loop to stop when a spot is found

        //for loop to go through hashTable
         for (int i = 0; i < tableCapacity&&!flag; i++) {
             int probe = h1 + (i * h2); //the 2nd hashfunction only occurs if there is a collision and increase by i each collision

             //ensuring probe isnt greater than table size
             if (probe >= tableCapacity) {
                 probe = probe % tableCapacity;
             }

             //if the spot at probe is null then set the key there and make the flag true
             if (hashTable[probe].getKey()==-1) {
                 hashTable[probe].setKey(k);
                 flag=true;
             }
         }

    }
    //Method thagt finds the nearest prime number below c
    public static int thePrimeNumberForSecondHashFunction(int c){
        c=c-1; //don't want the hashTable to be the size c, only less even if c is prime
        int m = c / 2;
        for (int i = 3; i <= m; i++) {
            if (c % i == 0) {
                i = 2; //resetting i to 2 so that the next n is checked if it's divisble by 3
                c--; //checking the value below n since n is not prime
                m = c/ 2; //check half of n because n can't be divisble by n/2>
            }
        }
        return c;
    }
    //Method that resets hashTable to being filled with null values
    public static void emptyHashTable(){
        for(int i=0;i<tableCapacity;i++){
            hashTable[i].setKey(-1); //filling hashTable with nulll values
        }
    }
    //Method to print the hashTable
    public static void printArray(Integer[] a){
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");  //printing out each element in array
        }
        System.out.print("\b]"); //closing array and removing last comma
    }

    //method that adds keys to the hashTable using quadratic probing way
    public static void addValueQuadraticProbe(Integer k){

        //finding hashcode
        int hashC = k%tableCapacity;

        //if the hashCode is a negative number, adding tablecapacity so that it is positive again
        if(hashC<0){
            hashC = hashC + tableCapacity;
        }

        //creating a flag to tell the for loop when a spot for the key has been found
        boolean flag = false;

        //for loop goes through the table to find a spot for the key -> Condition is i must be less than tableC & the flag must be false which means a spot hasnt been found
        for(int i=0;i<tableCapacity &&!flag;i++){
            int probe = (int)(hashC + Math.pow(i,2)); //quadratic probe is navigating the table using a squared term + og hashCode

            //since jumping by square + k, have to make sure the probe doesnt get bigger than the table
            if(probe>=tableCapacity){
                probe = probe%tableCapacity; //reseting probe to fit bounds of the table
            }

            //if the space is null, then place it here and set the flag to true
            if(hashTable[probe].getKey()==-1){
                hashTable[probe].setKey(k);
                flag=true;}
        }
    }
    //header and footer methods
    public static void header(int num,int num2) {
        System.out.printf("\nLab Assignment %d, Q%d\nPrepared By: Mijgon Zekria\nStudent Number: 251245044\nGoal of this Exercise: to make a hashTable and place values in the correct spot using different probing and hashing techniques", num,num2);

    }
    public static void footer(int num,int num2){
        System.out.printf("\nCompletion of Lab Assignment %d, Q%d is successful!\nSigning off-Mijgon",num,num2);

    }
}
