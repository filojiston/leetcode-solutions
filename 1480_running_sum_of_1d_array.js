function runningSum(nums) {
  return nums.map((num, idx) => sum(nums.slice(0, idx + 1)));
}

const sum = arr => arr.reduce((a, b) => a + b);

console.log(runningSum([1, 2, 3, 4]));
console.log(runningSum([1, 1, 1, 1, 1]));
