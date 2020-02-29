package com.nicogreco.structures.queue;

public interface QueueADT<T> {
  /**
   * Adds an element to the rear of the Queue
   */
  public void enqueue(T element);

  /**
   * Removes an element from the front of the Queue
   */
  public T dequeue();

  /**
   * Examines the element at the front of the Queue
   * @return T
   */
  public T first();

  /**
   * Examines the size of the Queue
   * @return int
   */
  public int size();

  /** 
   * String representation of the Queueu
   */
  public String toString();
}