package com.nicogreco.structures.queue;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements QueueADT<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private int front, rear, count;
  private T[] array;

  public ArrayQueue() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayQueue(int capacity) {
    this.front = this.rear = this.count = 0;
    this.array = (T[])(new Object[capacity]);
  }

  public void enqueue(T element) {
    if (this.size() + 1 > this.array.length) {
      // We need to wrap
      this.rear = this.front;
      this.front = this.rear + 1;
    } else {
      this.count++;
    }

    this.array[this.rear++] = element;
  }

  public T dequeue() {
    if (this.isEmpty()) throw new IndexOutOfBoundsException();
    this.count--;
    if (this.front == this.array.length) {
      this.front = 0;
    }
    T elem = this.array[this.front];
    this.array[this.front] = null;
    this.front++;
    return elem;
  }

  public T first() {
    return this.array[this.front];
  }

  public int size() {
    return this.count;
  }

  public boolean isEmpty() {
    return this.count == 0;
  }

  public String toString() {
    return "";
  }
}