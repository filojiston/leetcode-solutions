from typing import Optional, List

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        def isCriticalPoint(prev, curr, next):
            return (curr.val < prev.val and curr.val < next.val) or (curr.val > prev.val and curr.val > next.val)

        criticalPoints = []
        idx = 1
        prev, curr = head, head.next

        while curr and curr.next:
            if isCriticalPoint(prev, curr, curr.next):
                criticalPoints.append(idx)
            prev, curr = curr, curr.next
            idx += 1

        if len(criticalPoints) < 2:
            return [-1, -1]

        minDiff = min(b - a for a, b in zip(criticalPoints, criticalPoints[1:]))
        maxDiff = criticalPoints[-1] - criticalPoints[0]
        return [minDiff, maxDiff]



sol = Solution()
test1 = ListNode(5, ListNode(3, ListNode(1, ListNode(2, ListNode(5, ListNode(1, ListNode(2)))))))
test2 = ListNode(1, ListNode(3, ListNode(2, ListNode(2, ListNode(3, ListNode(2, ListNode(2, ListNode(2, ListNode(7)))))))))

print(sol.nodesBetweenCriticalPoints(test1))
print(sol.nodesBetweenCriticalPoints(test2))
