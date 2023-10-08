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
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .findFirst()
        .ifPresentOrElse(num -> System.out.println(num), () -> System.out.println(-1));
        

        //5) Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
        .forEach(user -> System.out.println(user.getFirstName()));
        
//        StreamSources.userStream()
//        .map(user -> user.getFirstName())         //This also will work
//        .forEach(firstName -> System.out.println(firstName));
        
        

        //6) Print first names in userStream for users that have IDs from number stream
        //approach 1
        System.out.println("Print first names in userStream for users that have IDs from number stream....approach 1\n");
        StreamSources.userStream()
        .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> id == user.getId()))
        .map(user -> user.getFirstName())
        .forEach(name -> System.out.println(name));
        
        //approach 2
        System.out.println("Print first names in userStream for users that have IDs from number stream....approach 2\n");
        StreamSources.intNumbersStream()
        .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))   //we use flatMap instead of map when we are returning a stream
        .forEach(user -> System.out.println(user.getFirstName()));
        

        System.out.println("-----------------------------------------------------------------------");
    }

}
