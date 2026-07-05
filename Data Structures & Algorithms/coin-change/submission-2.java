class Solution {
    HashMap<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        memo = new HashMap<>();
        return findMinChange(coins, amount);
    }

    public int findMinChange(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }

        if(amount < 0)
            return -1;

        if(memo.containsKey(amount))
            return memo.get(amount);

        int minCoin = -1;
        for(int val:coins){
            int coinsCount = findMinChange(coins, amount-val);
            if(coinsCount != -1){
                if(minCoin == -1)
                    minCoin = coinsCount+1;
                else
                    minCoin = Math.min(minCoin, coinsCount+1);
            }
        }
        memo.put(amount, minCoin);
        return minCoin;
    }
}
