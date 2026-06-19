class Solution {
    int dp[][] = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        
        if(dp[text1.length()][text2.length()] != 0){
            return dp[text1.length()][text2.length()] == -1?0:dp[text1.length()][text2.length()];
        }

        if(text1.charAt(0) == text2.charAt(0)){
            int lcs = longestCommonSubsequence(text1.substring(1), text2.substring(1));
            dp[text1.length()][text2.length()] = lcs+1;
            return lcs +1;
        }
        int left = longestCommonSubsequence(text1, text2.substring(1));
        int right = longestCommonSubsequence(text1.substring(1), text2);
        dp[text1.length()][text2.length()] = Math.max(left, right);
        return dp[text1.length()][text2.length()];
    }
}
