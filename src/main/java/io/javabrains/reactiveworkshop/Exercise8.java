package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
    	
    	//Approach 1
//    	ReactiveSources.intNumbersFluxWithException()
//    	.subscribe(num -> System.out.println(num), err -> System.out.println(err.getMessage()));	
    	
    	//Approach 2
//    	ReactiveSources.intNumbersFluxWithException()
//    	.doOnError(err -> System.out.println(err))   //This is not going to solve error..it will do something
//    	.subscribe(num -> System.out.println(num));	
    	
    	
    	
    	
    	

        // Print values from intNumbersFluxWithException and continue on errors
    	
//    	ReactiveSources.intNumbersFluxWithException()
//    	.onErrorContinue((err,obj) -> System.out.println(err+"   "+obj))
//    	.subscribe(num -> System.out.println(num));
    	
    	
    	
    	
    	
    	

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
    	ReactiveSources.intNumbersFluxWithException()
    	.onErrorResume(err -> Flux.just(-1,-2))
    	.subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
