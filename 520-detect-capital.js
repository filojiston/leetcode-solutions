function detectCapitalUse(word) {
  return isAllCapital(word) || isAllLowercase(word) || isOnlyFirstLetterCapital(word);
}

function isAllCapital(word) {
  return word.split('').every(letter => letter == letter.toUpperCase());
}

function isAllLowercase(word) {
  return word.split('').every(letter => letter == letter.toLowerCase());
}

function isOnlyFirstLetterCapital(word) {
  const firstLetter = word[0];
  word = word.substring(1);
  return firstLetter == firstLetter.toUpperCase() && isAllLowercase(word)
}
