package io.javabrains.reactiveworkshop;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        //1) Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream\n");
    	StreamSources.intNumbersStream()
    	.forEach(elem -> System.out.println(elem));
    	
    	

        //2) Print numbers from intNumbersStream that are less than 5
    	System.out.println("Print numbers from intNumbersStream that are less than 5\n");
    	StreamSources.intNumbersStream()
    	.filter(elem -> elem < 5)
    	.forEach(elem -> System.out.println(elem));
    	
    	

        //3)  Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5\n");
        StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .skip(1)
        .limit(2)
        .forEach(elem -> System.out.println(elem));
        
        

        //4)  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5\n");  
        int res = -1;
        List<Integer> list = StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .collect(Collectors.toList());
        
        if(!list.isEmpty() || list.size() != 0) {
        	res = list.get(0);
        }
        System.out.println("res :: "+res);
        

        //5) Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
        .forEach(user -> System.out.println(user.getFirstName()));
        
        

        //6) Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream\n");
        StreamSources.userStream()
        .forEach(user -> {
        	StreamSources.intNumbersStream().forEach(id -> {
        		if(user.getId() == id) {
            		System.out.println(user.getFirstName());
            	}
        	});
        });
        

        System.out.println("-----------------------------------------------------------------------");
    }

}
