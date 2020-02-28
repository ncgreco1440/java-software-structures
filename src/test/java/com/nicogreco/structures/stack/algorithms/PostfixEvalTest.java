package com.nicogreco.structures.stack.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class PostfixEvalTest {
  @Test
  public void testPostFixEvalShouldEvaluate() {
    PostfixEval eval = new PostfixEval();

    int res = eval.evaluate("3 5 5 * *");

    assertEquals(res, 75d, 0d);
  }
}