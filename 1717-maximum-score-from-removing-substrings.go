package main


import {
	"fmt"
}

func maxPointsRec(s string, x, y int, memo map[string]int) int {
	if val, exists := memo[s]; exists {
		return val
	}

	maxScore := 0
	n := len(s)

	for i := 0; i < n-1; i++ {
		if s[i] == 'a' && s[i+1] == 'b' {
			newStr := s[:i] + s[i+2:]
			maxScore = max(maxScore, x + maxPointsRec(newStr, x, y, memo))
		} else if s[i] == 'b' && s[i+1] == 'a' {
			newStr := s[:i] + s[i+2:]
			maxScore = max(maxScore, y + maxPointsRec(newStr, x, y, memo))
		}
	}

	memo[s] = maxScore
	return maxScore
}

func maximumGainRecursive(s string, x, y int) int {
	memo := make(map[string]int)
	return maxPointsRec(s, x, y, memo)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main1() {
	s := "cdbcbbaaabab"
	x := 4
	y := 5
	fmt.Println(maximumGainRecursive(s, x, y))
}

// -----------------------------------------------------------------------------------------------------------------

func maximumGain(s string, x, y int) int {
	first, second, firstValue, secondValue := determineOrder(x, y)
	firstPoints, newString := countPoints(s, first, firstValue)
	secondPoints, _ := countPoints(newString, second, secondValue)
	return firstPoints + secondPoints
}

func determineOrder(x, y int) (string, string, int, int) {
	if y > x {
		return "ba", "ab", y, x
	}
	return "ab", "ba", x, y
}

func countPoints(s string, match string, point int) (int, string) {
	stack := []rune{}
	points := 0

	for _, ch := range s {
		if len(stack) > 0 && stack[len(stack)-1] == rune(match[0]) && ch == rune(match[1]) {
			stack = stack[:len(stack)-1]
			points += point
		} else {
			stack = append(stack, ch)
		}
	}

	return points, string(stack)
}


func main() {
	s := "cdbcbbaaabab"
	x := 4
	y := 5
	fmt.Println(maximumGain(s, x, y))
}
