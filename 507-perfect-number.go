func checkPerfectNumber(num int) bool {
  sum := 1
  for i := 2; i * i <= num; i++ {
    if (num % i == 0) {
      sum += i
      if (i * i != num) {
        sum += num / i
      }
    } 
  }    

  return sum == num && num != 1
}

// that'a a good solution too
func pn (p int) int {
  return (1 << (p - 1)) * ((1 << p) - 1) // 2^p-1 * (2^p)-1
}

func checkPerfectNumber(num int) bool {
  primes := [...]int{2, 3, 5, 7, 13, 17, 19, 31}
  for _, v := range primes {
    if pn(v) == num {
      return true
    }
  }

  return false
}
