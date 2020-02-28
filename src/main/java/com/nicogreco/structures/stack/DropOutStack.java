package com.nicogreco.structures.stack;

/**
 * Circular Stack with a fixed size, once you've filled the Stack and
 * continue to push elements the first item[s] pushed onto the
 * Stack will become overwritten.
 */
public class DropOutStack<T> implements StackADT<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private Node<T> head;
  private Node<T> current;
  private int size;
  private int capacity;

  private class Node<T> {
    private T element;
    private Node<T> prev;

    public Node() {
      this(null, null);
    }

    public Node(T element) {
      this(element, null);
    }

    public Node(T element, Node<T> prev) {
      this.element = element;
      this.prev = prev;
    }

    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }

    public void setElement(T elem) {
      this.element = elem;
    }

    public Node<T> prev() {
      return this.prev;
    }
  }

  public DropOutStack() {
    this(DEFAULT_CAPACITY);
  }

  public DropOutStack(int capacity) {
    this.capacity = capacity;
  }

  public int capacity() {
    return this.capacity;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void push(T element) {  
    if (this.isEmpty()) {
      this.head = new Node<T>(element);
      this.current = this.head;
      this.size++;
      return;
    }

    this.current = new Node<T>(element, this.current);
    
    if (this.size() < this.capacity()) {
      this.size++;
    } else {
      Node<T> temp = this.head;
      this.head = this.current;
      temp.setPrev(null);
      temp.setElement(null);
    }
  }

  public T peek() {
    return this.current.element;
  }

  public T pop() {
    if (this.isEmpty()) throw new IndexOutOfBoundsException();
    T elem = this.current.element;
    this.current = this.current.prev();
    this.size--;
    return elem;
  }
}