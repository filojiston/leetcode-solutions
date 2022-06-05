// https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/1774701/Golang-solution
// i liked that two pointer usage, nice and clean solution
func removeDuplicates(nums []int) int {
    l, r := 0, 0

    for r < len(nums) {
        if nums[l] != nums[r] {
            l++
            nums[l], nums[r] = nums[r], nums[l]
        }
        r++
    }

    return l + 1
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/1771611/Go-Concise
// this one is good too, it's bit hard to understand at first
// but when you understood, it's clean and concise
func removeDuplicates(nums []int) int {
	i := 0
	for _, v := range nums {
		if i == 0 || nums[i-1] < v {
			nums[i] = v
			i++
		}
	}
	return i
}
