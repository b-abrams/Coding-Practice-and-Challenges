
/*
  Breeland Abrams
  Leetcode 49: Group Anagrams
*/

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

    int[] count = new int[26];
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    for (int i = 0; i < strs.length; i++) {
      Arrays.fill(count, 0);
      for (char c : strs[i].toCharArray()) {
        count[c - 97] += 1;
      }

      if (map.get(Arrays.toString(count)) != null) {
        map.get(Arrays.toString(count)).add(strs[i]);
        continue;
      }
      map.put(Arrays.toString(count), new ArrayList<String>(Arrays.asList(strs[i])));

    }

    return new ArrayList<>(map.values());
  }
}