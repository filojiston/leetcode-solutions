package main

import (
	"fmt"
)

func minOperations(logs []string) int {
	distance := 0

	for _, log := range logs {
		if log == "../" {
			if distance > 0 {
				distance--
			}
		} else if log != "./" {
			distance++
		}
	}

	return distance
}


func main() {
	fmt.Println(minOperations([]string{"d1/", "d2/", "../", "d21/", "./"}))
	fmt.Println(minOperations([]string{"d1/", "d2/", "./", "d3/", "../", "d31/"}))
}
