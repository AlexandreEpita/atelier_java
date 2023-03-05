package fr.epita.assistants;

import fr.epita.assistants.myset.IntegerSet;

public class Main {
    public static void main(String[] args) {
        IntegerSet my_set = new IntegerSet();
        IntegerSet my_set1 = new IntegerSet();
        my_set.insert(1);
        my_set.insert(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");
        my_set.remove(3);
        my_set.remove(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");

        my_set.insert(1000);
        my_set.insert(100);

        my_set1.insert(7);
        my_set1.insert(9);
        my_set1.insert(2);
        my_set1.insert(5);
        my_set1.insert(11);
        my_set1.insert(0);
        my_set1.insert(10);

        for (int n = 0; n < my_set1.base_.size(); ++n)
            System.out.println(my_set1.base_.get(n));

        System.out.println("====================");

        IntegerSet union = IntegerSet.union(my_set,my_set1);
        for (int n = 0; n < union.base_.size(); ++n)
            System.out.println(union.base_.get(n));

        System.out.println(my_set.has(1).toString());
    }
}