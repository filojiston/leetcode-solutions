class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        var lPtr = 0;
        var maximumProfit = 0;
        for (var rPtr = 1; rPtr < prices.length; rPtr++) {
            if (prices[lPtr] < prices[rPtr]) {
                var currentProfit = prices[rPtr] - prices[lPtr];
                maximumProfit = Math.max(maximumProfit, currentProfit);
            } else {
                lPtr = rPtr;
            }
        }

        return maximumProfit;
    }
}
