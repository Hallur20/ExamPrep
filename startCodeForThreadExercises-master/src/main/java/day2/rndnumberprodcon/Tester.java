package day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {
/*
    If we need a “large” collection of random numbers, what is the advantage (if any) of introducing threads to “produce” the numbers?
    -> instead of looping through the numbers one at a time we use maybe 4 threads that go through the numbers paralelly making it much faster.
    Why does the exercise suggest 4 producer threads, and is that always the right  number?
    -> a computer usually has 4 processors making 4 threads optimal. using a higher number of threads 
    than the number of cores present in a machine can simply be a waste of resources
    Given that the Queue is a BlockingQueue implementation, how would you insert data into the Queue (add(),
    offer(), put() ) if it’s limited in capacity, and items are produced much faster than they are produced?
    -> i would use put (change later?)
    Given that the Queue is a BlockingQueue implementation, how would you fetch data from the Queue (remove(), poll(),
    take() ) if Production is slow, compared to how we consume items
    -> i would use take (change later?)
    */
  
  public static void main(String[] args) throws InterruptedException {
    //This represent the Queue in the exercise-figure. Observe the size of the Queue
    ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);
    
    ExecutorService es = Executors.newCachedThreadPool();
    //Create and start four producers (P1-P4 in the exercise-figure)
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
     
    //Create and start single consumer (C1 in the exercise-figure)
    RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);
    es.execute(consumer);    
    
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);
    
    System.out.println("Total of all random numbers: " + consumer.getSumTotal());
    System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
    System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());
  }
}
