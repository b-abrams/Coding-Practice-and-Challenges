// Breeland Abrams
// Leetcode #13: Roman to Integer
class Solution {
  public int romanToInt(String s) {
    int solution = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'I') {
        solution += 1;
      } else if (s.charAt(i) == 'V') {
        solution += 5;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'I') {
            solution -= 6;
            solution += 4;
          }
        }

      } else if (s.charAt(i) == 'X') {
        solution += 10;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'I') {
            solution -= 11;
            solution += 9;
          }
        }
      } else if (s.charAt(i) == 'L') {
        solution += 50;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'X') {
            solution -= 60;
            solution += 40;
          }
        }
      } else if (s.charAt(i) == 'C') {
        solution += 100;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'X') {
            solution -= 110;
            solution += 90;
          }
        }
      } else if (s.charAt(i) == 'D') {
        solution += 500;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'C') {
            solution -= 600;
            solution += 400;
          }
        }
      } else if (s.charAt(i) == 'M') {
        solution += 1000;
        if (s.length() > 1 && i != 0) {
          if (s.charAt(i - 1) == 'C') {
            solution -= 1100;
            solution += 900;
          }
        }
      }

    }

    return solution;
  }
}