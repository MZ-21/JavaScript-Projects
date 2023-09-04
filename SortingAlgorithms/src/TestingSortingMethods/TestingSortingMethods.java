package Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class TestingSortingMethods {
    public static void main(String[] args) {

        //integer type array
        Integer[] sz = new Integer[50000];

        //back-up array
        Integer[] bckUp = new Integer[sz.length];

        //populating the array with random numbers between 13 and 93
        for (int i = 0; i < sz.length; i++) {
            int random = (int) (Math.random() * (93 - 13) + 13);
            sz[i] = random;
        }
        //copying the array to the backup
        System.arraycopy(sz, 0, bckUp, 0, sz.length);

        //making a List<> for array to use it's toString method. We dont use new here because they're not independent copies
        List<Integer> list = Arrays.asList(sz);

        //print statement
        System.out.println("Testing execution time of different sorting methods for sorting 50000 random numbers:");
        //System.out.println("The unsorted list: " + list);

        //sorting first array using Collections & testing the time it takes
        long start = System.nanoTime();

        Collections.sort(list);

        long end = System.nanoTime();

        //time difference btwn start and end
        double timeT = (end - start) / 1e6;

        /*System.out.printf("Collections' Sorting Time: %.2f milliseconds", timeT);

        //printing out the sorted list
        System.out.println("\nThe sorted list using Collections' sort method: " + list);

        //Selection Sort

        //Bubble sort

        //copying the backup to first array to make sure using the same unsorted array each time
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //calling bubblesort and passing it the unsorted array
        System.out.println("\nThe unsorted list: " + list); //printing out the unsorted array

        System.out.printf("My Bubble-sort Time: %.2f milliseconds", bubbleSort(sz) / 1e6);
        System.out.println("\nThe sorted list: " + list);

        //repeat steps for insertion sort
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //printing unsorted list
        System.out.println("\nThe unsorted list: " + list);

        //calling insertion sort
        System.out.printf("My Insertion-sort Time: %.2f milliseconds", insertionSort(sz) / 1e6);
        //the sorted list
        System.out.println("\nThe sorted list: " + list);

        //repeat steps for selection sort
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //printing unsorted list
        System.out.println("\nThe unsorted list: " + list);

        //calling insertion sort
        System.out.printf("My Selection-sort Time: %.2f milliseconds", selectionSort(sz) / 1e6);
        //the sorted list
        System.out.println("\nThe sorted list: " + list);

        //repeat steps for merge sort
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //printing unsorted list
        System.out.println("\nThe unsorted list: " + list);

        //calling merge sort
        System.out.printf("My Merge-sort Time: %.2f milliseconds", mergeSort(sz) / 1e6);
        //the sorted list
        System.out.println("\nThe sorted list: " + list);

        //repeat steps for quick sort
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //printing unsorted list
        System.out.println("\nThe unsorted list: " + list);

        //calling quick sort
        System.out.printf("My Quick-sort Time: %.2f milliseconds", quickSort(sz, 0, sz.length - 2) / 1e6);
        //the sorted list
        System.out.println("\nThe sorted list: " + list);

        //repeat steps for bucket sort
        System.arraycopy(bckUp, 0, sz, 0, sz.length);

        //printing unsorted list
        System.out.println("\nThe unsorted list: " + list);

        //calling bucket sort
        System.out.printf("My Bucket-sort Time: %.2f milliseconds", bucketSort(sz,0,sz.length-1,10) / 1e6);
        //the sorted list
        System.out.println("\nThe sorted list: " + list);*/

        //All the sorting methods times
        System.out.printf("Collections' Sorting Time: %.2f milliseconds", timeT);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Selection-sort Time: %.2f milliseconds", selectionSort(sz) / 1e6);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Bubble-sort Time: %.2f milliseconds", bubbleSort(sz) / 1e6);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Insertion-sort Time: %.2f milliseconds", insertionSort(sz) * 1e-6);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Merge-sort Time: %.2f milliseconds", mergeSort(sz) / 1e6);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Quick-sort Time: %.2f milliseconds", quickSort(sz, 0, 49999) / 1e6);
        System.arraycopy(bckUp, 0, sz, 0, sz.length);
        System.out.printf("\nMy Bucket-sort Time: %.2f milliseconds", bucketSort(sz, 0, sz.length - 1, 2) * 1e-6);

    }


    //Generic methods
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {

        long startT = System.nanoTime();

        for (int i = 0; i < a.length; i++) {
            int small = i;

            //finding the smallest index
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[small]) < 0) { //if the next index is smaller than the smallest, then it becomes the smallest
                    small = j;

                }
            }
            //putting smallest value in correct spot
            T temp = a[i];
            a[i] = a[small];
            a[small] = temp;
        }
        long endT = System.nanoTime();

        return endT - startT;
    }

    //method that calculates how long bubbleSort algorithm takes
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {

        long startT = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].compareTo(a[j+1]) > 0) { //comparing the first element to second one
                    T hold = a[j]; //holding the first element
                    a[j] = a[j+1]; //swapping the elements
                    a[j+1] = hold;
                }
            }
        }
        long endT = System.nanoTime();
        return endT - startT;

    }

    //method that calculates how long insertionSort algorithm takes
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {

        long startT = System.nanoTime();
        int i=0; int j=0; //initalizing outside the loop to use j outside of its for loop;
        for (i = 1; i < a.length; i++) {
            T k = a[i]; //this is held constant until we return to first loop so it is always the value at i for the 2nd loop even if the actual value there switches bc of the 2nd loop, it's still the og one
            for (j = i - 1; j >= 0 && a[j].compareTo(k) > 0; j--) { //finding where the best place to put k is
                a[j + 1] = a[j];
            }
            a[j+1] = k;
        }

        long endT = System.nanoTime();
        long t = endT -startT;
        return t;
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] s) {

        long sT = System.nanoTime();
        //holding length of array
        int n = s.length;

        //if there is only 1 element in the array, just return the time because we dont have to do anything to sort the list

        if (n < 2) return 1;

        //dividng array in half if n>2
        int mid = n / 2;

        //divide part of divide and conquer
        T[] s1 = Arrays.copyOfRange(s, 0, mid); //copying first half
        T[] s2 = Arrays.copyOfRange(s, mid, n);   //copying the 2nd half

        //conquer part of divide and conquer using recursion
        mergeSort(s1);
        mergeSort(s2);

        //merging the results
        int i = 0;int j = 0;
        while (i + j < s.length) {
            if (j == s2.length || (i < s1.length && s1[i].compareTo(s2[j]) < 0))
                s[i + j] = s1[i++];

            else
                s[i + j] = s2[j++];


        }
        long eT = System.nanoTime();
        return eT - sT;
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {

        //calculating algorithm time
        long sT = System.nanoTime();

        //if the array has only 1 element it is sorted. This is the base case
        if (a >= b){ return 1;}
        //Making pivot the last element in the list
        T pivot = s[b];

        //making a pointer that scans towards the right
        int l = a;

        //making a pointer scans leftward & that's right before the pivot
        int r = b - 1;

        T temp;
        //while the left pointer is smaller/equal than the right pointer
        while (l <= r) {
            while (l <= r && s[r].compareTo(pivot) < 0) {//while left point is smaller than or equal to right, and the value at l is less than or = pivot
                l++; //increasing right pointer until find an element larger than pivot
            }
            while (l <= r && s[r].compareTo(pivot) >0) {//while left point < = right & value at r >= pivot
                r--;
            }
            if (l <=r) {
                //swapping s[l] and s[r]
                temp = s[l];
                s[l] = s[r];
                s[r] = temp;
                l++;r--;
            }
        }
        //swapping the elements s[l] && s[b] to put the pivot in it's final place
        temp = s[l];
        s[l] = s[b];
        s[b] = temp;

        //recursively sorting
        quickSort(s, a, l - 1);
        quickSort(s, l + 1, b);

        long eT = System.nanoTime();
        return eT - sT;
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {

        long sT = System.nanoTime(); //start time

        //Creating 10 buckets using Vector since our array is from 13 to 93 aka radix-10. Assuming positive numbers
        Vector<Integer>[] bucket = new Vector[10];

        //instantiating each bucket using a for loop
        for (int i = 0; i < 10; i++) {
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            //clearing the buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements(); //vector is useful here
            }
            //putting the last value in a at the last place in bucket
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int place = 0;
            for (int k = 0; k < 10; k++) {
                for (int o = 0; o < bucket[k].size(); o++) {
                    a[place++] = bucket[k].get(o);
                }
            }
        }
        long eT = System.nanoTime();
        long t=eT-sT;
        return t;
    }

    //this method gets a certain digit from decimal number
    public static Integer findDigit(int num, int j) {
        int target = 0;
        for (int k = 0; k <= j; k++) {
            target = num % 10;
            num = num / 10;
        }
        return target;
    }
}

