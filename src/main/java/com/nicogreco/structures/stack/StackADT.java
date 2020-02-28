package com.nicogreco.structures.stack;

public interface StackADT<T> {

  /**
   * Adds an element to the top of the stack
   */
  public void push(T element);

  /**
   * Removes an element from the top of the stack
   */
  public T pop();

  /**
   * Examines the element at the top of the stack
   */
  public T peek();

  /**
   * Determines if the stack is empty
   * @return boolean
   */
  public boolean isEmpty();

  /**
   * Determines the number of elements on the stack
   * @return int
   */
  public int size();
}