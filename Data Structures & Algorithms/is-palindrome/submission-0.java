class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            char ch = s.charAt(i);
            while(i<j && !((ch >= 'A' && ch<='Z') 
            || (ch>='a' && ch<='z') || (ch>='0' && ch<='9'))){
                i++;
                ch = s.charAt(i);
            }
            ch = s.charAt(j);
            while(j>i && !((ch >= 'A' && ch<='Z') 
            || (ch>='a' && ch<='z') || (ch>='0' && ch<='9'))){
                j--;
                ch = s.charAt(j);
            }
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
