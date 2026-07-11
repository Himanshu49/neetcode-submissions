class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int l=0,r=0,res=1;
        while(r < s.length()){
            count[s.charAt(r) - 'A']++;
            int max=0;
            for(int val: count){
                max= Math.max(val, max);
            }

            if(r-l+1 - max <= k){
                // valid window
                res = Math.max(r-l+1, res);
                r++;
            }
            else{
                count[s.charAt(l) - 'A']--;
                l++;
                r++;
            }
        }
        return res;
    }
}
