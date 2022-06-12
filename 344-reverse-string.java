class Solution {
  public void reverseString(char[] s) {
    int mid = s.length / 2;

    for (int i = 0, j = s.length - 1; i < mid; i++, j--) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
    }
  }
}
