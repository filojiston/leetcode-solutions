// reversed string should not contain leading or trailing space
// reduce multiple spaces between the words to single when reversing
// 1 <= s.length <= 10^4
// s contains english letters (upper-lower case), digits and spaces

function reverseWords(s) {
  return s.trim().split(/\s+/g).reverse().join(" ");
}

console.log(reverseWords("  hello world  "));
console.log(reverseWords("a good   example"));
