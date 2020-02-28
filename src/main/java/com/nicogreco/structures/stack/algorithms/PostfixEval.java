package com.nicogreco.structures.stack.algorithms;

import com.nicogreco.structures.stack.LinkedStack;
import java.util.Scanner;

/**
 * Postfix Evaluator class for Integers only
 */
public class PostfixEval {
  private final static char ADD = '+';
  private final static char SUBTRACT = '-';
  private final static char MULTIPLY = '*';
  private final static char DIVIDE = '/';
  private LinkedStack<Integer> stack;
  
  public PostfixEval() {
    this.stack = new LinkedStack<>();
  }

  /**
   * Converts an infix expression to a postfix expression
   */
  public String translate(String infix) {
    throw new UnsupportedOperationException();
  }

  public int evaluate(String expression) {
    int opt1, opt2, result = 0;
    String token;
    String[] arr = expression.split(" ");
    for (int i = 0; i < arr.length; i++) {
      token = arr[i];
      if (this.isOperator(token)) {
        opt2 = stack.pop();
        opt1 = stack.pop();
        result = evaluateOperation(token.charAt(0), opt1, opt2);
        stack.push(result);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return result;
  }

  public boolean isOperator(String token) {
    return token.charAt(0) == PostfixEval.ADD || token.charAt(0) == PostfixEval.SUBTRACT ||
      token.charAt(0) == PostfixEval.MULTIPLY || token.charAt(0) == PostfixEval.DIVIDE;
  }

  private int evaluateOperation(char operation, int opt1, int opt2) {
    int result = 0;

    switch (operation) {
      case ADD: {
        result = opt1 + opt2;
        break;
      }
      case SUBTRACT: {
        result = opt1 - opt2;
        break;
      }
      case MULTIPLY: {
        result = opt1 * opt2;
        break;
      }
      case DIVIDE: {
        result = opt1 / opt2;
        break;
      }
    }

    return result;
  }
}