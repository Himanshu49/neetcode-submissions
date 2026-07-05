class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int arr[]: dp){
            Arrays.fill(arr, -1);
        }
        return numOfWays(0, amount, coins);
    }

    public int numOfWays(int pos, int amount, int[] coins){
        if(amount == 0)
            return 1;
        
        if(amount<0 || pos >= coins.length)
            return 0;

        if(dp[pos][amount] == -1){    
            int include = numOfWays(pos, amount - coins[pos], coins);
            int exclude = numOfWays(pos+1, amount, coins);
            dp[pos][amount] = include+exclude;
        }

        return dp[pos][amount];
    }
}
