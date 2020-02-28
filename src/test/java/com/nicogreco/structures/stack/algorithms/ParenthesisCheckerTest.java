package com.nicogreco.structures.stack.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import com.nicogreco.structures.stack.LinkedStack;

public class ParenthesisCheckerTest {

  public class ParenthesisChecker {
    public boolean isInverse(char c, char og) {
      return (og == '[' && c == ']') ||
      (og == '(' && c == ')') ||
      (og == '{' && c == '}');
    } 

    public boolean isBalanced(String expression) {
      LinkedStack<Character> stack = new LinkedStack<>();

      for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);
        if (c == '{' || c == '(' || c == '[') {
          stack.push(c);
        } else {
          if (this.isInverse(c, stack.peek())) {
            stack.pop();
          } else {
            return false;
          }
        }
      }

      return stack.isEmpty();
    } 
  }

  @Test
  public void testExpressionShouldBeBalanced() {
    ParenthesisChecker check = new ParenthesisChecker();

    String b = check.isBalanced("[()]{}{[()()]()}") ? "balanced" : "not balanced";

    assertEquals(b, "balanced");
  }

  @Test
  public void testExpressionShouldNotBeBalanced() {
    ParenthesisChecker check = new ParenthesisChecker();

    String b = check.isBalanced("([]") ? "balanced" : "not balanced";

    assertEquals(b, "not balanced");
  }
}