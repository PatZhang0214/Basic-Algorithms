import java.util.ArrayList;
import java.util.*;

       /*
         * Binary Search is an algorithm that uses recursion in order to
         * check and find an element inside an indexed data structure such
         * as an array or arraylist. 
         * 
         * 
         * The data structure must first be sorted traditionally in an
         * ascending order but descending order would work too if the
         * recursive steps are implemented differently. 
         * 
         * The algorith uses the middle element inside the list (the element
         * located in the middle of the list) and compares it with the 
         * value that needs to be accessed. 
         * 
         * If the middle element is bigger than the value, we know that the value we 
         * are looking for is located
         * inside the first half (all elements left of the middle element) and
         * we will cut the list in half, and repeat the process for the first
         * half of the list and ignore the second half. Eventually, we will either
         * access the middle element of a sublist and it will be value or if we have
         * only 1 element inside the list and it wont be the value.
         * 
         * If the middle element is smaller than the value, we know that the value we
         * are looking for is located inside the second half. We can repeat the process 
         * for the second half instead of the first half. 
         * 
         */

public class binarySearch {

    static int binSearch(List<Integer> elems, int searchValue, int firstIndex, int lastIndex) {

        // we determine the middleIndex from the firstIndex and the lastIndex
        int middleIndex = (firstIndex + lastIndex) / 2;

        // the size of the list will simply the lastIndex minus the firstIndex;
        int size = lastIndex - firstIndex;

// Debug message:
//        System.out.println("firstIndex = " + firstIndex + " lastIndex = " + lastIndex + " middleIndex = " + middleIndex);


        // the midValue will be the value of the element at the middleIndex of the list
        int midValue = elems.get(middleIndex);


        // if the list has been exhuasted and the value is noy found, we will simply
        // print out that it the value is not inside the list
        if((size == 1 && elems.get(middleIndex) != searchValue) || size == 0) {

            System.out.println("The value is not inside this list");

            return 0;

        } else {

            // if the middle value is greater than the searchValue, we will look inside
            // the left side of the list. The firstIndex will be the same but the middleIndex
            // will be the last element inside the list we are checking.
            if(midValue > searchValue) {

                binSearch(elems, searchValue, firstIndex, middleIndex);

            // if the middle value is smaller than the searchValue, we will look inside
            // the right side of the list. The middleIndex will be the first element inside the list 
            // we are checking and the lastIndex will be the same.
            } else if(midValue < searchValue) {

                binSearch(elems, searchValue, middleIndex, lastIndex);

            // If the element is found (the middle value is the element), we print out that it has been found.
            } else {
                System.out.println("The value is located at index: " + middleIndex);
            }
        }

        return 0;
    }

    public static void main(String args[]) {

        List<Integer> test = new ArrayList<Integer>();

        // simple tests:

        for(int i = 1; i <= 100; i ++) {
            test.add(i);
        }

        binSearch(test, 35, 0, 99); // index: 34

        binSearch(test, 50, 0, 99); // index: 49

        binSearch(test, -1, 0, 99); // not in list

        binSearch(test, 1009, 0, 99); // not in list

    }
}