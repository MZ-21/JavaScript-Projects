package LE3Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args){

        System.out.printf("====================================================");
        header(3,1);
        System.out.printf("\n====================================================");

        //creating MyStudent type
        DoublyLinkedList<MyStudent> mijgonList = new DoublyLinkedList<>();
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry",67.35);
        MyStudent s2 = new MyStudent("Luna",87.5);
        MyStudent s3 = new MyStudent("Vincent",60.5);
        MyStudent s4 = new MyStudent("Hermione",89.2);



        //adding elements to mijgonList
        mijgonList.addLast(s0);
        mijgonList.addLast(s1);
        mijgonList.addLast(s2);
        mijgonList.addLast(s3);

        //print statement
        System.out.println("\nAdding 4 students to the list.\nThe list content:");

        //printing out the list
        System.out.println(mijgonList);

        //print statement
        System.out.println("Adding Hermione to the list in between Luna and Vincent....\nThe list Content: ");

        //creating our linkedlist to have nodes pointing to previous and next node using findNode method --> this is uneccessary
        DoublyLinkedList.Node<MyStudent> st1 = new DoublyLinkedList.Node<>(s0,null,mijgonList.findNode(s1));
        DoublyLinkedList.Node<MyStudent> st2 = new DoublyLinkedList.Node<>(s1,mijgonList.findNode(s0),mijgonList.findNode(s2));
        DoublyLinkedList.Node<MyStudent> st3 = new DoublyLinkedList.Node<>(s3,mijgonList.findNode(s2),null);

        //adding s4 btwn s2 and s3
        mijgonList.addBetween(s4,mijgonList.findNode(s2),mijgonList.findNode(s3));

        //printing out the list contatining hermione
        System.out.println(mijgonList);

        //printing and calling footer
        System.out.printf("====================================================");
        footer(3,1);
        System.out.printf("\n====================================================");


    }
    //header method
    public static void header(int labE_number,int q_number){
        System.out.printf("\nLab Exercise %d-Q%d\nPrepared By: Mijgon Zekria\nStudent Number: 251245044\nGoal of this Exercise: to understand a doublyLinkedList, override toString method, and to create a findNode method!",labE_number,q_number);

    }
    //footer method
    public static void footer(int labE_number,int q_number){
        System.out.printf("\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off-Mijgon", labE_number,q_number);

    }

}
