class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        int occurance[] = new int[256];
        Arrays.fill(occurance, -1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(occurance[ch] >= l){
                l = occurance[ch]+1;
            }
            occurance[ch] = i;
            max = Math.max(max, i-l+1);
        }

        return max;
    }
}
