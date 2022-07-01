class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        sorted_s = ''.join(sorted(s))
        sorted_t = ''.join(sorted(t))

        counter = 0

        while counter < len(sorted_s):
            if not sorted_s[counter] == sorted_t[counter]:
                return sorted_t[counter]

            counter += 1

        return sorted_t[counter]
        
