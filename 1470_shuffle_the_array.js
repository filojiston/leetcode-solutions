function shuffle(nums, n) {
  const result = [];
  const firstHalf = nums.slice(0, nums.length / 2);
  const secondHalf = nums.slice(nums.length / 2);

  for (let i = 0; i < firstHalf.length; i++) {
    result.push(firstHalf[i]);
    result.push(secondHalf[i]);
  }

  return result;
}

console.log(shuffle([2, 5, 1, 3, 4, 7], 3), [2, 3, 5, 4, 1, 7]);
