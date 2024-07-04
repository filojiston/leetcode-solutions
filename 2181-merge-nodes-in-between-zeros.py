from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeNodes(self, head:Optional[ListNode]) -> Optional[ListNode]:
        result = iterator = ListNode(0)
        curr_val = 0

        while (head := head.next) is not None:
            if head.val == 0:
                iterator.next = ListNode(curr_val)
                iterator = iterator.next
                curr_val = 0
            else:
                curr_val += head.val

        return result.next


sol = Solution()
head = ListNode(0, ListNode(3, ListNode(1, ListNode(0, ListNode(4, ListNode(5, ListNode(2, ListNode(0))))))))

result = sol.mergeNodes(head)
print(result)
