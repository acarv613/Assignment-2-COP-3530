package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(5);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(11);
        list1.add(15);
        list2.add(1);
        list2.add(5);
        list2.add(9);
        list2.add(15);
        ArrayList<Integer> difference = new ArrayList<>();
        difference(list1, list2, difference);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("difference: " + difference);

    }

    static <AnyType extends Comparable<? super AnyType>> void difference
            (List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = null;
        AnyType itemL2 = null;
        if(iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        while(itemL1 != null || itemL2 != null) {
            if(itemL1 == null)
                return;
            else if(itemL2 == null) {
                Difference.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
            }
            else if(itemL1.compareTo(itemL2) > 0) {
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            }
            else if (itemL1.compareTo(itemL2) < 0) {
                Difference.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
            }
            else {
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            }
        }

    }
}
