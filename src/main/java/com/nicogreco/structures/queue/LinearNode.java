package com.nicogreco.structures.queue;

/**
 * Node to serve as the underlying reference to elements
 * within a singly linked list implementation.
 * @param <T>
 */
public class LinearNode<T> {
  private T element;
  public LinearNode<T> next;

  public LinearNode() {
    this(null, null);
  }

  public LinearNode(T element) {
    this(element, null);
  }

  public LinearNode(T element, LinearNode<T> next) {
    this.element = element;
    this.next = next;
  }

  public T element() {
    return this.element;
  }
}