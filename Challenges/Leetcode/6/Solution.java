
//Breeland Abrams
//Leetcode #6: ZigZag Conversion

import java.lang.StringBuilder;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        int counter = 0;
        boolean increment = true;
        StringBuilder solution = new StringBuilder();
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new StringBuilder();
        }

        for (int j = 0; j < s.length(); j++) {
            strings[counter].append(s.charAt(j));
            if (counter == numRows - 1) {
                increment = !increment;
            }
            if (counter == 0) {
                increment = true;
            }
            if (increment) {
                counter++;
            } else {
                counter--;
            }
        }

        for (StringBuilder k : strings) {
            solution.append(k.toString());
        }

        return solution.toString();
    }
}