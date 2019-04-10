
//Breeland Abrams
//Leetcode #791: Custom Sort String

import java.util.HashSet;
import java.util.HashMap;
import java.lang.StringBuilder;

class SolutionQ2 {
  public String customSortString(String S, String T) {

    HashSet<Character> charSet = new HashSet<Character>();
    for (int i = 0; i < S.length(); i++) {
      charSet.add(S.charAt(i));
    }

    HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    StringBuilder solution = new StringBuilder();

    for (int j = 0; j < T.length(); j++) {
      if (charSet.contains(T.charAt(j))) {
        if (!charMap.containsKey(T.charAt(j))) {
          charMap.put(T.charAt(j), 1);
        } else {
          charMap.put(T.charAt(j), charMap.get(T.charAt(j)) + 1);
        }
      } else {
        solution.append(T.charAt(j));
      }
    }

    for (int k = S.length() - 1; k >= 0; k--) {

      if (charMap.containsKey(S.charAt(k))) {
        int temp = charMap.get(S.charAt(k));
        while (temp > 0) {
          solution.insert(0, S.charAt(k));
          temp--;
        }
      }

    }

    return solution.toString();
  }
}