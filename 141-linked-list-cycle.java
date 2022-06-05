public class Solution {
  public boolean hasCycle(ListNode head) {
    // detect has cycle with two pointers
    if (head == null || head.next == null) {
      return false;
    }

    ListNode turtoise = head;
    ListNode hare = head.next;

    while (turtoise != hare) {
      if (hare == null || hare.next == null) {
        return false;
      }

      turtoise = turtoise.next;
      hare = hare.next.next;
    }

    return true;
  }
}
