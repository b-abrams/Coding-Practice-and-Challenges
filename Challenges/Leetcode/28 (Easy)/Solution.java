//Breeland Abrams
//Leetcode #28: Implement strStr
class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.equals("") || haystack.equals(needle))
      return 0;
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        if (i + needle.length() < haystack.length() + 1) {
          if (String.valueOf((Arrays.copyOfRange(haystack.toCharArray(), i, i + needle.length()))).equals(needle)) {
            return i;
          }
        }
      }
    }

    return -1;

  }
}