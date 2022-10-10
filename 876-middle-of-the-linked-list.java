class Solution {

  // i've solved it with counting the length of the list
  // and then iterating to the middle
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode iter = head;
        while (iter != null) {
            len++;
            iter = iter.next;
        }

        iter = head;
        int mid = len / 2;

        for (int i = 0; i < mid; i++) {
            iter = iter.next;
        }

        return iter;
    }

    // but it can be solved with two pointers, allowing to solve it in one pass
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
