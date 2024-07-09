package main

import {
	"fmt"
}

// i knew i saw this problem before, with little research i've found it
// the josephus problem

// recursive solution
func findTheWinner(n int, k int) int {
	if n == 1 {
		return 1
	}
	return (k + findTheWinner(n - 1, k) - 1) % n + 1
}

// iterative solution
func findTheWinner(n int, k int) int {
	winner := 0
	for i := 1; i <= n; i++ {
		winner = (k + winner) % i
	}
	return winner + 1
}

func main() {
	fmt.Println(findTheWinner(5, 2))
}
