package LA3Q1;
import java.util.*;

public class MijgonDemoHashingWithLinearAddressing {
    public static void main(String[] args) {

        //header
        System.out.print("====================================================");
        header(3,1);
        System.out.printf("\n====================================================\n");

        //prompting user for number of items and load factor
        System.out.println("Let's decide on the intital table capacity based on the load factor and dataset size");
        input = new Scanner(System.in);
        System.out.print("How many data items: ");
        items = input.nextInt();
        System.out.print("What is the load factor(Recommended: <=0.5): ");
        lf = input.nextDouble();
        //finding capacity using number of items, load factor, and nearest prime method
        tableCapacity = checkPrime((int) (items / lf));
        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);

        //instantiating and filling null values in array hashTable and workingHashTable
        hashTable = new MijgonValueEntry[tableCapacity];
        workingHashTable = new MijgonValueEntry[tableCapacity];

        //filling hashTable with mijgonValueEntry objects
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new MijgonValueEntry();
        }

        //Adding new values to array
        for (int j = 0; j < items; j++) {
            System.out.printf("Enter item %d: ", j + 1);
            int x = input.nextInt(); //allowing user to input next value
            addValueLinearProbe(x); //calling the addValueLinearProbe function each time need to add a value
        }
        //printing the table
        printHashTable();//calling printHashTable method to print elements in table

        //allowing user to remove a value using removeLinearPRobe method
        System.out.print("\nLet's remove two values from the table and then add one.......\n\nEnter a value you want to remove: ");
        int rV = input.nextInt();
        removeValueLinearProbe(rV);

        //printing hashTable with removed value
        printHashTable();

        //removing another value and printing the hashTable again
        System.out.print("Enter a value you want to remove: ");
        int v = input.nextInt();
        removeValueLinearProbe(v); //using removeValueprobe to remove inputted value
        printHashTable();//printing the hash table

        //ADDING  a new value to the hashtable using addValueLinearPRobe method
        System.out.print("Enter a value to add to the table: ");
        int addV = input.nextInt();
        addValueLinearProbe(addV);
        printHashTable(); //printing the hash table

        //rehashing the table
        reHashingWithLinearProbe();
        System.out.println();
        printHashTable();

        //printing footer
        System.out.print("====================================================");
        footer(3,1);
        System.out.println("\n====================================================");


    }

    //fields
    public static int items;  //holds number data items to add to hash table
    public static Scanner input;  //scanner type object ref
    public static double lf; //record load factor
    public static int tableCapacity; //store table capacity
    public static MijgonValueEntry[] hashTable; //Array ref of MijgonValueEntry type
    public static MijgonValueEntry[] workingHashTable; //used to store copy of hashTable ref for rehashing

    //methods

    //adding values to the hash table using linear probe method
    public static void addValueLinearProbe(Integer k) {
        int hashI = k % tableCapacity; //finding hashcode
        boolean flag = false; //making flag to ensure the for loop knows when to stop

        //if the hash code is negative, ensuring the index is positive
        if (hashI < 0) {
            hashI = hashI + tableCapacity;
        }

        //Loops through to check if there is a null or available space to place the key
        for (int i = hashI; i < tableCapacity; i++) {
            if ((hashTable[i].getKey() == -1 || hashTable[i].getKey() == -111) && !flag) {
                hashTable[i].setKey(k);
                flag = true;
            }
        }
        //for loop to check if there isnt a null or available space above the hash index, then cheching below the hashcode
        for (int i = 0; i < hashI && !flag; i++) {
            if ((hashTable[i].getKey().equals(-1) || hashTable[i].getKey() == -111)) {
                hashTable[i].setKey(k);
                flag = true;
            }
        }
    }
    //finding a prime number for the table capacity
    public static int checkPrime(int n) {
        int m = n / 2;
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2; //resetting i to 2 so that the next n is checked if it's divisble by 3
                n++; //checking the next n value since n is not prime
                m = n / 2; //check half of n because n can't be divisble by n/2>
            }
        }
        return n;
    }

    //removing a value from the hash table
    public static void removeValueLinearProbe(Integer k) {
        int hashI = k % tableCapacity; //finding hash code

        //if the hashcode is negative, ensuring it can be placed inside the table
        if (hashI < 0) {
            hashI = hashI + tableCapacity;
        }
        //looping through to find the key to remove it from the table starting from the index it should be at
        for (int i = hashI; i < tableCapacity; i++) {
            if (hashTable[i].getKey().equals(k)) {//if the hashtable is at this index
                hashTable[i].setKey(-111);          //set the spot to available which removes the key
                System.out.printf("%d is Found and removed! ",k);
                break; //breaking out of the if statement
            }
            else if (hashTable[i].getKey().equals(-1)) { //if the value isnt there (aka we encounter a null value then the value isnt there)
                System.out.printf("%d is not found! ", k);
                break; //break out of the if statement
            }
        }
    }

    //printing out the hash table
    public static void printHashTable() {
        System.out.print("The Current Hash-Table: ");
        System.out.print("[");
        for (int i = 0; i < tableCapacity; i++) {
            if (hashTable[i].getKey().equals(-1)) { //if the value there is null then print out null
                System.out.print("null,");
            } else if (hashTable[i].getKey().equals(-111)) { //if the value there is available then print out available
                System.out.print("available,");
            } else {
                System.out.print(hashTable[i].getKey() + ",");//else print out the key
            }

        }
        System.out.print("\b]\n");
    }
    //rehashing with linear probe
    public static void reHashingWithLinearProbe() {
        //copying the array so we can still access the values need to move to new table
        System.arraycopy(hashTable, 0, workingHashTable, 0, hashTable.length);
        tableCapacity = checkPrime(tableCapacity*2); //increasing table capacity

        //print statement
        System.out.printf("\nRehashing the tabble...\nThe rehashed table capacity is: %d",tableCapacity);

        //ensuring hashtable has new capacity and filling null spaces with MijgonValueEntry(objects)
        hashTable = new MijgonValueEntry[checkPrime(tableCapacity)];
        for (int j = 0; j < hashTable.length; j++) {
            hashTable[j] = new MijgonValueEntry();
        }

        //getting value from old hashtable and putting into new hashtable according to the correct hashcode ~ if statement is to remove available spaces
        for (int i =0; i < workingHashTable.length; i++) {
            if(workingHashTable[i].getKey().equals(-111)){
                workingHashTable[i].setKey(-1);
            }
            addValueLinearProbe(workingHashTable[i].getKey());//adding values to new hash table
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
