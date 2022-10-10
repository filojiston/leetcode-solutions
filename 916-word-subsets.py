class Solution:
    def wordSubsets(self, words1, words2):
        max_count = [0] * 26
        for word in words2:
            for index, count in enumerate(self.count(word)):
                max_count[index] = max(max_count[index], count)

        result = []
        for word in words1:
            if all(letter_count_in_word >= letter_count_in_array
                   for letter_count_in_word, letter_count_in_array
                   in zip(self.count(word), max_count)):
                result.append(word)

        return result

    def count(self, word):
        result = [0] * 26
        for letter in word:
            result[ord(letter) - ord('a')] += 1
        return result


def test():
    solution = Solution()
    assert solution.wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], [
                                "e", "o"]) == ["facebook", "google", "leetcode"]
    assert solution.wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], [
                                "l", "e"]) == ["apple", "google", "leetcode"]
    assert solution.wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], [
                                "e", "oo"]) == ["facebook", "google"]
    assert solution.wordSubsets(["amazon", "apple", "facebook", "google", "leetcode"], [
                                "lo", "eo"]) == ["google", "leetcode"]


test()
