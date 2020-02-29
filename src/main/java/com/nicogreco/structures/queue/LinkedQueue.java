package com.nicogreco.structures.queue;

public class LinkedQueue<T> implements QueueADT<T> {
  private LinearNode<T> head, tail;
  private int size;

  public LinkedQueue() {
    this.size = 0;
    this.head = this.tail = null;
  }

  public void enqueue(T element) {
    LinearNode<T> temp = new LinearNode<T>(element);
    if (this.isEmpty()) {
      this.head = temp;
    } else {
      this.tail.next = temp;
    }
    this.tail = temp;
    this.size++;
  }

  public T dequeue() {
    if (this.isEmpty()) throw new IndexOutOfBoundsException();
    T result = this.head.element();
    this.head = this.head.next;
    if (this.isEmpty()) {
      this.tail = null;
    }
    this.size--;
    return result;
  }

  public T first() {
    return this.head.element();
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public String toString() {
    throw new UnsupportedOperationException();
  }
}