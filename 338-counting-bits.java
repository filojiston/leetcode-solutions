import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[] countBits(int n) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      result.add(Integer.bitCount(i));
    }

    return result.stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }
}
