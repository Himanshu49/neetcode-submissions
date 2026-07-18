class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int count[] = new int[256];
        int count2[] = new int[256];
        if(s1.length() > s2.length())
            return false;

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }

        int req=0;

        for(int i=0;i<256;i++){
            if(count[i] == count2[i])
                req++;
        }

        int l=0,r=s1.length();
        while(r<s2.length()){
            if(req == 256)
                return true;
            count2[s2.charAt(l)]--;
            if(count[s2.charAt(l)] == count2[s2.charAt(l)]+1)
                req--;
            else if(count[s2.charAt(l)] == count2[s2.charAt(l)])
                req++;
            l++;
            count2[s2.charAt(r)]++;
            if(count[s2.charAt(r)] == count2[s2.charAt(r)]-1)
                req--;
            else if(count[s2.charAt(r)] == count2[s2.charAt(r)])
                req++;
            r++;
        }
        return req == 256;
    }
}
