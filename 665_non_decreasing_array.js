function checkPossibility(nums) {
  let count = 0;

  if (nums[0] > nums[1]) count++;
  for (let i = 1; i < nums.length - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      count++;
      if (nums[i - 1] <= nums[i + 1]) nums[i] = nums[i - 1];
      else nums[i + 1] = nums[i];
    }
    if (count > 1) return false;
  }

  return true;
}

console.log(checkPossibility([4, 2, 3]));
console.log(checkPossibility([4, 2, 1]));
console.log(checkPossibility([3, 4, 2, 3]));
console.log(checkPossibility([-1, 4, 2, 3]));
