import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
  public boolean isPalindrome(ListNode head) {
    List<Integer> values = new ArrayList<>();

    ListNode iter = head;
    while (iter != null) {
      values.add(iter.val);
      iter = iter.next;
    }

    List<Integer> valuesOriginal = values.stream().collect(Collectors.toList());
    Collections.reverse(values);

    return valuesOriginal.equals(values);
  }
}
