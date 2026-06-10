class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String curr:strs){
            int len = curr.length();
            result=result+len+"#"+curr;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> decoded= new ArrayList<>();
        int digitStart = 0, i=0;
        while(i<str.length()){
            if(str.charAt(i) == '#'){
                int length = Integer.parseInt(str.substring(digitStart,i));
                decoded.add(str.substring(i+1,i+1+length));
                i = i+length+1;
                digitStart = i;
            }
            else{
                i++;
            }
        }   
        return decoded;
    }
}
