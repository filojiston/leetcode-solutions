function validIPAddress(IP) {
  return isValidIPv4(IP) ? "IPv4" : isValidIPv6(IP) ? "IPv6" : "Neither";
}

function isValidIPv4(IP) {
  const octets = IP.split(".");
  if (octets.length !== 4) return false;
  for (let i = 0; i < octets.length; i++) {
    let current = octets[i];
    // it cant be 00 or 000
    if (current.length === 0) return false
    if (current.length > 1 && current.startsWith("0")) return false;
    // it should be an integer between 0 and 255 inclusive
    for (let j = 0; j < current.length; j++) {
      const currLetter = current[j].charCodeAt(0);
      if (!(currLetter >= 48 && currLetter <= 57)) return false;
    }
    current = +current;
    if (!(current >= 0 && current <= 255)) return false;
  }

  return true;
}

function isValidIPv6(IP) {
  const segments = IP.split(":");
  if (segments.length !== 8) return false;
  for (let i = 0; i < segments.length; i++) {
    let current = segments[i];
    let n = current.length;
    // length must be 1-4 inclusive
    if (!(n >= 1 && n <= 4)) return false;
    // it must be hexadecimal string
    for (let j = 0; j < current.length; j++) {
      const currLetter = current[j].toLowerCase().charCodeAt(0);
      if (
        !(currLetter >= 48 && currLetter <= 57) &&
        !(currLetter >= 97 && currLetter <= 102)
      )
        return false;
    }
  }

  return true;
}

console.log(validIPAddress("192.168.1.1"));
console.log(validIPAddress("192.168.1.0"));
console.log(validIPAddress("192.168.1.00"));
console.log(validIPAddress("192.168@1.1"));
console.log(validIPAddress("172.16.254.1"));
console.log(validIPAddress("1.0.1."));
console.log(validIPAddress("1.1.1.1."));
console.log(validIPAddress("1e1.4.5.6"));
console.log(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
console.log(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
