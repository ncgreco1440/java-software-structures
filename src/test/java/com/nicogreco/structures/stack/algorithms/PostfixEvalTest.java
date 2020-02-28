package com.nicogreco.structures.stack.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class PostfixEvalTest {
  @Test
  public void testPostFixEvalShouldEvaluate() {
    PostfixEval eval = new PostfixEval();

    double res = eval.evaluate("3 5 5 * *");

    assertEquals(res, 75d, 0d);
  }

  @Test
  public void testInfixToPostfixTranslation() {
    PostfixEval eval = new PostfixEval();
    String result = "3 5 8 * +";

    String postfixExpr = eval.translate("3 + 5 * 8");

    assertEquals(postfixExpr, result);
  }

  @Test
  public void testInfixToPostfixTranslationWithParenthesis() {
    PostfixEval eval = new PostfixEval();
    String result = "3 5 + 8 *";

    String postfixExpr = eval.translate("(3+5)*8");

    assertEquals(postfixExpr, result);
  }
  
  @Test
  public void testInfixToPostfixGeeksForGeeksExpression() {
    PostfixEval eval = new PostfixEval();
    String result = "a b c d ^ e - f g h * + ^ * + i -";

    String postfixExpr = eval.translate("a + b * (c ^ d - e) ^ (f + g * h) - i");

    assertEquals(postfixExpr, result);
  }

  @Test
  public void testInfixToPostfixEnd2End() {
    PostfixEval eval = new PostfixEval();
    String infix = "(3 * 4 - (2 + 5)) * 4 / 2";

    String postfixExpr = eval.translate(infix);
    double ans = eval.evaluate(postfixExpr);

    assertEquals(ans, 10d, 0d);
  }
}