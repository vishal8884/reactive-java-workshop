package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
//    	ReactiveSources.intNumbersFlux()
//    	.filter(num -> num > 5)
//    	.subscribe(num -> System.out.println(num));

    	
    	
        // Print 10 times each value from intNumbersFlux that's greater than 5
//    	ReactiveSources.intNumbersFlux()
//    	.filter(num -> num > 5)
//    	.repeat(10)
//    	.subscribe(num -> System.out.println(num));

    	
    	
        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//    	ReactiveSources.intNumbersFlux()
//    	.filter(num -> num > 5)
//    	.take(3)
//    	.repeat(10)
//    	.subscribe(num -> System.out.println(num));

    	
    	
        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//    	ReactiveSources.intNumbersFlux()
//    	.filter(num -> num > 20)
//    	.defaultIfEmpty(-1)
//    	.subscribe(num -> System.out.println(num));

    	
    	
        // Switch ints from intNumbersFlux to the right user from userFlux
    	
//    	ReactiveSources.intNumbersFlux()
//    	.flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id))
//    	.subscribe(user -> System.out.println(user));
    	

    	
    	
        // Print only distinct numbers from intNumbersFluxWithRepeat
//    	ReactiveSources.intNumbersFluxWithRepeat() 
//    	.distinct()
//    	.repeat(2)
//    	.subscribe(num -> System.out.println(num));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
    	ReactiveSources.intNumbersFluxWithRepeat() 
    	.distinctUntilChanged()
    	.repeat(2)
    	.subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
