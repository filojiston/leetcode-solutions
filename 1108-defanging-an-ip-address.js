function defangIPaddr(address) {
  return address.replace(/./g, "[.]");
}
