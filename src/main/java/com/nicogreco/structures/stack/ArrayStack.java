package com.nicogreco.structures.stack;

/**
 * Implementation of an ArrayStack
 * @param <T>
 */
public class ArrayStack<T> implements StackADT<T> {
  private T[] arr;
  private int size;
  private int capacity;

  public ArrayStack() {
    this.capacity = 4;
    this.arr = (T[])(new Object[this.capacity]);
    this.size = 0;
  }

  /**
   * Adds an element to the top of the stack
   */
  public void push(T element) {
    if (this.size + 1 == this.capacity) {
      this.capacity *= 2;
      T[] newArr = (T[])(new Object[this.capacity]);
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.arr[i];
      }
      this.arr = newArr;
    }
    this.arr[this.size++] = element;
  }

  /**
   * Removes an element from the top of the stack
   */
  public T pop() {
    if (this.isEmpty()) return null;
    return this.arr[--this.size];
  }

  /**
   * Examines the element at the top of the stack
   */
  public T peek() {
    return this.arr[this.size - 1];
  }

  /**
   * Determines if the stack is empty
   * @return boolean
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Determines the number of elements on the stack
   * @return int
   */
  public int size() {
    return this.size;
  }

  /**
   * Determines the potential number of elements on the stack 
   */
  public int capacity() {
    return this.capacity;
  }
}