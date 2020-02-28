package com.nicogreco.structures.stack.algorithms;

import com.nicogreco.structures.stack.LinkedStack;

/**
 * Postfix Evaluator class for Integers only
 */
public class PostfixEval {
  private final static char ADD = '+';
  private final static char SUBTRACT = '-';
  private final static char MULTIPLY = '*';
  private final static char DIVIDE = '/';
  private final static char RAISE = '^';
  private LinkedStack<Double> stack;
  
  public PostfixEval() {
    this.stack = new LinkedStack<>();
  }

  /**
   * Converts an infix expression to a postfix expression
   */
  public String translate(String infix) {
    StringBuilder sb = new StringBuilder();
    LinkedStack<Character> operatorStack = new LinkedStack<>();

    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      if (Character.isLetterOrDigit(c)) {
        sb.append(c).append(' ');
      } else if (c == '(') {
        operatorStack.push(c);
      } else if (c == ')') {
        while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
          sb.append(operatorStack.pop()).append(' ');
        }

        if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
          throw new IllegalArgumentException();
        } else {
          operatorStack.pop();
        }
      } else {
        if (!Character.isWhitespace(c)) {
          while (!operatorStack.isEmpty() &&
            this.precendence(c) <= this.precendence(operatorStack.peek())) {
            sb.append(operatorStack.pop()).append(' ');
          }

          operatorStack.push(c);
        }
      }
    }

    while (!operatorStack.isEmpty()) {
      sb.append(operatorStack.pop()).append(' ');
    }

    return sb.toString().trim();
  }

  public double evaluate(String expression) {
    double opt1, opt2;
    double result = 0;
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
        stack.push(Double.parseDouble(token));
      }
    }

    return result;
  }

  public boolean isOperator(String token) {
    return token.charAt(0) == PostfixEval.ADD || token.charAt(0) == PostfixEval.SUBTRACT ||
      token.charAt(0) == PostfixEval.MULTIPLY || token.charAt(0) == PostfixEval.DIVIDE;
  }

  private int precendence(char operator) {
    switch (operator) {
      case ADD:
      case SUBTRACT: {
        return 1;
      }
      case MULTIPLY:
      case DIVIDE: {
        return 2;
      }
      case RAISE: {
        return 3;
      }
    }
    return -1;
  }

  private double evaluateOperation(char operation, double opt1, double opt2) {
    double result = 0;

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
      case RAISE: {
        result = Math.pow(opt1, opt2);
      }
    }

    return result;
  }
}