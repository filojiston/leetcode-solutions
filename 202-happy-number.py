# this solution uses like cycle detection algo in linked list, turtoise and hare and i like it
def getSumOfSquaredDigits(n):
    sum = 0
    while n:
        sum += (n % 10) ** 2
        n //= 10
    return sum

def isHappy(n):
    slow = n
    fast = n
    while True:
        slow = getSumOfSquaredDigits(slow)
        fast = getSumOfSquaredDigits(getSumOfSquaredDigits(fast))
        if slow == fast:
            break

    return slow == 1

# hashing solution seems like good one either
def isHappy(n):
    hash = []
    while n != 1:
        if n in hash:
            return False
        hash.append(n)
        n = getSumOfSquaredDigits(n)
    return True


print(isHappy(13))
print(isHappy(19))
print(isHappy(2))
