import java.util.stream.Stream;

class Solution {
  // my initial solution.
  // after checking other peoples solution, i realized that i could've used only one array
  // and increment - decrement the count at indexes.
  // another way to solve this question that we can sort the strings and check if they're equal.
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;

    char[] sLetters = new char[26];
    char[] tLetters = new char[26];

    for (int i = 0; i < s.length(); i++) {
      int sIdx = s.charAt(i) - 'a';
      int tIdx = t.charAt(i) - 'a';
      sLetters[sIdx]++;
      tLetters[tIdx]++;
    }

    for (int i = 0; i < 26; i++) {
      if (sLetters[i] != tLetters[i])
        return false;
    }

    return true;
  }
}
