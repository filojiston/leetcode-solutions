func maximumUnits(boxTypes [][]int, truckSize int) int {
  // sort by box sizes, so we can select boxes contains more items
  sort.Slice(boxTypes, func(i , j int) bool {
    return boxTypes[i][1] > boxTypes[j][1]
  })      

  // always get the first box and add it to the truck
  result := 0
  for boxesInTruck := 0; boxesInTruck < truckSize; boxesInTruck++ {
    result += boxTypes[0][1]
    boxTypes[0][0]--

    if (boxTypes[0][0] == 0) {
      boxTypes = boxTypes[1:]
    } 

    if (len(boxTypes) == 0) {
      break
    }
  }
  
  return result
}

