class Solution {
    int memo[] = new int[100];
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        
        if(memo[n] == 0)
            memo[n] = climbStairs(n-1)+climbStairs(n-2);
        return memo[n];
    }
}
