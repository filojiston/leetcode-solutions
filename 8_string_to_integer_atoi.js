/*  ALGORITHM
  1- Read in and ignore any leading whitespace.
  2- Check if the next character (if not already at the end of the string) is '-'
   or '+'. Read this character in if it is either. This determines if the final
   result is negative or positive respectively. Assume the result is positive if
   neither is present.
  3- Read in next the characters until the next non-digit charcter or the end of
   the input is reached. The rest of the string is ignored.
  4- Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
  If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
  5- If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
  then clamp the integer so that it remains in the range. Specifically,
  integers less than -231 should be clamped to -231,
  and integers greater than 231 - 1 should be clamped to 231 - 1.
  6- Return the integer as the final result.

  0 <= s.length <= 200
  s includes upper-lower eng. characters, digits, ' ', '+', '-' '.'
*/

function myAtoi(s) {
  // helper functions
  function isDigit(ch) {
    return ch >= "0" && ch <= "9";
  }
  function isSign(ch) {
    return ch == "-" || ch == "+";
  }

  // constants - i guess i need to calculate
  const MAX_INT = Math.pow(2, 31) - 1;
  const MIN_INT = Math.pow(-2, 31);

  // logic goes here
  let charactersRead = "";
  let isDigitRead = false;
  let isSignRead = false;
  let isNegative = false;
  let isFirstCharacterRead = false;

  for (let i = 0; i < s.length; i++) {
    const current = s[i];
    if (isDigitRead) {
      if (!isDigit(current)) break;
      charactersRead += current;
      isFirstCharacterRead = true;
    } else {
      if (isDigit(current)) {
        charactersRead += current;
        isDigitRead = true;
      } else if (current == " " && !isFirstCharacterRead) {
        continue;
      } else if (isSign(current)) {
        if (isSignRead) break;
        else {
          if (current == "-") isNegative = true;
          isSignRead = true;
          isFirstCharacterRead = true;
        }
      } else {
        break;
      }
    }
  }

  const actualNumber = isNegative ? +charactersRead * -1 : +charactersRead;

  if (actualNumber > MAX_INT) return MAX_INT;
  if (actualNumber < MIN_INT) return MIN_INT;
  return actualNumber;
}

// number.parseInt version
function myAtoi(s) {
  const MAX_INT = Math.pow(2, 31) - 1;
  const MIN_INT = Math.pow(-2, 31);

  const result = Number.parseInt(s);
  if (Number.isNaN(result)) return 0;
  if (result > MAX_INT) return MAX_INT;
  if (result < MIN_INT) return MIN_INT;
  return result;
}

console.log(myAtoi("   -42"));
