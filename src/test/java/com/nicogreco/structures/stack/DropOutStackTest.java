package com.nicogreco.structures.stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class DropOutStackTest {
  
  @Test
  public void testDropOutStackExists() {
    try {
      Class.forName("com.nicogreco.structures.stack.DropOutStack").newInstance();
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testInitialCapacitySet() {
    DropOutStack<Integer> stack = new DropOutStack<>();
    
    assertEquals(stack.capacity(), 10);
  }

  @Test
  public void testManualCapacitySet() {
    DropOutStack<Integer> stack = new DropOutStack<>(20);
    
    assertEquals(stack.capacity(), 20);
  }

  @Test
  public void testSize() {
    DropOutStack<Integer> stack = new DropOutStack<>();

    stack.push(5);
    
    assertEquals(stack.size(), 1);
  }

  @Test
  public void testPeek() {
    DropOutStack<Integer> stack = new DropOutStack<>();

    stack.push(5);
    
    assertEquals(stack.peek(), Integer.valueOf(5));
  }

  @Test
  public void testThrowsIndexOutOfBounds() {
    DropOutStack<Integer> stack = new DropOutStack<>();

    try {
      stack.pop();
      fail();
    } catch (IndexOutOfBoundsException e) {}
  }

  @Test
  public void testPop() {
    DropOutStack<Integer> stack = new DropOutStack<>();

    stack.push(5);
    
    assertEquals(stack.pop(), Integer.valueOf(5));
    assertEquals(stack.size(), 0);
  }

  @Test
  public void testPushTilOverMax() {
    DropOutStack<Integer> stack = new DropOutStack<>();

    for (int i = 0; i < 11; i++) {
      stack.push(i);
    }
    
    assertEquals(stack.pop(), Integer.valueOf(10));
    assertEquals(stack.pop(), Integer.valueOf(9));
    assertEquals(stack.size(), 8);
  }
}