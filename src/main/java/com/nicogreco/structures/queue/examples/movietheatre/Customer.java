package com.nicogreco.structures.queue.examples.movietheatre;

public class Customer {
  private int arrivalTime, depatureTime;

  public Customer(int arrives) {
    this.arrivalTime = arrives;
    this.depatureTime = 0;
  }

  public int arrivalTime() {
    return this.arrivalTime;
  }

  public void setDepartureTime(int time) {
    this.depatureTime = time;
  }

  public int depatureTime() {
    return this.depatureTime;
  }

  public int totalTime() {
    return this.depatureTime - this.arrivalTime;
  }
}