//Breeland Abrams
//Leetcode #3: Longest Substring Without Repeating Characters

class Solution
{
public:
  int lengthOfLongestSubstring(string s)
  {
    if (s == "")
      return 0;
    if (s.length() == 1)
      return 1;
    string sol = "";
    int j;
    for (int i = 0; i < s.length() - 1; i++)
    {
      j = i;
      string temp = "";
      while (temp.find(s[j]) == std::string::npos && j < s.length())
      {
        temp.push_back(s[j]);
        j++;
      }

      if (temp.length() > sol.length())
      {
        sol = temp;
      }
    }
    return sol.length();
  }
};