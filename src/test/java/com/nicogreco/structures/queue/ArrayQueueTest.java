package com.nicogreco.structures.queue;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Vector;

public class ArrayQueueTest {

  @Test
  public void testLinkedQueueExists() {
    try {
      Class.forName("com.nicogreco.structures.queue.ArrayQueue").newInstance();
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testArrayQueueSize() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    assertEquals(queue.size(), 0);
  }

  @Test
  public void testLinkedQueueIsEmpty() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    assertEquals(queue.isEmpty(), true);
  }

  @Test
  public void testArrayQueueCanEnqueue() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    queue.enqueue(55);

    assertEquals(queue.isEmpty(), false);
  }

  @Test
  public void testArrayQueueCanDequeue() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    queue.enqueue(55);
    queue.enqueue(75);
    queue.enqueue(45);
    int res = queue.dequeue();

    assertEquals(res, 55);
    assertEquals(queue.size(), 2);
  }

  @Test
  public void testArrayQueueFirst() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    queue.enqueue(53);
    queue.enqueue(5);
    queue.enqueue(84);

    assertEquals(queue.first(), Integer.valueOf(53));
  }

  @Test
  public void testArrayQueueWrapAroundToFirst() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    for (int i = 1; i < 12; i++) {
      queue.enqueue(i);
    }

    assertEquals(queue.first(), Integer.valueOf(2));
    assertEquals(queue.size(), 10);
  }

  @Test
  public void testArrayQueueWrapAroundAndDequeues() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    Vector<Integer> vec = new Vector<>();
    Vector<Integer> res = new Vector<>();
    res.add(3);
    res.add(4);
    res.add(5);
    res.add(6);

    for (int i = 1; i < 13; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 4; i++) {
      vec.add(queue.dequeue());
    }

    assertEquals(queue.first(), Integer.valueOf(7));
    assertEquals(vec, res);
    assertEquals(queue.size(), 6);
  }

  @Test
  public void testArrayQueueThrowOnEmptyDequeue() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    try {
      queue.dequeue();
      fail();
    } catch (Exception e) {}
  }

  @Test
  public void testArrayQueueWrapAroundFullDequeues() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    Vector<Integer> vec = new Vector<>();
    Vector<Integer> res = new Vector<>();

    // populate the answer vector
    for (int i = 3; i < 13; i++) {
      res.add(i);
    }

    // enqueue integers, will force wrapping
    for (int i = 1; i < 13; i++) {
      queue.enqueue(i);
    }

    // dequeue everything
    for (int i = 0; i < 10; i++) {
      vec.add(queue.dequeue());
    }

    assertEquals(queue.first(), null);
    assertEquals(vec, res);
    assertEquals(queue.size(), 0);
  }
}