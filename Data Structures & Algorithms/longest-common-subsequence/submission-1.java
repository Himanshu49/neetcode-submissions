class Solution {
    HashMap<String, Integer> dp= new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        
        if(dp.containsKey(text1+" "+text2)){
            return dp.get(text1+" "+text2);
        }

        if(text1.charAt(0) == text2.charAt(0)){
            int lcs = longestCommonSubsequence(text1.substring(1), text2.substring(1));
            dp.put(text1+" "+text2, lcs+1);
            return lcs +1;
        }
        int left = longestCommonSubsequence(text1, text2.substring(1));
        int right = longestCommonSubsequence(text1.substring(1), text2);
        dp.put(text1+" "+text2, Math.max(left, right));
        return Math.max(left, right);
    }
}
