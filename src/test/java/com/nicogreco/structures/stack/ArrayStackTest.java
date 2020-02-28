package com.nicogreco.structures.stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayStackTest {
  @Test
  public void testArrayStackExists() {
    try {
      Class<?> clazz = null;
      clazz = Class.forName("com.nicogreco.structures.stack.ArrayStack");
      Object o = clazz.newInstance();
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testArrayStackGetSize() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertEquals(stack.size(), 0);
  }

  @Test
  public void testArrayStackIsEmpty() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertEquals(stack.isEmpty(), true);
  }

  @Test
  public void testArrayStackIsNotEmpty() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    stack.push(5);

    assertEquals(stack.isEmpty(), false);
    assertEquals(stack.size(), 1);
  }

  @Test
  public void testArrayStackCanPop() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(5);
    stack.push(7);
    stack.push(8);

    int res = stack.pop();

    assertEquals(res, 8);
    assertEquals(stack.size(), 2);
  }
  
  @Test
  public void testArrayStackCanPeek() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(5);
    stack.push(7);
    stack.push(8);

    int res = stack.peek();

    assertEquals(res, 8);
    assertEquals(stack.size(), 3);
  }

  @Test
  public void testArrayStackCanModifyCapacity() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    int i = 0;
    while (i <= 5) stack.push(++i);

    assertEquals(stack.capacity(), 8);
  }
}