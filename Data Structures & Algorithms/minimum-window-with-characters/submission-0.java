class Solution {
    public String minWindow(String s, String t) {
        int countS[] = new int[256];
        int countT[] = new int[256];

        for(int i=0;i<t.length();i++){
            countT[t.charAt(i)]++;
        }

        int l =0,r=0, minSize = Integer.MAX_VALUE;
        String res = "";
        while(r<=s.length()){
            if(isPossible(countS, countT)){
                if(r-l+1 < minSize){
                    minSize = r-l+1;
                    res = s.substring(l,r);
                }
                countS[s.charAt(l)]--;
                l++;
            }
            else{
                if(r == s.length())
                    break;
                countS[s.charAt(r)]++;
                r++;
            }
        }
        return res;
    }

    public boolean isPossible(int[] countS, int[] countT){
        for(int i=0;i<256;i++){
            if(countT[i] > countS[i])
                return false;
        }
        return true;
    }
}
