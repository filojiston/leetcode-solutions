package main

import {
	"fmt"
}

func reverseString(s string) string {
    runes := []rune(s)
    for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
        runes[i], runes[j] = runes[j], runes[i]
    }
    return string(runes)
}

func reverseParentheses(s string) string {
    if openIndex := strings.LastIndex(s, "("); openIndex != -1 {
        closeIndex := strings.Index(s[openIndex:], ")") + openIndex
        return reverseParentheses(s[:openIndex] + reverseString(s[openIndex+1:closeIndex]) + s[closeIndex+1:])
    }
    return s
}

func main() {
	fmt.Println(reverseParentheses("(u(love)i)"))
	fmt.Println(reverseParentheses("(ed(et(oc))el)"))
}
