class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int val: prices){
            if(val<minPrice){
                minPrice = val;
            }
            else{
                if(val-minPrice > maxProfit)
                    maxProfit = val-minPrice;
            }
        }

        return maxProfit;
    }
}
