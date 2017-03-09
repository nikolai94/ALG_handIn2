/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nikolai
 */
public class MainDeckOfCards {

    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<Integer>();
//        arr.add(2);
//        arr.add(5);
//        arr.add(8);
//        arr.add(1);
//        arr.add(6);
//        arr.add(3);
//        arr.add(7);
//
//        List<Integer> arrSort = bubbleSort(arr);
//
//        for (Integer row : arrSort) {
//            System.out.println(row);
//        }


//Version 2

//    LinkedList<Integer> intArr = new LinkedList<Integer>();
//    intArr.add(2);
//    intArr.add(5);
//    intArr.add(8);
//    intArr.add(1);
//    intArr.add(6);
//    intArr.add(3);
//    intArr.add(7);
//    
//     LinkedList<Integer> arrSort = bubbleSortLinkedlist(intArr);
//     
//        for (Integer row : arrSort) {
//            System.out.println(row);
//        }
//     
     
    

    }

    public static List<Integer> bubbleSort(List<Integer> arr) {
        boolean sort = true;
        int temp;

        while (sort) {
            sort = false;

            for (int i = 0; i < arr.size(); i++) {
                //swap
                if (i != arr.size() - 1) {
                    if (arr.get(i) > arr.get(i + 1)) {
                        temp = arr.get(i);
                        arr.remove(i);
                        arr.add(temp);
                        sort = true;
                    }
                }
            }
        }
        return arr;
    }
//    
//    public static LinkedList<Integer> bubbleSortLinkedlist(LinkedList<Integer> linkedlist){
//        
//        int sizeOfList = linkedlist.size();
//        int firstCard = linkedlist.poll();
//        int secondCard = linkedlist.poll();
//        
//        
//
//        int countWhile = 0;
//        boolean sort;
//        
//        while (true) {
//            
//            sort = true;
//             if(sort && sizeOfList == countWhile){
//               // linkedlist.addFirst(secondCard);
//                break;
//            }
//            
//            else if(firstCard > secondCard){
//                linkedlist.add(firstCard);
//                firstCard = secondCard;
//                //linkedlist.addFirst(secondCard);
//                secondCard = linkedlist.poll();
//                sort = false;
//                countWhile = 0;
//            }  
//            else{
//                linkedlist.add(secondCard);
//                secondCard = linkedlist.poll();
//            }
//             
//            countWhile++;
//            
//            
//        }
//        
//        return linkedlist;
//        
//    }
}
