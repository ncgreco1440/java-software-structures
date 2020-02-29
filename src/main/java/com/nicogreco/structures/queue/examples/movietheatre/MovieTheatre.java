package com.nicogreco.structures.queue.examples.movietheatre;

import java.util.*;

public class MovieTheatre {
  private final static int PROCESS = 120; // Time it takes to process each Customer (seconds)
  private final static int MAX_CASHIERS = 10;
  private final static int NUM_CUSTOMERS = 100;

  public static void main(String[] args) {
    Customer customer;
    Queue<Customer> customerQueue = new LinkedList<>();
    int[] cashierTime = new int[MAX_CASHIERS];
    int totalTime, averageTime, departs, start;

    for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {         // Start for-loop to process the queue with each number of Cashiers

      for (int count = 0; count < cashiers; count++) {
        cashierTime[count] = 0;
      }

      for (int count = 1; count <= NUM_CUSTOMERS; count++) {
        customerQueue.add(new Customer(count * 15));
      }
      totalTime = 0;

      while (!customerQueue.isEmpty()) {
        for (int count = 0; count <= cashiers; count++) {
          if (!customerQueue.isEmpty()) {
            customer = customerQueue.remove();
            if (customer.arrivalTime() > cashierTime[count]) {
              start = customer.arrivalTime();
            } else {
              start = cashierTime[count];
            }
            departs = start + PROCESS;
            customer.setDepartureTime(departs);
            cashierTime[count] = departs;
            totalTime += customer.totalTime();
          }
        }
      }

      averageTime = totalTime / NUM_CUSTOMERS;
      System.out.println("Number of cashiers: " + (cashiers + 1));
      System.out.println("Average Time: " + averageTime + "\n");
    }
  }

}