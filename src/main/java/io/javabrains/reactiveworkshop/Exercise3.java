package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
    	List<Integer> list = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());
    	System.out.println("list :: "+list);
    	System.out.println("list size :: "+list.size());


        System.out.println("Press a key to end");
        System.in.read();
    }

}
