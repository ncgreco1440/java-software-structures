package com.nicogreco.structures.list;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T> {
  private final static int DEFAULT_CAPACITY = 10;
  private final static int NOT_FOUND = -1;
  protected int rear;
  protected T[] list;
  protected int modCount;

  public T removeFirst() {
    throw new UnsupportedOperationException();
  }

  public T removeLast() {
    throw new UnsupportedOperationException();
  }

  public T remove(T element) {
    throw new UnsupportedOperationException();
  }

  public T first() {
    throw new UnsupportedOperationException();
  }

  public T last() {
    throw new UnsupportedOperationException();
  }

  public boolean contains(T element) {
    throw new UnsupportedOperationException();
  }

  public boolean isEmpty() {
    throw new UnsupportedOperationException();
  }

  public int size() {
    throw new UnsupportedOperationException();
  }

  public Iterator<T> iterator() {
    throw new UnsupportedOperationException();
  }

  public String toString() {
    throw new UnsupportedOperationException();
  }
}