import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Long> occurances = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return occurances.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }
}
