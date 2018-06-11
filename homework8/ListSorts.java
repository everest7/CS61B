package com.homework8;/* ListSorts.java */

import com.homework8.list.*;

import java.util.Random;

public class ListSorts {

  private final static int SORTSIZE = 100;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
//    return null;
      LinkedQueue lq = new LinkedQueue();
      int length = q.size();
      try {
          for (int i = 0; i < length; i++){
              Object item = q.dequeue();
              LinkedQueue newqueue = new LinkedQueue();
              newqueue.enqueue(item);
              lq.enqueue(newqueue);
          }
      } catch (QueueEmptyException e){
          e.printStackTrace();
      }
      return lq;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
//    return null;
      LinkedQueue lq = new LinkedQueue();
      while (q1.size() > 0 && q2.size() > 0){
          try{
              if (((Comparable)q1.front()).compareTo(q2.front()) <= 0){
                  lq.enqueue(q1.dequeue());
              } else {
                  lq.enqueue(q2.dequeue());
              }
          } catch (QueueEmptyException e){
              e.printStackTrace();
          }
      }
      while (q1.size() > 0){
          try {
              lq.enqueue(q1.dequeue());
          } catch (QueueEmptyException e){
              e.printStackTrace();
          }
      }
      while (q2.size() > 0){
          try {
            lq.enqueue(q2.dequeue());
          } catch (QueueEmptyException e){
              e.printStackTrace();
          }
      }

      return lq;


//      Comparable o1, o2;
//      int i = 1, j = 1;
//      while (i <= q1.size() && j <= q2.size()) {
//          o1 = (Comparable) q1.nth(i);
//          o2 = (Comparable) q2.nth(j);
//          if (o1.compareTo(o2) <= 0) {
//              lq.enqueue(o1);
//              i++;
//          } else {
//              lq.enqueue(o2);
//              j++;
//          }
//      }
//      while(i <= q1.size()){
//          Object o = q1.nth(i++);
//          lq.enqueue(o);
////          i++;
//      }
//      while (j <= q2.size()){
//          Object o = q2.nth(j++);
//          lq.enqueue(o);
////          j++;
//      }
//      return lq;
  }


  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
      while(qIn.size() > 0){
          try {
              Comparable o = (Comparable) qIn.dequeue();
              if (o.compareTo(pivot) < 0){
                  qSmall.enqueue(o);
              } else if (o.compareTo(pivot) == 0){
                  qEquals.enqueue(o);
              } else {
                  qLarge.enqueue(o);
              }

          } catch (QueueEmptyException e ){
              e.printStackTrace();
          }
      }
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
      LinkedQueue lq = new LinkedQueue();
      LinkedQueue queue = makeQueueOfQueues(q);
      while (queue.size() > 1){
          LinkedQueue q1 = null;
          LinkedQueue q2 = null;
          try {
              q1 = (LinkedQueue) queue.dequeue();
              q2 = (LinkedQueue) queue.dequeue();

          } catch (QueueEmptyException e){
              e.printStackTrace();
          }

          lq = mergeSortedQueues(q1,q2);
          queue.enqueue(lq);
      }
      try{
          q.append((LinkedQueue) queue.dequeue());
      } catch (QueueEmptyException e){
          e.printStackTrace();
      }
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
      Random rand = new Random();
      int length = q.size();
      int n = rand.nextInt(length) + 1;
      Comparable pivot =(Comparable) q.nth(n);
      LinkedQueue qSmall = new LinkedQueue();
      LinkedQueue qEquals = new LinkedQueue();
      LinkedQueue qLarge = new LinkedQueue();
      partition(q,pivot,qSmall,qEquals,qLarge);
      if (qSmall.size() > 0){
          quickSort(qSmall);
      }
      if (qLarge.size() > 0){
          quickSort(qLarge);
      }
      q.append(qSmall);
      q.append(qEquals);
      q.append(qLarge);


  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());

    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

//    /* Remove these comments for Part III.
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
//    */
      Timer stopWatch2 = new Timer();
      q = makeRandom(100);
      stopWatch2.start();
      mergeSort(q);
      stopWatch2.stop();
      System.out.println("Mergesort time, " + 1000 + " Integers:  " +
              stopWatch2.elapsed() + " msec.");

      stopWatch2.reset();
      q = makeRandom(1000);
      stopWatch2.start();
      quickSort(q);
      stopWatch2.stop();
      System.out.println("Quicksort time, " + 1000 + " Integers:  " +
              stopWatch2.elapsed() + " msec.");
//    */
//    */
      Timer stopWatch3 = new Timer();
      q = makeRandom(10000);
      stopWatch3.start();
      mergeSort(q);
      stopWatch3.stop();
      System.out.println("Mergesort time, " + 10000 + " Integers:  " +
              stopWatch3.elapsed() + " msec.");

      stopWatch3.reset();
      q = makeRandom(10000);
      stopWatch3.start();
      quickSort(q);
      stopWatch3.stop();
      System.out.println("Quicksort time, " + 10000 + " Integers:  " +
              stopWatch3.elapsed() + " msec.");
//    */
//    */
      Timer stopWatch4 = new Timer();
      q = makeRandom(100000);
      stopWatch4.start();
      mergeSort(q);
      stopWatch4.stop();
      System.out.println("Mergesort time, " + 100000 + " Integers:  " +
              stopWatch4.elapsed() + " msec.");

      stopWatch4.reset();
      q = makeRandom(100000);
      stopWatch4.start();
      quickSort(q);
      stopWatch4.stop();
      System.out.println("Quicksort time, " + 100000 + " Integers:  " +
              stopWatch4.elapsed() + " msec.");
//    */
//    */
      Timer stopWatch5 = new Timer();
      q = makeRandom(1000000);
      stopWatch5.start();
      mergeSort(q);
      stopWatch5.stop();
      System.out.println("Mergesort time, " + 1000000 + " Integers:  " +
              stopWatch5.elapsed() + " msec.");

      stopWatch5.reset();
      q = makeRandom(1000000);
      stopWatch5.start();
      quickSort(q);
      stopWatch5.stop();
      System.out.println("Quicksort time, " + 1000000 + " Integers:  " +
              stopWatch5.elapsed() + " msec.");
//    */
  }

}
