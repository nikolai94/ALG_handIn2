package second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nikolai Hansen
 */
public class DoublingTest {
    List<Integer> ranArr;
    long startTime, estimatedTime, previousInsertion, previousSelection;
    double ratio;
    
    public static void main(String[] args) {
        DoublingTest doublingTest = new DoublingTest();
        doublingTest.run();
    }
    
    private void run (){
    
           for (int i = 2000; i <= 32000; i = (i*2)) {
            ranArr = randomArr(i);
            ratio  = 0;
            
//            //Insertion
//            startTime = System.currentTimeMillis();
//            insertionSort(ranArr);
//            estimatedTime = System.currentTimeMillis() - startTime;
//            if(i != 2000){
//                previousInsertion = estimatedTime;
//                ratio = ((double)estimatedTime / (double)previousInsertion);
//            }
//            System.out.println("Insertion sort. i = "+ i +" . Actual time = " + estimatedTime +" ms. Expected = "+ (previousInsertion * 4) );
            
//            //Selection 
//            startTime = System.currentTimeMillis();
//            selectionSort(ranArr);
//            estimatedTime = System.currentTimeMillis() - startTime;
//              if(i != 2000){
//                previousSelection = estimatedTime;
//                ratio = ((double)estimatedTime / (double)previousInsertion);
//            }
//            System.out.println("Selection sort. i = "+ i +" . Actual time " + estimatedTime  +" ms. Expected = "+ (previousSelection * 4));
//            
            //mergeSort         
            startTime = System.currentTimeMillis();
            mergeSort(new ArrayList(ranArr));
            estimatedTime = System.currentTimeMillis() - startTime;      
            System.out.println("MergeSort sort. i = "+ i +" . Actual time " + estimatedTime +" ms." );
        }
    }

    
     public ArrayList<Integer> mergeSort(ArrayList<Integer> whole) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;
 
        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                    right.add(whole.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }
 
    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
    
    

    private List<Integer> selectionSort(List<Integer> arr) {
        int sizeOfArr = arr.size();
        int index;
        int smallValue;

        for (int i = 0; i < (sizeOfArr - 1); i++) {
            index = i;
            for (int j = (i + 1); j < sizeOfArr; j++) {
                if (arr.get(j) < arr.get(index)) {
                    index = j;
                }
            }

            smallValue = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, smallValue);
        }

        return arr;
    }

    private List<Integer> insertionSort(List<Integer> arr) {
        int pointer;
        int temp;

        for (int i = 0; i < arr.size(); i++) {
            pointer = arr.get(i);
            for (int j = (i - 1); j >= 0; j--) {
                //swap
                if (pointer < arr.get(j)) {
                    temp = arr.get(j);
                    arr.set(j, pointer);
                    arr.set((j + 1), temp);
                } //left side is sorted, so break
                else {
                    break;
                }
            }
        }
        return arr;
    }

    //makes an array with size n-1. With random values from 0 to n-1
    private List<Integer> randomArr(int n) {
        Random ran = new Random();

        List<Integer> ranArr = new ArrayList<Integer>();

        n = (n - 1);
        for (int i = 0; i <= n; i++) {
            ranArr.add(ran.nextInt(n));
        }
        return ranArr;
    }

}
