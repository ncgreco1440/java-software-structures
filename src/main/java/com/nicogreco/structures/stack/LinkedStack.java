package com.nicogreco.structures.stack;

/**
 * Implementation of a LinkedStack
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T> {
  private Node<T> top = null;
  private int size = 0;

  private class Node<T> {
    public T data;
    public Node<T> prev = null;

    public Node(T data) {
      this.data = data;
    }
  }

  public LinkedStack() {}

  /**
   * Adds an element to the top of the stack
   */
  public void push(T element) {
    Node<T> temp = this.top;
    this.top = new Node<T>(element);
    this.top.prev = temp;
    ++this.size;
  }

  /**
   * Removes an element from the top of the stack
   */
  public T pop() {
    if (this.isEmpty()) return null;
    T data = this.top.data;
    this.top = this.top.prev;
    --this.size;
    return data;
  }

  /**
   * Examines the element at the top of the stack
   */
  public T peek() {
    return this.top.data;
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
}