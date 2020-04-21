package uk.axone.alerts;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SampleSetCollection {

    @Test
    public void setCollection(){
//coding to interface : ?
        //1.to create set colllection
       // no duplicate allowed
        Set<String> fruitset = new TreeSet<>();

        //2.to add elements to a set
        fruitset.add("pears");
        fruitset.add("mango");
        fruitset.add("apple");

        System.out.println(fruitset.size());
//to iterate
        Iterator<String> itr = fruitset.iterator();
        //to fetch the elements
      System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());

        //safemethod to iterate

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }


    }









