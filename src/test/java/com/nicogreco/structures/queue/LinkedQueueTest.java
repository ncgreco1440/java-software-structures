package com.nicogreco.structures.queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedQueueTest {

  @Test
  public void testLinkedQueueExists() {
    try {
      Class.forName("com.nicogreco.structures.queue.LinkedQueue").newInstance();
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testLinkedQueueSize() {
    LinkedQueue<Integer> queue = new LinkedQueue<>();

    assertEquals(queue.size(), 0);
  }

  @Test
  public void testLinkedQueueIsEmpty() {
    LinkedQueue<Integer> queue = new LinkedQueue<>();

    assertEquals(queue.isEmpty(), true);
  }

  @Test
  public void testLinkedQueueCanEnqueue() {
    LinkedQueue<Integer> queue = new LinkedQueue<>();

    queue.enqueue(55);

    assertEquals(queue.isEmpty(), false);
  }

  @Test
  public void testLinkedQueueCanDequeue() {
    LinkedQueue<Integer> queue = new LinkedQueue<>();

    queue.enqueue(55);
    queue.enqueue(75);
    queue.enqueue(45);
    int res = queue.dequeue();

    assertEquals(res, 55);
    assertEquals(queue.size(), 2);
  }

  @Test
  public void testLinkedQueueFirst() {
    LinkedQueue<Integer> queue = new LinkedQueue<>();

    queue.enqueue(53);
    queue.enqueue(5);
    queue.enqueue(84);

    assertEquals(queue.first(), Integer.valueOf(53));
  }
}