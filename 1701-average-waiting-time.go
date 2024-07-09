package main

import {
	"fmt"
}

// our base solution
func averageWaitingTime(customers [][]int) float64 {
	totalWait := 0
	totalOrderTime := customers[0][1]
	chef := customers[0][0] + customers[0][1]

	for i := 1; i < len(customers); i++ {
		totalOrderTime += customers[i][1]
		if chef > customers[i][0] {
			totalWait += chef - customers[i][0]
		} else {
			chef = customers[i][0]
		}
		chef += customers[i][1]
	}

	return float64((totalWait + totalOrderTime)) / float64(len(customers))
}

// chatgpt optimization version 1
func averageWaitingTime(customers [][]int) float64 {
	totalWait := 0
	totalOrderTime := 0
	chef := 0

	for _, customer := range customers {
		arrival, orderTime := customer[0], customer[1]
		if chef > arrival {
			totalWait += chef - arrival
		} else {
			chef = arrival
		}
		chef += orderTime
		totalOrderTime += orderTime
	}

	return float64(totalWait + totalOrderTime) / float64(len(customers))
}

// chatgpt optimization version 2
func averageWaitingTime(customers [][]int) float64 {
	totalWait, chef := 0, 0

	for _, customer := range customers {
		arrival, orderTime := customer[0], customer[1]
		chef = max(chef, arrival) + orderTime
		totalWait += chef - arrival
	}

	return float64(totalWait) / float64(len(customers))
}

func main() {
	fmt.Println(averageWaitingTime([][]int{{1, 2}, {2, 5}, {4, 3}}))
	fmt.Println(averageWaitingTime([][]int{{5, 2}, {5, 4}, {10, 3}, {20, 1}}))
}
