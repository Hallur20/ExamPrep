package day2.webscraper;

public class Tester {
  
  public static void main(String[] args) throws InterruptedException {
      System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
      long start = System.nanoTime();
    TagCounter tc1 = new TagCounter("http://www.fck.dk");
    tc1.start();
    TagCounter tc2= new TagCounter("http://www.google.com");
    tc2.start();
    TagCounter tc3= new TagCounter("http://politiken.dk/");
    tc3.start();
    
    
    tc1.join();
    tc2.join();
    tc3.join();
    
    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
    System.out.println("Body's: "+tc3.getBodyCount()); 
    long end = System.nanoTime();
System.out.println("Time Sequential: "+(end-start));

    /*
    Run the main method in the Tester class, and make sure you understand conceptually what happens.
    Especially you should note that these lines : tcX.run() probably takes a noticeable amount of time (why?)
    -> they run one at a time (sequential) and not parallel.
    Refactor the TagCounter class to extend the Thread class. This should be very simple (why ?)
    -> well you just write extends Thread beside the name of the class which extends the thread interface.
    Change the Tester class to not call run(), but start the three threads (what's the BIG difference?)
    -> start runs parallel (all threads with start run at the same time making output much faster)
    This will most likely mean that all your system.out’s will be empty or null (why?)
    -> we havent joined, so souts also happen at the same time as threads, we have to join them in order to sout after.
    
    with run: 1.909s.
with start: 1.456s

Explain the results
-> well as predicted because one thread has to wait till the other thread is done with run it was the slower one,
as with start they just all ran at the same time and as expected had a better response time.
    */
  }
}
