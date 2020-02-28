package com.nicogreco.structures.stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedStackTest {
  @Test
  public void testLinkedStackExists() {
    try {
      Class<?> clazz = null;
      clazz = Class.forName("com.nicogreco.structures.stack.LinkedStack");
      Object o = clazz.newInstance();
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testLinkedStackGetSize() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    assertEquals(stack.size(), 0);
  }

  @Test
  public void testLinkedStackIsEmpty() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    assertEquals(stack.isEmpty(), true);
  }

  @Test
  public void testLinkedStackIsNotEmpty() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(5);

    assertEquals(stack.isEmpty(), false);
    assertEquals(stack.size(), 1);
  }

  @Test
  public void testLinkedStackCanPop() {
    LinkedStack<Integer> stack = new LinkedStack<>();
    stack.push(5);
    stack.push(7);
    stack.push(8);

    int res = stack.pop();

    assertEquals(res, 8);
    assertEquals(stack.size(), 2);
  }
  
  @Test
  public void testLinkedStackCanPeek() {
    LinkedStack<Integer> stack = new LinkedStack<>();
    stack.push(5);
    stack.push(7);
    stack.push(8);

    int res = stack.peek();

    assertEquals(res, 8);
    assertEquals(stack.size(), 3);
  }

}