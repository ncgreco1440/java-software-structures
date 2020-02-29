package com.nicogreco.structures.leetcode.easy;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeNumberTest {
  private boolean isPalindrome(int i) {
    if (i < 0) return false;
    String s = Integer.valueOf(i).toString();
    int lastChar = s.length() - 1;
    int middle = (int)Math.floor(s.length() / 2);

    for (int j = 0; j < middle; j++) {
      if (s.charAt(j) != s.charAt(lastChar - j)) return false;
    }

    return true;
  }

  private boolean isIntPalindrome(int i) {
    if (i < 0) return false;
    
    long og = i;
    long rev = 0;
    while(i > 0) {
      rev = (rev * 10) + (i % 10);
      i /= 10;
    }

    if (rev > Integer.MAX_VALUE) {
      return false;
    }

    return rev == og;
  }
  
  @Test
  public void testPalindrome() {
    assertEquals(isIntPalindrome(56865), true);
  }

  @Test
  public void testNegativePalindrome() {
    assertEquals(isPalindrome(-56865), false);
  }

  @Test
  public void testNotPalindrome() {
    assertEquals(isIntPalindrome(568065), false);
  }
}