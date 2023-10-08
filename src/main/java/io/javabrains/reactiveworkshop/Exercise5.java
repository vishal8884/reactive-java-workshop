package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()
        // Subscribe to a flux using the error and completion hooks
//    	ReactiveSources.intNumbersFlux().subscribe(num -> System.out.println(num),
//    			err -> System.out.println(err),
//    			() -> System.out.println("numbersFlux Completed"));
//    	
//    	ReactiveSources.userFlux().subscribe(user -> System.out.println(user),
//    			err -> System.out.println(err),                   //optional   consumer which takes throwable and prints it
//    			() -> System.out.println("User flux completed")); //optional   consumer which says completed at last

        // 2) Subscribe to a flux using an implementation of BaseSubscriber
    	System.out.println("Subscribe to a flux using an implementation of BaseSubscriber");
    	
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<Integer>());
    	

        System.out.println("Press a key to end");
        System.in.read();
    }

}


class MySubscriber<T> extends BaseSubscriber<T>{
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscribe called via baseSubscriber");
		request(1);
	}
	
	
	@Override
	protected void hookOnNext(T value) {
		System.out.println("next called for data :: "+value.toString());
		request(1);
	}
	
	@Override
	protected void hookOnComplete() {
		System.out.println("Process Completed");
	}
}